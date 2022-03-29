package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int answer = Integer.MAX_VALUE;
		int sum = arr[0];
		int endIdx = 0;
		for(int startIdx=0; startIdx<N; startIdx++) {
			while(endIdx < N && sum < S) {
				endIdx++;
				if(endIdx != N) sum += arr[endIdx];
			}
			if(endIdx == N) break;
			answer = Math.min(answer, endIdx - startIdx + 1);
			sum -= arr[startIdx];
		}
		
		if(Integer.compare(answer, Integer.MAX_VALUE) == 0) answer = 0;
		System.out.println(answer);
			
	}
}
