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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// 초기값 정의하기
		arr[1] = 0;
		// 점화식 찾기
		for(int i=2; i<=N; i++) {
			arr[i] = arr[i-1] + 1;
			if(i%3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
			if(i%2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
		}
		
		System.out.println(arr[N]);
		
	}
}
