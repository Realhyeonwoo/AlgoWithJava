package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj17140 {
	static class Num implements Comparable<Num> {
		int num, cnt;
		Num(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		public int compareTo(Num o) {
			if(this.cnt == o.cnt) {
				return this.num - o.num;
			} else {
				return this.cnt - o.cnt;
			}
		}
	}
	static int[][] arr = new int[201][201];
	static int R, C, K;
	static int ans = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int y=1; y<=3; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=1; x<=3; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int tc=0; tc<=99; tc++) {
			if(arr[R][C] == K) {
				ans = tc;
				break;
			}
			
			
			int row = checkSize("row");
			int col = checkSize("col");
			if(row < col) {
				for(int x=1; x<=col; x++) {
					int[] cntArr = new int[101];
					PriorityQueue<Num> pq = new PriorityQueue<>();
					for(int y=1; y<=row; y++) {
						cntArr[arr[y][x]]++;
						arr[y][x] = 0;
					}
					for(int i=1; i<=100; i++) {
						if(cntArr[i] != 0) pq.add(new Num(i, cntArr[i]));
					}
					int idx = 1;
					while(!pq.isEmpty()) {
						Num n = pq.poll();
						arr[idx++][x] = n.num;
						arr[idx++][x] = n.cnt;
					}
				}
				
			} else if(row >= col) {
				for(int y=1; y<=row; y++) {
					int[] cntArr = new int[101];
					PriorityQueue<Num> pq = new PriorityQueue<>();
					for(int x=1; x<=col; x++) {
						cntArr[arr[y][x]]++;
						arr[y][x] = 0;
					}
					for(int i=1; i<=100; i++) {
						if(cntArr[i] != 0) pq.add(new Num(i, cntArr[i]));
					}
					int idx = 1;
					while(!pq.isEmpty()) {
						Num n = pq.poll();
						arr[y][idx++] = n.num;
						arr[y][idx++] = n.cnt;
					}
				}
			}
			
//			for(int y=1; y<=100; y++) {
//				for(int x=1; x<=100; x++) {
//					if(arr[y][x] == 0) break;
//					System.out.print(arr[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
		}
		
		System.out.println(ans);
	}
	private static int checkSize(String dir) {
		int len = Integer.MIN_VALUE;
		if(dir.equals("row")) {
			for(int x=1; x<=200; x++) {
				int cnt = 0;
				for(int y=200; y>=1; y--) {
					if(arr[y][x] != 0) break;
					cnt++;
				}
				len = Math.max(200-cnt, len);
			}
		} else if(dir.equals("col")) {
			for(int y=1; y<=200; y++) {
				int cnt = 0;
				for(int x=200; x>=1; x--) {
					if(arr[y][x] != 0) break;
					cnt++;
				}
				len = Math.max(200-cnt, len);
			}
		}
		
		return len;
	}
}
