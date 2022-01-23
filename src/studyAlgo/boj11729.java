package studyAlgo;

import java.util.Scanner;

public class boj11729 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println((1<<N) -1);
		Hanoi(1, 3, N);
	}

	private static void Hanoi(int a, int b, int n) {
		if(n == 1) {
			System.out.println(a + " " + b);
			return;
		}
		
		Hanoi(a, 6-a-b, n-1); // (1, 3, 3)
		System.out.println(a + " " + b);
		Hanoi(6-a-b, b, n-1); // (3, 2, 2)
			
	}
}
