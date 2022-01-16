package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		ArrayList<Integer> ansList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] || arr[i][j] == 0) continue;
				
				Queue<Pos> q = new LinkedList<>();
				q.add(new Pos(i, j));
				visited[i][j] = true;
				int cnt = 1;
				while(!q.isEmpty()) {
					Pos p = q.poll();
					
					for(int dir=0; dir<4; dir++) {
						int ny = p.y + dy[dir];
						int nx = p.x + dx[dir];
						
						if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
						if(visited[ny][nx] || arr[ny][nx] == 0) continue;
						
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
			sb.append(v + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
