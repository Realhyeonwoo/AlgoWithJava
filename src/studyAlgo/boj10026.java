import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int y;
	int x;
	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class boj10026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		char[][] arr2 = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
				arr2[i][j] = str.charAt(j);
				if(arr2[i][j] == 'R') arr2[i][j] = 'G';
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				cnt++;
				char c = arr[i][j];
				Queue<Pos> q = new LinkedList<>();
				visited[i][j] = true;
				q.add(new Pos(i, j));
				while(!q.isEmpty()) {
					Pos p = q.poll();
					int y = p.y;
					int x = p.x;
					for(int dir=0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
						if(visited[ny][nx] || arr[ny][nx] != c) continue;
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx));
					}
				}
			}
		}
		sb.append(cnt + " ");
		
		for(int i=0; i<N; i++)
			Arrays.fill(visited[i], false);
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				cnt++;
				char c = arr2[i][j];
				Queue<Pos> q = new LinkedList<>();
				visited[i][j] = true;
				q.add(new Pos(i, j));
				while(!q.isEmpty()) {
					Pos p = q.poll();
					int y = p.y;
					int x = p.x;
					for(int dir=0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
						if(visited[ny][nx] || arr2[ny][nx] != c) continue;
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx));
					}
				}
			}
		}
		sb.append(cnt);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
