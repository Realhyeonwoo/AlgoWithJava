import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Posi {
	int y;
	int x;
	
	Posi(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class boj1012 {
	static int T, M, N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 갯수
			
			int[][] arr = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			
			int[] dy = {0, 0, 1, -1};
			int[] dx = {1, -1, 0, 0};
			
			Queue<Posi> q = new LinkedList<>();
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 0 || visited[i][j]) continue;
					cnt++;
					q.add(new Posi(i, j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						Posi p = q.poll();
						int y = p.y;
						int x = p.x;
						
						for(int dir=0; dir<4; dir++) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];
							
							if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
							if(visited[ny][nx] || arr[ny][nx] == 0) continue;
							q.add(new Posi(ny, nx));
							visited[ny][nx] = true;
						}
					}
				}
			}
			
			System.out.println(cnt);
		}
		
		
	}
}
