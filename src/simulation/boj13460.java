package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13460 {
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static ArrayList<Integer> dirs = new ArrayList<>();
	static int N, M;
	static char[][] arr;
	static Pos rBall, bBall, hole;
	static int ans = Integer.MAX_VALUE;
	static boolean isFail = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int y=0; y<N; y++) {
			String str = br.readLine();
			for(int x=0; x<M; x++) {
				arr[y][x] = str.charAt(x);
				if(arr[y][x] == 'B') bBall = new Pos(y, x);
				else if(arr[y][x] == 'R') rBall = new Pos(y, x);
				else if(arr[y][x] == '0') hole = new Pos(y, x);
			}
		}
		
		selectDirection(0);

		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void selectDirection(int depth) {
		if(depth == 10) {
			char[][] cloneMap = new char[N][M];
			for(int y=0; y<N; y++)
				cloneMap[y] = arr[y].clone();
			Pos cloneRed = rBall;
			Pos cloneBlue = bBall;
			
			int cnt = 0;
			boolean isDone = false;
//			System.out.println("+++++++++++++");
			isFail = false;
			for(int dir : dirs) {
				cnt++;
				if(inclineBoard(dir)) {
					isDone = true;
					break;
				}
				if(isFail) break;
			}
			
			if(isDone)
				ans = Math.min(ans, cnt);
			
			for(int y=0; y<N; y++)
				arr[y] = cloneMap[y].clone();
			rBall = cloneRed;
			bBall = cloneBlue;
			return;
		}
		for(int i=0; i<4; i++) {
			dirs.add(i);
			selectDirection(depth + 1);
			dirs.remove(dirs.size()-1);
		}
	}

	private static boolean inclineBoard(int dir) {
		boolean isRedDone = false;
		boolean isBlueDone = false;
		boolean isRedMove = false;
		boolean isBlueMove = false;
//		System.out.println("DIR : " + dir);
		switch(dir) {
		case 0:
				while(true) {
					int ny = rBall.y + dy[dir];
					int nx = rBall.x + dx[dir];
					
					if(ny<0 || ny>=N || nx<0 || nx>=M) break;
					if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
					if(arr[ny][nx] == 'O') {
						isRedDone = true;
						arr[rBall.y][rBall.x] = '.'; 
						rBall = new Pos(-3, -3);
						break;
					}
					if(arr[ny][nx] == '.') {
						arr[ny][nx] = 'R';
						arr[rBall.y][rBall.x] = '.';
						rBall = new Pos(ny, nx);
					}
				}
				while(true) {
					int ny = bBall.y + dy[dir];
					int nx = bBall.x + dx[dir];
					
					if(ny<0 || ny>=N || nx<0 || nx>=M) break;
					if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
					if(arr[ny][nx] == 'O') {
						isBlueDone = true;
						arr[bBall.y][bBall.x] = '.';
						bBall = new Pos(-3, -3);
						isFail = true;
						return false;
					}
					if(arr[ny][nx] == '.') {
						arr[ny][nx] = 'B';
						arr[bBall.y][bBall.x] = '.';
						bBall = new Pos(ny, nx);
					}
				}
				while(true) {
					if(isBlueDone) return false;
					int ny = rBall.y + dy[dir];
					int nx = rBall.x + dx[dir];
					
					if(ny<0 || ny>=N || nx<0 || nx>=M) break;
					if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
					if(arr[ny][nx] == 'O') {
						isRedDone = true;
						arr[rBall.y][rBall.x] = '.'; 
						rBall = new Pos(-3, -3);
						break;
					}
					if(arr[ny][nx] == '.') {
						arr[ny][nx] = 'R';
						arr[rBall.y][rBall.x] = '.';
						rBall = new Pos(ny, nx);
					}
				}
				while(true) {
					int ny = bBall.y + dy[dir];
					int nx = bBall.x + dx[dir];
					
					if(ny<0 || ny>=N || nx<0 || nx>=M) break;
					if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
					if(arr[ny][nx] == 'O') {
						isBlueDone = true;
						arr[bBall.y][bBall.x] = '.';
						bBall = new Pos(-3, -3);
						isFail = true;
						return false;
					}
					if(arr[ny][nx] == '.') {
						arr[ny][nx] = 'B';
						arr[bBall.y][bBall.x] = '.';
						bBall = new Pos(ny, nx);
					}
				}
			break;
		case 1:
			while(true) {
				int ny = rBall.y + dy[dir];
				int nx = rBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
				if(arr[ny][nx] == 'O') {
					isRedDone = true;
					arr[rBall.y][rBall.x] = '.'; 
					rBall = new Pos(-3, -3);
					break;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'R';
					arr[rBall.y][rBall.x] = '.';
					rBall = new Pos(ny, nx);
				}
			}
			while(true) {
				int ny = bBall.y + dy[dir];
				int nx = bBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
				if(arr[ny][nx] == 'O') {
					isBlueDone = true;
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(-3, -3);
					isFail = true;
					return false;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'B';
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(ny, nx);
				}
			}
			while(true) {
				if(isBlueDone) return false;
				int ny = rBall.y + dy[dir];
				int nx = rBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
				if(arr[ny][nx] == 'O') {
					isRedDone = true;
					arr[rBall.y][rBall.x] = '.'; 
					rBall = new Pos(-3, -3);
					break;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'R';
					arr[rBall.y][rBall.x] = '.';
					rBall = new Pos(ny, nx);
				}
			}
			while(true) {
				int ny = bBall.y + dy[dir];
				int nx = bBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
				if(arr[ny][nx] == 'O') {
					isBlueDone = true;
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(-3, -3);
					isFail = true;
					return false;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'B';
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(ny, nx);
				}
			}
			break;
		case 2:
			while(true) {
				int ny = rBall.y + dy[dir];
				int nx = rBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
				if(arr[ny][nx] == 'O') {
					isRedDone = true;
					arr[rBall.y][rBall.x] = '.'; 
					rBall = new Pos(-3, -3);
					break;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'R';
					arr[rBall.y][rBall.x] = '.';
					rBall = new Pos(ny, nx);
				}
			}
			while(true) {
				int ny = bBall.y + dy[dir];
				int nx = bBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
				if(arr[ny][nx] == 'O') {
					isBlueDone = true;
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(-3, -3);
					isFail = true;
					return false;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'B';
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(ny, nx);
				}
			}
			while(true) {
				if(isBlueDone) return false;
				int ny = rBall.y + dy[dir];
				int nx = rBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
				if(arr[ny][nx] == 'O') {
					isRedDone = true;
					arr[rBall.y][rBall.x] = '.'; 
					rBall = new Pos(-3, -3);
					break;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'R';
					arr[rBall.y][rBall.x] = '.';
					rBall = new Pos(ny, nx);
				}
			}
			while(true) {
				int ny = bBall.y + dy[dir];
				int nx = bBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
				if(arr[ny][nx] == 'O') {
					isBlueDone = true;
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(-3, -3);
					isFail = true;
					return false;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'B';
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(ny, nx);
				}
			}
			break;
		case 3:
			while(true) {
				int ny = rBall.y + dy[dir];
				int nx = rBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
				if(arr[ny][nx] == 'O') {
					isRedDone = true;
					arr[rBall.y][rBall.x] = '.'; 
					rBall = new Pos(-3, -3);
					break;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'R';
					arr[rBall.y][rBall.x] = '.';
					rBall = new Pos(ny, nx);
				}
			}
			while(true) {
				int ny = bBall.y + dy[dir];
				int nx = bBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
				if(arr[ny][nx] == 'O') {
					isBlueDone = true;
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(-3, -3);
					isFail = true;
					return false;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'B';
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(ny, nx);
				}
			}
			while(true) {
				if(isBlueDone) return false;
				int ny = rBall.y + dy[dir];
				int nx = rBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'B') break;
				if(arr[ny][nx] == 'O') {
					isRedDone = true;
					arr[rBall.y][rBall.x] = '.'; 
					rBall = new Pos(-3, -3);
					break;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'R';
					arr[rBall.y][rBall.x] = '.';
					rBall = new Pos(ny, nx);
				}
			}
			while(true) {
				int ny = bBall.y + dy[dir];
				int nx = bBall.x + dx[dir];
				
				if(ny<0 || ny>=N || nx<0 || nx>=M) break;
				if(arr[ny][nx] == '#' || arr[ny][nx] == 'R') break;
				if(arr[ny][nx] == 'O') {
					isBlueDone = true;
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(-3, -3);
					isFail = true;
					return false;
				}
				if(arr[ny][nx] == '.') {
					arr[ny][nx] = 'B';
					arr[bBall.y][bBall.x] = '.';
					bBall = new Pos(ny, nx);
				}
			}
			break;
			default:
		}
//		System.out.println();
//		for(int y=0; y<N; y++) {
//			for(int x=0; x<M; x++) {
//				System.out.print(arr[y][x] + " ");
//			}
//			System.out.println();
//		}
		if(isBlueDone) return false;
		else if(isRedDone && !isBlueDone) return true;
		else return false;
	}

}
