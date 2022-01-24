package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2573 {
	static int ZERO = 0;
	static int ONE = 1;
	static int TWO = 2;
	
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<Pos> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0) q.add(new Pos(i, j));
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		int year = 0;
		while(true) {
			year++;
			
			// check melting Count
			int[][] zeroArr = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] != 0) {
						for(int dir=0; dir<4; dir++) {
							int ny = i + dy[dir];
							int nx = j + dx[dir];
							if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
							if(arr[ny][nx] == 0) zeroArr[i][j]++;
						}
					}
				}
			}
			
			// melting
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(arr[y][x] != 0) {
						arr[y][x] = Math.max(0, arr[y][x] - zeroArr[y][x]);
					}
				}
			}
			
			
//			System.out.println();
//			for(int y=0; y<N; y++) {
//				for(int x=0; x<M; x++) {
//					System.out.print(arr[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// check status
			int status = isDivided(arr, dy, dx); 
//			System.out.println("STATUS : " + status);
			if(status == ZERO) {
				year = 0;
				break;
			} else if(status == TWO) {
				break;
			}
			
			
		}
		
		System.out.println(year);
	}

	private static int isDivided(int[][] arr, int[] dy, int[] dx) {
		int y=0, x=0;
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] != 0) {
					cnt++;
					y = i;
					x = j;
				}
			}
		}
		
		if(cnt == 0) return ZERO;
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y, x));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			cnt--;
			for(int dir=0; dir<4; dir++) {
				int ny = p.y + dy[dir];
				int nx = p.x + dx[dir];
				
				if(ny<0 || ny>=arr.length || nx<0 || nx>=arr[0].length) continue;
				if(arr[ny][nx] != 0 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new Pos(ny, nx));
				}
			}
		}
		
		return (cnt == 0) ? ONE : TWO;
	}
}
