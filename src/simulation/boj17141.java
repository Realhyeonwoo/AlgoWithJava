package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17141 {
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Pos> list = new ArrayList<>();
	static boolean[] isUsed;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == 2) list.add(new Pos(y, x));
			}
		}
		isUsed = new boolean[list.size()];

		putVirus(0, 0);
		
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void putVirus(int depth, int start) {
		if(depth == M) {
			int[][] cloneMap = new int[N][M];
			for(int i=0; i<N; i++) {
				cloneMap[i] = arr[i].clone();
				Arrays.fill(visited[i], false);
			}
			Queue<Pos> virusQ = new LinkedList<>();
			
			for(int i=0; i<isUsed.length; i++) {
				if(isUsed[i]) {
					int y = list.get(i).y;
					int x = list.get(i).x;
					cloneMap[y][x] = 3;
					virusQ.add(new Pos(y, x));
					visited[y][x] = true;
				}
			}
			int[] dy = {0, 0, 1, -1};
			int[] dx = {1, -1, 0, 0};
			int time = 0;
			while(!virusQ.isEmpty()) {
				int qSize = virusQ.size();;
				for(int i=0; i<qSize; i++) {
					Pos p = virusQ.poll();
					for(int dir=0; dir<4; dir++) {
						int ny = p.y + dy[dir];
						int nx = p.x + dx[dir];
						
						if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
						if(visited[ny][nx]) continue;
						if(cloneMap[ny][nx] == 0 || cloneMap[ny][nx] == 2) {
							visited[ny][nx] = true;
							cloneMap[ny][nx] = 3;
							virusQ.add(new Pos(ny, nx));
						}
					}
				}
				
				if(!virusQ.isEmpty()) time++;
			}
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					if(cloneMap[y][x] == 0) return;
				}
			}
			
			ans = Math.min(ans, time);
			
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			putVirus(depth + 1, i);
			isUsed[i] = false;
		}
		
	}
}
