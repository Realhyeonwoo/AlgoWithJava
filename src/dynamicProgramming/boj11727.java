package dynamicProgramming;

import java.util.Scanner;

public class boj11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] d = new int[N+1];
		d[1] = 1;
		if(N>=2) d[2] = 3;
		for(int i=3; i<=N; i++)
			d[i] = (d[i-1] + d[i-2] * 2) % 10007;
		
		System.out.println(d[N]);
				
	}
}
