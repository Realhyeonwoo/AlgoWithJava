package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17142 {
	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int N, M;
	static int[][] arr;
	static ArrayList<Pos> virusList = new ArrayList<>();
	static boolean[] isUsed;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == 2) virusList.add(new Pos(y, x));
			}
		}
		isUsed = new boolean[virusList.size()];

		boolean isZero = false;
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(arr[y][x] == 0) {
					isZero = true;
					break;
				}
			}
			if(isZero) break;
		}
		
		if(isZero)
			putVirus(0, 0);
		else {
			System.out.println(0);
			return;
		}
			
		
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void putVirus(int depth, int start) {
		if(depth == M) {
			int[][] cloneMap = new int[N][N];
			for(int y=0; y<N; y++)
				cloneMap[y] = arr[y].clone();
			boolean[][] visited = new boolean[N][N];
			Queue<Pos> virusQ = new LinkedList<>();
			for(int i=0; i<isUsed.length; i++) {
				if(isUsed[i]) {
					int y = virusList.get(i).y;
					int x = virusList.get(i).x;
					cloneMap[y][x] = 3;
					visited[y][x] = true;
					virusQ.add(new Pos(y, x));
				}
			}
			
			int[] dy = {0, 0, 1, -1};
			int[] dx = {1, -1, 0, 0};
			int time = 0;
			while(!virusQ.isEmpty()) {
				int qSize = virusQ.size();
				for(int i=0; i<qSize; i++) {
					Pos p = virusQ.poll();
					for(int dir=0; dir<4; dir++) {
						int ny = p.y + dy[dir];
						int nx = p.x + dx[dir];
						
						if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
						if(visited[ny][nx]) continue;
						if(cloneMap[ny][nx] == 0 || cloneMap[ny][nx] == 2) {
							cloneMap[ny][nx] = 3;
							visited[ny][nx] = true;
							virusQ.add(new Pos(ny, nx));
						}
					}
				}
				
				if(!virusQ.isEmpty()) time++;
				
				boolean isDone = true;
				for(int y=0; y<N; y++) {
					for(int x=0; x<N; x++) {
						if(cloneMap[y][x] == 0) {
							isDone = false;
							break;
						}
					}
					if(!isDone) break;
				}
				if(isDone) {
					ans = Math.min(ans, time);
					return;
				}
			}
		
//			System.out.println("===== " + time + " ======");
//			for(int y=0; y<N; y++) {
//			for(int x=0; x<N; x++) {
//				System.out.print(cloneMap[y][x] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
			
//			for(int y=0; y<N; y++) {
//				for(int x=0; x<N; x++) {
//					if(cloneMap[y][x] == 0) return;
//				}
//			}
//			
//			ans = Math.min(ans, time);
			
			return;
		}
		
		for(int i=start; i<virusList.size(); i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			putVirus(depth+1, i);
			isUsed[i] = false;
		}
	}
}
