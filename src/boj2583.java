import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2583 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][N];
		for(int i=0; i<M; i++)
			Arrays.fill(arr[i], 0);
		boolean[][] visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					arr[y][x] = 1;
				}
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		ArrayList<Integer> ansList = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] || arr[i][j] == 1) continue;
				
				Queue<Pos> q = new LinkedList<>();
				visited[i][j] = true;
				q.add(new Pos(i, j));
				int cnt = 1;
				while(!q.isEmpty()) {
					Pos p = q.poll();
					int y = p.y;
					int x = p.x;
					
					for(int dir=0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=M || nx<0 || nx>=N) continue;
						if(visited[ny][nx] || arr[ny][nx] == 1) continue;
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx));
						cnt++;
					}
				}
				ansList.add(cnt);		
			}
		}
		
		Collections.sort(ansList);
		sb.append(ansList.size()+"\n");
		for(int v : ansList)
			sb.append(v + " ");

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
