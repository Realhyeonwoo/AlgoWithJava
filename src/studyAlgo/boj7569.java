import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Poss {
	int h;
	int y;
	int x;
	
	Poss(int h, int y, int x) {
		this.h = h;
		this.y = y;
		this.x = x;
	}
}

public class boj7569 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로
		int H = Integer.parseInt(st.nextToken()); // 높이
		int[][][] arr = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		Queue<Poss> q = new LinkedList<>();
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[h][i][j] = Integer.parseInt(st.nextToken());
					if(arr[h][i][j] == 1) {
						q.add(new Poss(h, i, j));
						visited[h][i][j] = true;
					}
				}
			}
		}
		
		int[] dh = {0, 0, 0, 0, 1, -1};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dx = {1, -1, 0, 0, 0, 0};
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				Poss p = q.poll();
				int h = p.h;
				int y = p.y;
				int x = p.x;
				for(int dir=0; dir<6; dir++) {
					int nh = h + dh[dir];
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					
					if(nh<0 || nh>=H || ny<0 || ny>=N || nx<0 || nx>=M) continue;
					if(visited[nh][ny][nx]) continue;
					if(arr[nh][ny][nx] == -1) continue;
					
					visited[nh][ny][nx] = true;
					arr[nh][ny][nx] = 1;
					q.add(new Poss(nh, ny, nx));
				}
			}
			
			if(!q.isEmpty()) cnt++;
		}
		
		boolean isFail = false;
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visited[h][i][j] && arr[h][i][j] == 0) {
						isFail = true;
					}
				}
			}
		}
		
		if(isFail) System.out.println(-1);
		else System.out.println(cnt);
	}
}
