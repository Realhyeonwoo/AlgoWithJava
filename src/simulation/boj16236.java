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
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
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
			boolean isEat = false;
			Fish tempShark = new Fish(shark.y, shark.x, shark.size);
			Pos tempFish = new Pos(0, 0);
			int dist = Integer.MAX_VALUE;

			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					if(map[y][x] == 0) continue;
					if(map[y][x] >= shark.size) continue;

					int[][] visited = new int[N][N];
					for(int i=0; i<N; i++)
						Arrays.fill(visited[i], -1);
					Queue<Pos> q = new LinkedList<>();
					
					q.add(new Pos(shark.y, shark.x));
					visited[shark.y][shark.x] = 0;
					while(!q.isEmpty()) {
						Pos p = q.poll();
						if(p.y == y && p.x == x) {
							if(dist > visited[y][x]) {
								dist = visited[y][x];
								tempFish = new Pos(y, x);
								int sharkSize = shark.size;
								if(eatCnt+1 == sharkSize) sharkSize++;
								tempShark = new Fish(y, x, sharkSize);
								isEat = true;
								break;
							}
						}
						for(int dir=0; dir<4; dir++) {
							int ny = p.y + dy[dir];
							int nx = p.x + dx[dir];
							
							if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
							if(visited[ny][nx] != -1) continue;
							if(map[ny][nx] > shark.size) continue;
							
							visited[ny][nx] = visited[p.y][p.x] + 1;
							q.add(new Pos(ny, nx));
						}
					}
				}
			}
			
			if(!isEat) break;
			else {
				eatCnt++;
				int size = shark.size;
				if(shark.size == eatCnt) {
					eatCnt = 0;
					size++;
				}
				shark = new Fish(tempShark.y, tempShark.x, size);
				map[tempFish.y][tempFish.x] = 0; 
				ans += dist;
				
//				System.out.println("DIST : " + dist + " EAT : " + eatCnt);
//				System.out.println("SHARK : " + shark.y + " " + shark.x + " " + shark.size);
//				for(int y=0; y<N; y++) {
//					for(int x=0; x<N; x++) {
//						System.out.print(map[y][x] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				
			}
			
			
		}
		
		System.out.println(ans);
		
		
	}

	private static int bfs(int y, int x, Fish s, int[][] cloneMap) {
		
		
		return -1;
	}
}
