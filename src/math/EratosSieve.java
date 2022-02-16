package math;

import java.util.Arrays;

public class EratosSieve {
	static final int N = 100000;
	public static void main(String[] args) {
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[1] = true;
		for(int i=2; i<=N; i++) {
			if(!isPrime[i]) continue;
			for(int j=i*2; j<=N; j+=i)
				isPrime[j] = false;
		}
		
		for(int i=1; i<=30; i++) {
			if(isPrime[i]) System.out.print(i + " ");
		}
	}
}
