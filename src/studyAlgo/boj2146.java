package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2146 {
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int[][] distArr = new int[N][N];
		Queue<Pos> distQ = new LinkedList<>();
		for(int i=0; i<N; i++)
			Arrays.fill(distArr[i], -1);
		boolean[][] visited = new boolean[N][N];
		for(int y=0; y<N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == 1) {
					distArr[y][x] = 0;
					distQ.add(new Pos(y, x));
				}
			}
		}
		
		int dy[] = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		int num = 2;
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(!visited[y][x] && arr[y][x] != 0) {
					Queue<Pos> q = new LinkedList<>();
					q.add(new Pos(y, x));
					visited[y][x] = true;
					arr[y][x] = num;
					while(!q.isEmpty()) {
						Pos p = q.poll();
						
						for(int dir=0; dir<4; dir++) {
							int ny = p.y + dy[dir];
							int nx = p.x + dx[dir];
							
							if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
							if(!visited[ny][nx] && arr[ny][nx] != 0) {
								q.add(new Pos(ny, nx));
								visited[ny][nx] = true;
								arr[ny][nx] = num;
							}
						}
					}
					num++;
				}
			}
		}
		
		while(!distQ.isEmpty()) {
			Pos p = distQ.poll();
			
			for(int dir=0; dir<4; dir++) {
				int ny = p.y + dy[dir];
				int nx = p.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
				if(distArr[ny][nx] == -1) {
					distArr[ny][nx] = distArr[p.y][p.x] + 1;
					arr[ny][nx] = arr[p.y][p.x];
					distQ.add(new Pos(ny, nx));
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				for(int dir=0; dir<4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					
					if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
					if(arr[y][x] != arr[ny][nx]) {
						ans = Math.min(ans, distArr[y][x] + distArr[ny][nx]);
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
}
