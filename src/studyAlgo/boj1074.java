package studyAlgo;

import java.util.Scanner;

public class boj1074 {
	public static void main(String[] args) {
//		1.�Լ��� ����
//			- int func(int n, int r, int c)
//			- 2^n x 2^n �迭���� (r,c)�� �湮�ϴ� ������ ��ȯ�ϴ� �Լ�
//		2.base condition
//			- n = 0 �� �� return 0;
//		3.��� ��
//			- (r,c)�� 1�� �簢���� �� return func(n-1, r, c);
//			- (r,c)�� 2�� �簢���� �� return half*half + func(n-1, r, c-half);
//			- (r,c)�� 3�� �簢���� �� return 2*half*half + func(n-1, r-half, c);
//			- (r,c)�� 4�� �簢���� �� return 3*half*half + func(n-1, r-half, c);
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int R = scan.nextInt();
		int C = scan.nextInt();
		
		System.out.println(func(N, R, C));
	}

	private static int func(int n, int r, int c) {
		if(n == 0) return 0;
		int half = 1<<(n-1);
		
		if(r < half && c < half) return func(n-1, r, c);
		if(r < half && c >= half) return half*half + func(n-1, r, c-half);
		if(r >= half && c <half) return 2*half*half + func(n-1, r-half, c);
		return 3 * half * half + func(n-1, r-half, c-half); 
	}		
}
