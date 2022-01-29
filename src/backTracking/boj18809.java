package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18809 {
	static class Pos {
		int y, x, time;

		Pos(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	static int N, M, G, R;
	static int[][] arr;
	static ArrayList<Pos> list = new ArrayList<>();
	static ArrayList<Pos> GRlist = new ArrayList<>();
	static boolean[] isPickedGR;
	static boolean[] isGreen;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int y=0; y<N; y++) { // 0:호수, 1:배양액X, 2:배양액O
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == 2) list.add(new Pos(y, x, 0));
			}
		}
		isPickedGR = new boolean[list.size()];
		
		pickGRList(0, 0);
		
		
		System.out.println(ans);
		
	}

	private static void pickGRList(int depth, int start) {
		if(depth == (G+R)) {
			
			for(int i=0; i<isPickedGR.length; i++) {
				if(isPickedGR[i]) GRlist.add(new Pos(list.get(i).y, list.get(i).x, list.get(i).time));
			}
			isGreen = new boolean[GRlist.size()];
			pickGreenList(0, 0);
			GRlist.clear();
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			if(isPickedGR[i]) continue;
			isPickedGR[i] = true;
			pickGRList(depth+1, i);
			isPickedGR[i] = false;
		}
	}

	private static void pickGreenList(int depth, int start) {
		if(depth == G) {
			
			int[][] cloneMap = new int[N][M];
			int[][] visitedTime= new int[N][M];
			for(int i=0; i<N; i++) {
				cloneMap[i] = arr[i].clone();
				Arrays.fill(visitedTime[i], -1);
			}
			
			Queue<Pos> q = new LinkedList<>();
			for(int i=0; i<isGreen.length; i++) {
				int y = GRlist.get(i).y;
				int x = GRlist.get(i).x;
				int time = GRlist.get(i).time;
				if(isGreen[i]) {
					cloneMap[y][x] = 3;
					q.add(new Pos(y, x, time));
					visitedTime[y][x] = 0;
				} 
			}
			for(int i=0; i<isGreen.length; i++) {
				int y = GRlist.get(i).y;
				int x = GRlist.get(i).x;
				int time = GRlist.get(i).time;
				if(!isGreen[i]) {
					cloneMap[y][x] = 4;
					q.add(new Pos(y, x, time));
					visitedTime[y][x] = 0;
				} 
			}
//			System.out.println("clone Map");
//			for(int y=0; y<N; y++) {
//				for(int x=0; x<M; x++) {
//					System.out.print(cloneMap[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int dy[] = {0, 0, 1, -1};
			int dx[] = {1, -1, 0, 0};
			int cnt = 0;
			while(!q.isEmpty()) {
				Pos p = q.poll();
				int y = p.y;
				int x = p.x;
				int time = p.time;
//				System.out.println("[" + y + " , " + x + ", " + time + "]");
				if(cloneMap[y][x] == 5) continue;
				for(int dir=0; dir<4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					
					if(ny<0 || ny>=N || nx<0 || nx>= M) continue;
					if(cloneMap[ny][nx] == 0 || cloneMap[ny][nx] == 5) continue;
					if(cloneMap[ny][nx] == 1 || cloneMap[ny][nx] == 2) {
						cloneMap[ny][nx] = cloneMap[y][x];
						visitedTime[ny][nx] = time + 1;
						q.add(new Pos(ny, nx, time+1));
					}
					if((cloneMap[y][x] == 4 && cloneMap[ny][nx] == 3) || (cloneMap[y][x] == 3 && cloneMap[ny][nx] == 4)) {
						if(visitedTime[ny][nx] == time+1)
							cloneMap[ny][nx] = 5;
					}
				}	
				
//				System.out.println();
//				for(int y1=0; y1<N; y1++) {
//					for(int x1=0; x1<M; x1++) {
//						System.out.print(cloneMap[y1][x1] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();

//				for(int y1=0; y1<N; y1++) {
//					for(int x1=0; x1<M; x1++) {
//						System.out.print(visitedTime[y1][x1] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			
//			System.out.println("====DONE====");
//			for(int y=0; y<N; y++) {
//				for(int x=0; x<M; x++) {
//					System.out.print(cloneMap[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			for(int y=0; y<N; y++)
				for(int v : cloneMap[y]) 
					if(v == 5) cnt++;
//			System.out.println("COMPLETE : " + cnt);
			
			ans = Math.max(ans, cnt);
			
			return;
		}
		
		for(int i=start; i<GRlist.size(); i++) {
			if(isGreen[i]) continue;
			isGreen[i] = true;
			pickGreenList(depth+1, i);
			isGreen[i] = false;
		}
		
	}
}
