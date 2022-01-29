package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15683 {
	static class Pos {
		int y, x, type, dir;

		Pos(int y, int x, int type, int dir) {
			this.y = y;
			this.x = x;
			this.type = type;
			this.dir = dir;
		}
	}

	static int N, M;
	static int[][] arr;
	static int[][] dir;
	static ArrayList<Integer> output = new ArrayList<>();
	static ArrayList<Pos> camList = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 6)
					camList.add(new Pos(i, j, arr[i][j], 0));
			}
		}

		int[] temp = new int[camList.size()];
		int idx = 0;
		for (Pos v : camList) {
			int type = v.type;
			if (type == 1 || type == 3 || type == 4) {
				temp[idx++] = 4;
			} else if (type == 2) {
				temp[idx++] = 2;
			} else if (type == 5) {
				temp[idx++] = 1;
			}
		}
		dir = new int[camList.size()][];
		for (int i = 0; i < camList.size(); i++)
			dir[i] = new int[temp[i]];

		backTracking(0);

		System.out.println(ans);
	}

	private static void backTracking(int depth) {
		if (depth == camList.size()) {
//			for (int i = 0; i < camList.size(); i++) {
//				System.out.println("Cam : " + camList.get(i).type + "-> " + output.get(i));
//			}
//			System.out.println();

			int[][] cloneMap = new int[N][M];
			for (int i = 0; i < N; i++)
				cloneMap[i] = arr[i].clone();
			for (int i = 0; i < camList.size(); i++) {
				Pos p = camList.get(i);
				int direction = output.get(i);
				switch (p.type) {
				case 1:
					moveCam1(p, direction, cloneMap);
					break;
				case 2:
					moveCam2(p, direction, cloneMap);
					break;
				case 3:
					moveCam3(p, direction, cloneMap);
					break;
				case 4:
					moveCam4(p, direction, cloneMap);
					break;
				case 5:
					moveCam5(p, direction, cloneMap);
					break;
				default:
				}
			}

			int cnt = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (cloneMap[y][x] == 0)
						cnt++;
				}
			}
			ans = Math.min(ans, cnt);

			System.out.println("CNT : " + cnt);
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					System.out.print(cloneMap[y][x] + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int j = 0; j < dir[depth].length; j++) {
			output.add(j);
			backTracking(depth + 1);
			output.remove(output.size() - 1);
		}

	}

	private static void moveCam1(Pos p, int direction, int[][] cloneMap) {
		int y = p.y;
		int x = p.x;
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		int ny, nx;
		switch (direction) {
		case 0:
			ny = y + dy[0];
			nx = x + dx[0];
			while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
				cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
				ny += dy[0];
				nx += dx[0];
			}
			break;
		case 1:
			ny = y + dy[1];
			nx = x + dx[1];
			while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
				cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[1];
					nx += dx[1];
				}
			
			break;
		case 2:
			ny = y + dy[2];
			nx = x + dx[2];
			while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
				cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[2];
					nx += dx[2];
				}
			break;
		case 3:
			ny = y + dy[3];
			nx = x + dx[3];
			while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
				cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[3];
					nx += dx[3];
				}
			break;
		default:
		}
	}

	private static void moveCam2(Pos p, int direction, int[][] cloneMap) {
		int y = p.y;
		int x = p.x;
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		switch (direction) {
		case 0:
			for (int i = 0; i < 4; i++) {
				if (i == 2 || i == 3)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 1:
			for (int i = 0; i < 4; i++) {
				if (i == 0 || i == 1)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		default:
		}

	}

	private static void moveCam3(Pos p, int direction, int[][] cloneMap) {
		int y = p.y;
		int x = p.x;
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		switch (direction) {
		case 0:
			for (int i = 0; i < 4; i++) {
				if (i == 1 || i == 2)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 1:
			for (int i = 0; i < 4; i++) {
				if (i == 0 || i == 2)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 2:
			for (int i = 0; i < 4; i++) {
				if (i == 0 || i == 3)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				if (i == 1 || i == 3)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		default:
		}

	}

	private static void moveCam4(Pos p, int direction, int[][] cloneMap) {
		int y = p.y;
		int x = p.x;
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };
		switch (direction) {
		case 0:
			for (int i = 0; i < 4; i++) {
				if (i == 0)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 1:
			for (int i = 0; i < 4; i++) {
				if (i == 1)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 2:
			for (int i = 0; i < 4; i++) {
				if (i == 2)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				if (i == 3)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
					cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
					ny += dy[i];
					nx += dx[i];
				}
			}
			break;
		default:
		}
	}

	private static void moveCam5(Pos p, int direction, int[][] cloneMap) {
		int y = p.y;
		int x = p.x;
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			while ((ny >= 0 && ny < N) && (nx >= 0 && nx < M) && cloneMap[ny][nx] != 6) {
//				if(cloneMap[ny][nx] != 0 && cloneMap[ny][nx] != -1) break;
//				cloneMap[ny][nx] = -1;
				cloneMap[ny][nx] = (cloneMap[ny][nx] != 0) ? cloneMap[ny][nx] :  -1;
				ny += dy[i];
				nx += dx[i];
			}
		}
	}

}
