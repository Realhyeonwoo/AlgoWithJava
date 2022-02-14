package dynamicProgramming;

import java.util.Scanner;

public class boj2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[][] d = new long[N+1][2];
		d[1][0] = 0;
		d[1][1] = 1;

		for(int i=2; i<=N; i++) {
			d[i][0] = d[i-1][0] + d[i-1][1];
			d[i][1] = d[i-1][0];
		}
		
		System.out.println(d[N][0] + d[N][1]);
		
	}
}