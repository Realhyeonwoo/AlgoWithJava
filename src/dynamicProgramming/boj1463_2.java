package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj1463_2 {
	static int[] arr = new int[1000000 + 1];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테이블 정의 : d[k] = k를 1로 만드는데 최소 연산 횟수
		// 점화식 찾기
		// d[k] = d[k-1] + 1;
		// d[k] = d[k/3] + 1;
		// d[k] = d[k/2] + 1;
		// d[k] = min(d[k-1], d[k/3], d[k/2]) + 1;
		
		// 초기값 
		// d[1] = 0
		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N+1];
		d[1] = 0;
		for(int i=2; i<=N; i++) {
			d[i] = d[i-1] + 1;
			if(i%2 == 0) d[i] = Math.min(d[i/2]+1, d[i]);
			if(i%3 == 0) d[i] = Math.min(d[i/3]+1, d[i]);
		}
		System.out.println(d[N]);
	}
}
