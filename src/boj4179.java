import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pose {
	int y, x;
	Pose(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class boj4179 {
	static int R, C;
	static int[][] fireMap;
	static char[][] arr;
	static boolean[][] visited;
	static Queue<Pose> q = new LinkedList<>();
	static Queue<Pose> fireQ = new LinkedList<>();
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		fireMap = new int[R][C];
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) 
			Arrays.fill(fireMap[i], -1);
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'F') {
					fireQ.add(new Pose(i, j));
					fireMap[i][j] = 0;
				}
				if(arr[i][j] == 'J') {
					q.add(new Pose(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		int fireTime = 1;
		while(!fireQ.isEmpty()) {
			int qSize = fireQ.size();
			for(int i=0; i<qSize; i++) {
				Pose p = fireQ.poll();
				int y = p.y;
				int x = p.x;
				
				for(int dir=0; dir<4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					
					if(ny<0 || ny>=R || nx<0 || nx>=C) continue;
					if(fireMap[ny][nx] >= 0 || arr[ny][nx] == '#') continue;
					fireMap[ny][nx] = fireTime;
					fireQ.add(new Pose(ny, nx));
				}
			}
			fireTime++;
		}
		
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(fireMap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int time = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				Pose p = q.poll();
				int y = p.y;
				int x = p.x;
				
				for(int dir=0; dir<4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					
					if(ny<0 || ny>=R || nx<0 || nx>=C) {
						System.out.println(time);
						System.exit(0);
					}
					
					if(visited[ny][nx] || arr[ny][nx] == '#') continue;
					if(fireMap[ny][nx] != -1 && fireMap[ny][nx] <= time) continue;
					
					visited[ny][nx] = true;
					q.add(new Pose(ny, nx));
				}
			}
			time++;
		}
		
		System.out.println("IMPOSSIBLE");
		
	}
}
