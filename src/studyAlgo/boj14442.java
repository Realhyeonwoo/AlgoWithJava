package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14442 {
	static class Pos {
		int y, x, crash;
		Pos(int y, int x, int crash) {
			this.y =  y;
			this.x = x;
			this.crash = crash;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][][] visited = new int[N][M][K+1];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 0));
		visited[0][0][0] = 1;
		int ans = -1;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int y = p.y;
			int x = p.x;
			int crash = p.crash;
			
			if(y == N-1 && x == M-1) {
				ans = visited[y][x][crash];
				break;
			}
			
			for(int dir=0; dir<4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) {
					continue;
				}
				
				if(arr[ny][nx] == 0 && visited[ny][nx][crash] == 0) {
					visited[ny][nx][crash] = visited[y][x][crash] + 1;
					q.add(new Pos(ny, nx, crash));
				}
				
				if(arr[ny][nx] == 1 && crash < K && visited[ny][nx][crash+1] == 0) {
					visited[ny][nx][crash+1] = visited[y][x][crash] + 1;
					q.add(new Pos(ny, nx, crash+1));
				}
			}
		}
		
		System.out.println(ans);
	}
}
