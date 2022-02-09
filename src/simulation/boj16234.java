package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234 {
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int N, L, R;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };

		while (true) {

			int[][] cloneMap = new int[N][N];
			for (int y = 0; y < N; y++)
				cloneMap[y] = map[y].clone();
			boolean[][][] isOpen = new boolean[N][N][4];
			boolean isContinue = false;

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					for (int dir = 0; dir < 4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];

						if (ny < 0 || ny >= N || nx < 0 || nx >= N)
							continue;
						if ((Math.abs(map[ny][nx] - map[y][x]) >= L) && (Math.abs(map[ny][nx] - map[y][x]) <= R)) {
							isOpen[y][x][dir] = true;
							isContinue = true;
						}
					}
				}
			}

//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < N; x++) {
//					System.out.println(map[y][x]);
//					for (int dir = 0; dir < 4; dir++) {
//						System.out.print(isOpen[y][x][dir] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				System.out.println();
//			}

			boolean[][] visited = new boolean[N][N];
			Queue<Pos> q = new LinkedList<>();
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					int sum = 0;
					int cnt = 1;
					for (int dir = 0; dir < 4; dir++) {
						if (isOpen[y][x][dir]) {
							q.add(new Pos(y, x));
							break;
						}
					}
					while(!q.isEmpty()) {
						Pos p = q.poll();
						for(int dir=0; dir<4; dir++) {
							if(isOpen[p.y][p.x][dir] && !visited[p.y][p.x]) {
								q.add(new Pos(p.y + dy[dir], p.x + dx[dir]));
								sum += map[y][x];
								cnt++;
							}
						}
						visited[p.y][p.x] = true; 
					}
//					System.out.println("KKKKKKKKKKKKKKKKKK");
					int value = sum / cnt;
					visited = new boolean[N][N];
					q = new LinkedList<>();
					for (int dir = 0; dir < 4; dir++) {
						if (isOpen[y][x][dir]) {
							q.add(new Pos(y, x));
							break;
						}
					}
					while(!q.isEmpty()) {
						Pos p = q.poll();
						for(int dir=0; dir<4; dir++) {
							if(isOpen[p.y][p.x][dir] && !visited[p.y][p.x]) {
								q.add(new Pos(p.y + dy[dir], p.x + dx[dir]));
								map[y][x] = value;
							}
						}
						visited[p.y][p.x] = true; 
					}
					
				}
			}

			for (int y = 0; y < N; y++)
				map[y] = cloneMap[y].clone();

//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < N; x++) {
//					System.out.print(map[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			if (!isContinue)
				break;
			else
				ans++;
		}

		System.out.println(ans);
	}
}
