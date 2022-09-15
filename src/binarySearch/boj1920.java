package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {

	public static void main(String[] args) throws Exception {
		
		// INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		//BUSINESS LOGIC
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int val : arr2) {
			boolean hasNum = binarySearch(arr, val);
			sb.append((hasNum ? "1" : "0") + "\n");
		}
		
		// OUTPUT
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static boolean binarySearch(int[] arr, int val) {
		int start = 0;
		int end = arr.length - 1;
		
		if((arr[start] == val) || (arr[end] == val)) return true;
		
		while(start <= end) {
			int middle = (start + end) / 2;
			
			if(arr[middle] < val) {
				start = middle + 1;
			} else if(arr[middle] > val) {
				end = middle - 1;
			} else {
				return true;
			}
			
		}
		return false;
	}
}
