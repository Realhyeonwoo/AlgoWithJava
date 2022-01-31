package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj11559 {
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static final int R = 12, C = 6;
	static char[][] arr = new char[R][C];
	static boolean[][] visited = new boolean[R][C];
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// INPUT
		for (int y = 0; y < R; y++) {
			String str = br.readLine();
			for (int x = 0; x < C; x++) {
				arr[y][x] = str.charAt(x);
			}
		}

//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		// SIMUALTION
		ArrayList<Pos> brokenList = new ArrayList<>();
		while (true) {
			boolean isBroken = false;
			for (int y = R - 1; y >= 0; y--) {
				for (int x = 0; x < C; x++) {
					if (visited[y][x] || arr[y][x] == '.')
						continue;
					// setting
					for (int i = 0; i < R; i++)
						Arrays.fill(visited[i], false);

					// 색깔 탐색
					int[] dy = { 0, 0, 1, -1 };
					int[] dx = { 1, -1, 0, 0 };
					
					Queue<Pos> q = new LinkedList<>();
					q.add(new Pos(y, x));
					visited[y][x] = true;
					brokenList.add(new Pos(y, x));
					char color = arr[y][x];
					int cnt = 0;
					while (!q.isEmpty()) {
						Pos p = q.poll();
						brokenList.add(new Pos(p.y, p.x));
						cnt++;
						for (int dir = 0; dir < 4; dir++) {
							int ny = p.y + dy[dir];
							int nx = p.x + dx[dir];

							if (ny < 0 || ny >= R || nx < 0 || nx >= C)
								continue;
							if (visited[ny][nx])
								continue;
							if (arr[ny][nx] == color) {
								q.add(new Pos(ny, nx));
								visited[ny][nx] = true;
							}
						}
					}
					
					// 4이상 부수기
					if (cnt >= 4) {
						isBroken = true;
						for (Pos p : brokenList)
							arr[p.y][p.x] = '.';
					} else {
						brokenList.clear();
					}
				}
			}

//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 정렬하기(=내리기)
			for (int y = R - 2; y >= 0; y--) {
				for (int x = 0; x < C; x++) {
					int idx = y;
					
					while(idx < R-1) {
						if(arr[idx+1][x] == '.' && arr[idx][x] != '.') {
							char temp = arr[idx+1][x];
							arr[idx+1][x] = arr[idx][x];
							arr[idx][x] = temp;
						}
						idx++;
					}
				}
			}
			
			if (!isBroken)
				break;
			else
				ans++;
			
			
//			for(int i=0; i<R; i++) {
//				for(int j=0; j<C; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

		// OUTPUT
		System.out.println(ans);
	}
}
