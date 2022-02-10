package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static int[][] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			boolean isMove = false;
			int[] dy = { -1, 0, 1, 0 };
			int[] dx = { 0, 1, 0, -1 };
			int numbering = 0;
			ArrayList<Integer> moveValue = new ArrayList<>();
			for(int y=0; y<N; y++)
				Arrays.fill(visited[y], 0);
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (visited[y][x] != 0)
						continue;
					numbering++;
					int sum = map[y][x], cnt = 1;
					visited[y][x] = numbering;
					Queue<Pos> q = new LinkedList<>();
					q.add(new Pos(y, x));
					while (!q.isEmpty()) {
						Pos p = q.poll();
						for (int dir = 0; dir < 4; dir++) {
							int ny = p.y + dy[dir];
							int nx = p.x + dx[dir];

							if (ny < 0 || ny >= N || nx < 0 || nx >= N)
								continue;
							if (visited[ny][nx] != 0)
								continue;
							if ((Math.abs(map[ny][nx] - map[p.y][p.x]) >= L)
									&& (Math.abs(map[ny][nx] - map[p.y][p.x]) <= R)) {
								visited[ny][nx] = numbering;
								q.add(new Pos(ny, nx));
								sum += map[ny][nx];
								cnt++;
							}
						}
					}
					if(cnt >= 2) isMove = true;
					moveValue.add(sum / cnt);
				}
			}

			if(!isMove) break;
			else ans++;
			
			for (int i = 1; i <= numbering; i++) {
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						if (visited[y][x] == i) {
							map[y][x] = moveValue.get(i - 1);
						}
					}
				}
			}
			
//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < N; x++) {
//						System.out.print(map[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		System.out.println(ans);
	}
}
