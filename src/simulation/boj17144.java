package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17144 {
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static class Pos {
		int y, x;
		Pos(int y, int x)  {
			this.y = y;
			this.x = x;
		}
	}
	static int R, C, T;
	static int[][] arr;
	static Pos machine;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		for(int  y=0; y<R; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<C; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == -1)
					machine = new Pos(y, x); // 밑 부분 저장(y, x), 윗부분(y-1, x)
			}
		}
		
		for(int t=1; t<=T; t++) {
			// 시뮬레이션 준비
			int[][] cloneArr = new int[R][C];
			
			// 먼지 확산
			for(int y=0; y<R; y++) {
				for(int x=0; x<C; x++) {
					if(arr[y][x] == -1 || arr[y][x] == 0) continue;
					int cnt = 0;
					for(int dir=0; dir<4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						
						if(ny<0 || ny>=R || nx<0 || nx>=C) continue;
						if(arr[ny][nx] == -1) continue;
						cloneArr[ny][nx] += arr[y][x] / 5;
						cnt++;
					}
					cloneArr[y][x] = cloneArr[y][x] + (arr[y][x] - (arr[y][x] / 5 * cnt));
				}
			}
			
//			for(int y=0; y<R; y++) {
//				for(int x=0; x<C; x++) {
//					System.out.print(cloneArr[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 공기 청정기 가동
			// 아래 방향
			for(int y=machine.y+1; y<R-1; y++) {
				cloneArr[y][0] = cloneArr[y+1][0];
			}
			for(int x=0; x<=C-2; x++) {
				cloneArr[R-1][x] = cloneArr[R-1][x+1];
			}
			for(int y=R-1; y>=machine.y+1; y--) {
				cloneArr[y][C-1] = cloneArr[y-1][C-1];
			}
			for(int x=C-1; x>=1; x--) {
				cloneArr[machine.y][x] = cloneArr[machine.y][x-1];
			}
			cloneArr[machine.y][machine.x] = -1;
			// 위 방향(machine.y-1, x)
			for(int y=machine.y-2; y>0; y--) {
				cloneArr[y][0] = cloneArr[y-1][0];
			}
			for(int x=0; x<=C-2; x++) {
				cloneArr[0][x] = cloneArr[0][x+1];
			}
			for(int y=0; y<=machine.y-2; y++) {
				cloneArr[y][C-1] = cloneArr[y+1][C-1];
			}
			for(int x=C-1; x>=1; x--) {
				cloneArr[machine.y-1][x] = cloneArr[machine.y-1][x-1];
			}
			cloneArr[machine.y-1][machine.x] = -1;
			
			for(int y=0; y<R; y++)
				arr[y] = cloneArr[y].clone();
//			arr[machine.y][machine.x] = -1;
//			arr[machine.y-1][machine.x] = -1;
			
		}
		
		int ans = 0;
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++) {
				ans += arr[y][x];
			}
		}
		System.out.println(ans + 2);
	}
}
