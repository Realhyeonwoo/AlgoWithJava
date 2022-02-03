package grid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += arrA[i] * arrB[N-i-1];
		}
		
		System.out.println(sum);
	}
}
