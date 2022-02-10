package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16236 {
	static class Fish {
		int y, x, size;
		Fish(int y, int x, int size) {
			this.y = y;
			this.x = x;
			this.size = size;
		}
	}
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N;
	static int[][] map;
	static Fish shark;
	static int eatCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int y=0; y<N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == 9) {
					map[y][x] = 0;
					shark = new Fish(y, x, 2);
				}
			}
		}
		
		int ans = 0;
		while(true) {
			boolean isMove = false;
			int time = Integer.MAX_VALUE;
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					if(map[y][x] > shark.size) continue;
					Fish cloneShark = new Fish(shark.y, shark.x, shark.size);
					int[][] cloneMap = new int[N][N];
					for(int i=0; i<N; i++)
						cloneMap[i] = map[i].clone();
					
					int cnt = bfs(y, x, cloneShark, cloneMap);
					if(cnt != -1) { 
						time = Math.min(time, cnt);
						isMove = true;
						eatCnt++;
						int sharkSize = shark.size;
						if(eatCnt == sharkSize) {
						}
					}
				}
			}
			if(!isMove) break;
			ans = time;
		}
		
		System.out.println(ans);
		
		
	}

	private static int bfs(int y, int x, Fish s, int[][] cloneMap) {
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		int[][] visited = new int[N][N];
		for(int i=0; i<N; i++)
			Arrays.fill(visited[i], -1);
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(s.y, s.x));
		visited[s.y][s.x] = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.y == y && p.x == x) {
				map[y][x] = 0;
				return visited[y][x];
			}
		}
		
		return -1;
	}
}
