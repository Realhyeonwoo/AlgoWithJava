package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];
		for (int y = 1; y <= N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = 1;
			while (st.hasMoreTokens()) {
				arr[y][x++] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int y = 1; y <= N; y++) {
//			for (int x = 1; x <= N; x++) {
//				System.out.print(arr[y][x] + " ");
//			}
//			System.out.println();
//		}
		int[][] d = new int[N+1][N+1];
		d[1][1] = arr[1][1];
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + arr[i][j];
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++)
			ans = Math.max(ans, d[N][i]);
		System.out.println(ans);
	}
}
