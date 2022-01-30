package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj12100 {
	static String[] directions = { "UP", "RIGHT", "DOWN", "LEFT" };
	static ArrayList<Integer> dir = new ArrayList<>();
	static int N;
	static int[][] arr;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}	
		}

		backTracking(0);

		System.out.println(ans);
	}

	private static void backTracking(int depth) {
		if (depth == 5) {
			int[][] cloneMap = new int[N][N];
			for (int i = 0; i < N; i++)
				cloneMap[i] = arr[i].clone();

			for (int v : dir) {
				move(directions[v], cloneMap);
			}

			int maxV = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					maxV = Math.max(maxV, cloneMap[y][x]);
				}
			}
			ans = Math.max(ans, maxV);

			return;
		}

		for (int i = 0; i < directions.length; i++) {
			dir.add(i);
			backTracking(depth + 1);
			dir.remove(dir.size() - 1);
		}
	}

	private static void move(String d, int[][] map) {
		switch (d) {
		case "UP":
			for (int y = 1; y < N; y++) {
				for (int x = 0; x < N; x++) {
					int idx = y;
					while (idx > 0) {
						int temp;
						if (map[idx - 1][x] == 0 && map[idx][x] != 0) {
							map[idx - 1][x] = map[idx][x];
							map[idx][x] = 0;
						}
						idx--;
					}
				}
			}
			for (int y = 1; y < N; y++) {
				int idx = y;
				for (int x = 0; x < N; x++) {
					if (map[y][x] == 0)
						continue;

					if (idx != 0 && map[idx - 1][x] == map[idx][x]) {
						map[idx - 1][x] += map[idx][x];
						map[idx][x] = 0;
					}
				}
			}
			for (int y = 1; y < N; y++) {
				for (int x = 0; x < N; x++) {
					int idx = y;
					while (idx > 0) {
						if (map[idx - 1][x] == 0 && map[idx][x] != 0) {
							map[idx - 1][x] = map[idx][x];
							map[idx][x] = 0;
						}
						idx--;
					}
				}
			}
			break;
		case "RIGHT":
			for (int x = N - 2; x >= 0; x--) {
				for (int y = 0; y < N; y++) {
					int idx = x;
					while (idx < N - 1) {
						if (map[y][idx + 1] == 0 && map[y][idx] != 0) {
							map[y][idx + 1] = map[y][idx];
							map[y][idx] = 0;
						}
						idx++;
					}
				}
			}
			for (int x = N - 2; x >= 0; x--) {
				int idx = x;
				for (int y = 0; y < N; y++) {
					if (map[y][x] == 0)
						continue;
					if (idx != N - 1 && map[y][idx + 1] == map[y][idx]) {
						map[y][idx + 1] += map[y][idx];
						map[y][idx] = 0;
					}
				}
			}
			for (int x = N - 2; x >= 0; x--) {
				for (int y = 0; y < N; y++) {
					int idx = x;
					while (idx < N - 1) {
						if (map[y][idx + 1] == 0 && map[y][idx] != 0) {
							map[y][idx + 1] = map[y][idx];
							map[y][idx] = 0;
						}
						idx++;
					}
				}
			}
			break;
		case "DOWN":
			for (int y = N - 2; y >= 0; y--) {
				for (int x = 0; x < N; x++) {
					int idx = y;
					while (idx < N - 1) {
						if (map[idx + 1][x] == 0 && map[idx][x] != 0) {
							map[idx + 1][x] = map[idx][x];
							map[idx][x] = 0;
						}
						idx++;
					}
				}
			}
			for (int y = N - 2; y >= 0; y--) {
				int idx = y;
				for (int x = 0; x < N; x++) {
					if (map[y][x] == 0)
						continue;

					if (idx != N - 1 && map[idx + 1][x] == map[idx][x]) {
						map[idx + 1][x] += map[idx][x];
						map[idx][x] = 0;
					}
				}
			}
			for (int y = N - 2; y >= 0; y--) {
				for (int x = 0; x < N; x++) {
					int idx = y;
					while (idx < N - 1) {
						if (map[idx + 1][x] == 0 && map[idx][x] != 0) {
							map[idx + 1][x] = map[idx][x];
							map[idx][x] = 0;
						}
						idx++;
					}
				}
			}
			break;
		case "LEFT":
			for (int x = 1; x < N; x++) {
				for (int y = 0; y < N; y++) {
					int idx = x;
					while (idx > 0) {
						if (map[y][idx - 1] == 0 && map[y][idx] != 0) {
							map[y][idx - 1] = map[y][idx];
							map[y][idx] = 0;
						}
						idx--;
					}
				}
			}

			for (int x = 1; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (map[y][x] == 0)
						continue;
					if (map[y][x - 1] == map[y][x]) {
						map[y][x - 1] += map[y][x];
						map[y][x] = 0;
					}
				}
			}
			for (int x = 1; x < N; x++) {
				for (int y = 0; y < N; y++) {
					int idx = x;
					while (idx > 0) {
						if (map[y][idx - 1] == 0 && map[y][idx] != 0) {
							map[y][idx - 1] = map[y][idx];
							map[y][idx] = 0;
						}
						idx--;
					}
				}
			}
			break;
		default:
		}

	}
}
