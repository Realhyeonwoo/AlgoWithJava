package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {
	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N, M;
	static int[][] arr;
	static ArrayList<Pos> lands = new ArrayList<>();
	static ArrayList<Integer> walls = new ArrayList<>();
	static Queue<Pos> virusQ = new LinkedList<>();
	static boolean[] isUsed;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int y = 0; y < N; y++) { // 0: 빈칸, 1: 벽, 2: 바이러스
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 0)
					lands.add(new Pos(y, x));
				else if (arr[y][x] == 2) {
					virusQ.add(new Pos(y, x));
				}
			}
		}

		isUsed = new boolean[lands.size()];
		selectedWall(0, 0);

		System.out.println(ans);

	}

	private static void selectedWall(int depth, int start) {
		if (depth == 3) {
			int[][] cloneMap = new int[N][M];
			for (int i = 0; i < N; i++)
				cloneMap[i] = arr[i].clone();
			for (int idx : walls) {
				cloneMap[lands.get(idx).y][lands.get(idx).x] = 1;
			}
			
			int[] dy = { 0, 0, 1, -1 };
			int[] dx = { 1, -1, 0, 0 };
			Queue<Pos> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			Iterator<Pos> iter = virusQ.iterator();
			while (iter.hasNext()) {
				Pos p = iter.next();
				q.add(p);
				visited[p.y][p.x] = true;
			}

			while (!q.isEmpty()) {
				Pos p = q.poll();
				int y = p.y;
				int x = p.x;

				for (int dir = 0; dir < 4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (ny < 0 || ny >= N || nx < 0 || nx >= M)
						continue;
					if (cloneMap[ny][nx] != 0 || visited[ny][nx])
						continue;
					q.add(new Pos(ny, nx));
					visited[ny][nx] = true;
					cloneMap[ny][nx] = 2;
				}
			}

			int cnt = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (cloneMap[y][x] == 0)
						cnt++;
				}
			}
			ans = Math.max(ans, cnt);
			return;
		}

		for (int i = start; i < lands.size(); i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			walls.add(i);
			selectedWall(depth + 1, i);
			isUsed[i] = false;
			walls.remove(walls.size() - 1);
		}
	}
}
