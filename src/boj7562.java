import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			Pos startPos = new Pos(startY, startX);
			st = new StringTokenizer(br.readLine());
			Pos endPos = new Pos (Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
			int[] dy = {-1, -1, -2, -2, 1, 1, 2, 2};
			int[] dx = {2, -2, 1, -1, 2, -2, 1, -1};
			
			int cnt = 0;
			if(startPos.y == endPos.y && startPos.x == endPos.x) {
				System.out.println(cnt);
				continue;
			}
			Queue<Pos> q = new LinkedList<>();
			q.add(startPos);
			while(!q.isEmpty()) {
				int qSize = q.size();
				boolean isEnd = false;
				for(int i=0; i<qSize; i++) {
					Pos p = q.poll();
					int y = p.y;
					int x = p.x;
					for(int dir=0; dir<8; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
						if(visited[ny][nx]) continue;
						if(ny == endPos.y && nx == endPos.x) {
							isEnd = true;
							cnt++;
							break;
						}
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx));
					}
					if(isEnd) {
						q.clear();
						break;
					}
				}
				if(!q.isEmpty()) cnt++;
			}
			
			System.out.println(cnt);
			
		}
	}
}
