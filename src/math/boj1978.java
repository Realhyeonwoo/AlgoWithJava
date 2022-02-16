package math;

import java.util.Scanner;

public class boj1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans = 0;
		for(int i=0; i<N; i++)
			ans += isPrime(sc.nextInt());
		
		System.out.println(ans);
	}

	private static int isPrime(int n) {
		if(n == 1) return 0;
		
		for(int i=2; i*i<=n; i++) {
			if(n % i == 0) return 0;
		}
		return 1;
	}
}
