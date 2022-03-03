import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pose {
	int y;
	int x; 
	
	Pose(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class boj1926 {
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(ans);
	}

	private static void bfs(int row, int col) {
		Queue<Pose> q = new LinkedList<>();
		q.add(new Pose(row, col));
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Pose p = q.poll();
			int y = p.y;
			int x = p.x;
			visited[y][x] = true;
			cnt++;
			for(int dir=0; dir<4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
				if(arr[ny][nx] == 1 && !visited[ny][nx]) {
					q.add(new Pose(ny, nx));
					visited[ny][nx] = true;
				}
			}
			if(cnt > ans) ans = cnt;
		}
	}
}
