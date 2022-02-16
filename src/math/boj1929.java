package math;

import java.util.Arrays;
import java.util.Scanner;

public class boj1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] arr = new boolean[1000000+1];
		Arrays.fill(arr, true);
		arr[1] = false;
		for(int i=2; i*i<=N; i++) {
			if(!arr[i]) continue;
			for(int j=i*i; j<=N; j+=i)
				arr[j] = false;
		}
		
		for(int i=M; i<=N; i++)
			if(arr[i]) System.out.println(i);
	}
}
