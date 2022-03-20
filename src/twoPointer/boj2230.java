package twoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2230 {
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// INPUT		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int endIdx = 0;
		for(int startIdx=0; startIdx<N; startIdx++) {
			while(endIdx < N && arr[endIdx] - arr[startIdx] < M) {
				endIdx++;
			}
			if(endIdx == N) break;
			answer = Math.min(answer, arr[endIdx] - arr[startIdx]);
		}
		
		System.out.println(answer);
		
	}
}
