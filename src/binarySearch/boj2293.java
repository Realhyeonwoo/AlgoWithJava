package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj2293 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr1[i] = num;
			arr2[i] = num;
		}
		
		int[] arr = new int[N*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[N*i+j] = arr1[i] + arr2[j];
			}
		}
		Arrays.sort(arr);
		
		int answer = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((arr[i] - arr[j]) <= 0) continue;
				if(hasNum(arr, arr1[i] - arr2[j])) {
					answer = Math.max(answer, arr1[i]);
				}
			}
		}
		
		System.out.println(answer);
	}

	private static boolean hasNum(int[] arr, int target) {
		int sIdx = 0;
		int eIdx = arr.length - 1;
		
		while(sIdx <= eIdx) {
			int mIdx = (sIdx + eIdx) / 2;
			
			if(arr[mIdx] > target) {
				eIdx = mIdx - 1;
			} else if(arr[mIdx] < target) {
				sIdx = mIdx + 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
