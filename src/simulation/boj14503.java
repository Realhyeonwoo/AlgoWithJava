package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj14503 {
	static class Pos {
		int y, x, dir;

		Pos(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

	static int N, M, ans;
	static int[][] arr;
	static boolean[][] visited;
	static Pos robot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		robot = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (arr[robot.y][robot.x] == 0 && !visited[robot.y][robot.x]) {
				visited[robot.y][robot.x] = true;
				ans++;
			}
//			System.out.println("y: " + robot.y + " x: " + robot.x + " dir: " + robot.dir + " ans: " + ans);
			boolean isClean = false;
			for (int dir = 0; dir < 4; dir++) {
				switch (robot.dir) {
				case 0:
					if (robot.x - 1 >= 0) {
						if (!visited[robot.y][robot.x - 1] && arr[robot.y][robot.x - 1] == 0) {
							robot = new Pos(robot.y, robot.x - 1, 3);
							isClean = true;
						}
					}
					break;
				case 1:
					if (robot.y - 1 >= 0) {
						if (!visited[robot.y - 1][robot.x] && arr[robot.y - 1][robot.x] == 0) {
							robot = new Pos(robot.y - 1, robot.x, 0);
							isClean = true;
						}
					}
					break;
				case 2:
					if (robot.x + 1 < M) {
						if (!visited[robot.y][robot.x + 1] && arr[robot.y][robot.x + 1] == 0) {
							robot = new Pos(robot.y, robot.x + 1, 1);
							isClean = true;
						}
					}
					break;
				case 3:
					if (robot.y + 1 < N) {
						if (!visited[robot.y + 1][robot.x] && arr[robot.y + 1][robot.x] == 0) {
							robot = new Pos(robot.y + 1, robot.x, 2);
							isClean = true;
						}
					}
					break;
				default:
				}
				
				if (isClean) break;
				else {
					int d = 0;
					if(robot.dir == 0) d = 3;
					else d = robot.dir - 1;
					robot = new Pos(robot.y, robot.x, d);
				}
//				System.out.println("CHECK > y: " + robot.y + " x: " + robot.x + " dir: " + robot.dir + " ans: " + ans);
					
			}
			
			boolean isMove = false;
			if (!isClean) {
				switch (robot.dir) {
				case 0:
					if(robot.y+1 < N && arr[robot.y+1][robot.x] == 0) {
						robot = new Pos(robot.y+1, robot.x, robot.dir);
						isMove = true;
					}
					break;
				case 1:
					if(robot.x-1 >= 0 && arr[robot.y][robot.x-1] == 0) {
						robot = new Pos(robot.y, robot.x-1, robot.dir);
						isMove = true;
					}
					break;
				case 2:
					if(robot.y-1 >= 0 && arr[robot.y-1][robot.x] == 0) {
						robot = new Pos(robot.y-1, robot.x, robot.dir);
						isMove = true;
					}
					break;
				case 3:
					if(robot.x+1 < M && arr[robot.y][robot.x+1] == 0) {
						robot = new Pos(robot.y, robot.x+1, robot.dir);
						isMove = true;
					}
					break;
					default:
				}
			}
			
//			System.out.println("y: " + robot.y + " x: " + robot.x + " dir: " + robot.dir + " isClean: " + isClean + " isMove: " + isMove);
//			System.out.println();
			if(!isClean && !isMove) {
				System.out.println(ans);
				break;
			}
		}

	}
}
