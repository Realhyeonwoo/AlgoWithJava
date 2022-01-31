package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[301][3];
		dp[1][1] = arr[1];
		dp[1][2] = 0;
		dp[2][1] = arr[2];
		dp[2][2] = arr[1] + arr[2];
		
		for(int i=3; i<=N; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		
		System.out.println(Math.max(dp[N][1], dp[N][2]));
	}
}
