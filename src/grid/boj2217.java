package grid;

import java.util.Arrays;
import java.util.Scanner;

public class boj2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, arr[N-i-1]*(i+1));
		}
		
		System.out.println(ans);
	}
}
