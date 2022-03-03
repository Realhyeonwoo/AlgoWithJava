import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			char[][] arr = new char[h][w];
			int[][] fireMap = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			for(int i=0; i<h; i++)
				Arrays.fill(fireMap[i], -1);
			Queue<Pos> q = new LinkedList<>();
			Queue<Pos> fireQ = new LinkedList<>();
			for(int i=0; i<h; i++) {
				String str = br.readLine();
				for(int j=0; j<w; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j] == '*') {
						fireQ.add(new Pos(i, j));
						fireMap[i][j] = 0;
					}
					if(arr[i][j] == '@') {
						q.add(new Pos(i, j));
						visited[i][j] = true;
					}
				}
			}
			
			int[] dy = {0, 0, 1, -1};
			int[] dx = {1, -1, 0, 0};
			
			// 불 퍼트리자
			int cnt = 1;
			while(!fireQ.isEmpty()) {
				int qSize = fireQ.size();
				for(int i=0; i<qSize; i++) {
					Pos p = fireQ.poll();
					int y = p.y;
					int x = p.x;
					
					for(int dir=0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=h || nx<0 || nx>=w) continue;
						if(arr[ny][nx] == '#') continue;
						if(fireMap[ny][nx] != -1) continue;
						
						fireQ.add(new Pos(ny, nx));
						fireMap[ny][nx] = cnt;
					}
				}
				cnt++;
			}

			// 불 확인
//			System.out.println();
//			for(int i=0; i<h; i++) {
//				for(int j=0; j<w; j++) {
//					System.out.print(fireMap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			int time = 1;
			boolean isOver = false;
			while(!q.isEmpty()) {
				int qSize = q.size();
				for(int i=0; i<qSize; i++) {
					Pos p = q.poll();
					int y = p.y;
					int x = p.x;
					
					for(int dir=0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=h || nx<0 || nx>=w) {
							isOver = true;
							break;
						}
						if(arr[ny][nx] == '#' || visited[ny][nx]) continue;
						if(fireMap[ny][nx] != -1 && fireMap[ny][nx] <= time) continue;
						
						q.add(new Pos(ny, nx));
						visited[ny][nx] = true;
					}
					if(isOver) {
						sb.append(time + "\n");
						q.clear();
						break;
					}
				}
				
				if(!q.isEmpty()) time++; 
				else if(!isOver) sb.append("IMPOSSIBLE\n");
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}
