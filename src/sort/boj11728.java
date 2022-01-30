package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11728 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arrA = new int[N];
		int[] arrB = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arrA[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arrA);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++)
			arrB[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arrB);
		
		int i = 0, j = 0;
		while(i<N && j<M) {
			if(arrA[i] < arrB[j]) {
				sb.append(arrA[i++] + " ");
			} else {
				sb.append(arrB[j++] + " ");
			}
		}
		if(i>=N && j<M) {
			while(j<M) sb.append(arrB[j++] + " ");
		}
		if(i<N && j>=M) {
			while(i<N) sb.append(arrA[i++] + " ");	
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
