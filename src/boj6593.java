import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import studyAlgo.Pos3D;

public class boj6593 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break;
			
			char[][][] arr = new char[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			Pos3D start;
			Queue<Pos3D> q = new LinkedList<>();
			for(int l=0; l<L; l++) {
				for(int y=0; y<R; y++) {
					String str = br.readLine();
					for(int x=0; x<C; x++) {
						arr[l][y][x] = str.charAt(x);
						if(arr[l][y][x] == 'S') {
							start = new Pos3D(l, y, x);
							q.add(new Pos3D(l, y, x));
							visited[l][y][x] = true;
						}
					}
				}
				br.readLine();
			}
			
			int[] dl = {0, 0, 0, 0, 1, -1};
			int[] dy = {0, 0, 1, -1, 0, 0}; 
			int[] dx = {1, -1, 0, 0, 0, 0};
			
			int cnt = 1;
			boolean isArrived = false;
			while(!q.isEmpty()) {
				int qSize = q.size();
				for(int i=0; i<qSize; i++) {
					Pos3D p = q.poll();
					for(int dir=0; dir<6; dir++) {
						int nl = p.l + dl[dir];
						int ny = p.y + dy[dir];
						int nx = p.x + dx[dir];
						
						if(nl<0 || nl>=L || ny<0 || ny>=R || nx<0 || nx>=C) continue;
						if(visited[nl][ny][nx]) continue;
						if(arr[nl][ny][nx] == '#') continue;
						
						if(arr[nl][ny][nx] == 'E') {
							isArrived = true;
							break;
						}
						
						visited[nl][ny][nx] = true;
						q.add(new Pos3D(nl, ny, nx));
					}
				}
				if(isArrived) break;
				if(!q.isEmpty()) cnt++;
			}
			
			if(isArrived) sb.append("Escaped in " + cnt + " minute(s).\n");
			else sb.append("Trapped!\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
