package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2468 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		int MAX_HEIGHT = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > MAX_HEIGHT) MAX_HEIGHT = arr[i][j];
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		int ans = 1;
		for(int h=1; h<=MAX_HEIGHT; h++) {
			int[][] tempArr = arr.clone();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(tempArr[i][j] <= h) tempArr[i][j] =0;
				}
			}
			
			Queue<Pos> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j] || tempArr[i][j] == 0) continue;
					
					cnt++;
					q.add(new Pos(i, j));
					visited[i][j] = true;
		
					while(!q.isEmpty()) {
						Pos p = q.poll();
						for(int dir=0; dir<4; dir++) {
							int ny = p.y + dy[dir];
							int nx = p.x + dx[dir];
							
							if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
							if(visited[ny][nx] || tempArr[ny][nx] == 0) continue;
							visited[ny][nx] = true;
							q.add(new Pos(ny, nx));
						}
					}
				}
			}
			
			if(ans < cnt) ans = cnt;
		}
		System.out.println(ans);
	}
}
