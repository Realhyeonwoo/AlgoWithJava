package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17143 {
	static final int SPEED = 0;
	static final int DIR = 1;
	static final int SIZE = 2;
	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int R, C, M, ans;
	static int[][][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1][3]; // r, c, {s, d, z}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c][SPEED] = s;
			map[r][c][DIR] = d;
			map[r][c][SIZE] = z;
		}

		// 이동
		for (int tc = 1; tc <= C; tc++) {
			// 가장 가까운 상어 1마리 잡기
			for (int y = 1; y <= R; y++) {
				if(map[y][tc][SIZE] == 0) continue;
				
				ans += map[y][tc][SIZE];
				map[y][tc][SIZE] = 0;
				break;
			}
			
			// 상어 이동 시키기
			int[] dy = {0, -1, 1, 0, 0};
			int[] dx = {0, 0, 0, 1, -1};
			int[][][] cloneMap = new int[R+1][C+1][3];
			
			
			
			for(int y=1; y<=R; y++) {
				for(int x=1; x<=C; x++) {
					if(map[y][x][SIZE] == 0) continue;
					
					int r = y;
					int c = x;
					int speed = map[y][x][SPEED];
					int dir = map[y][x][DIR];
					int size = map[y][x][SIZE];
					
					int ny = r, nx = c;
					while(speed > 0) {
						ny = r + dy[dir];
						nx = c + dx[dir];
						if(ny == 0) {
							dir = 2;
							continue;
						} else if(ny == R+1) {
							dir = 1;
							continue;
						} else if(nx == 0) {
							dir = 3;
							continue;
						} else if(nx == C+1) {
							dir = 4;
							continue;
						} else {
							r = ny;
							c = nx;
							speed--;
						}
					}
					if(cloneMap[ny][nx][SIZE] != 0) {
						if(cloneMap[ny][nx][SIZE] < size) {
							cloneMap[ny][nx][SPEED] = map[y][x][SPEED];
							cloneMap[ny][nx][DIR] = dir;
							cloneMap[ny][nx][SIZE] = size;
						}
					} else {
						cloneMap[ny][nx][SPEED] = map[y][x][SPEED];
						cloneMap[ny][nx][DIR] = dir;
						cloneMap[ny][nx][SIZE] = size;
					}
				}
			}
			
			for(int y=1; y<=R; y++) {
				for(int x=1; x<=C; x++) {
						map[y][x][SIZE] = cloneMap[y][x][SIZE];
						map[y][x][DIR] = cloneMap[y][x][DIR];
						map[y][x][SPEED] = cloneMap[y][x][SPEED];
				}
			}
		}
		
		System.out.println(ans);
	}
}
