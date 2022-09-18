package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// INPUT
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		// LOGIC
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int sIdx = getStartIdx(arr, num);
			int eIdx = getEndIdx(arr, num);
			sb.append((eIdx - sIdx) + " ");
		}

		// OUTPUT
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int getStartIdx(int[] arr, int num) {
		int sIdx = 0;
		int eIdx = arr.length;

		while (sIdx < eIdx) {
			int mIdx = (sIdx + eIdx) / 2;

			if (num <= arr[mIdx]) {
				eIdx = mIdx;
			} else {
				sIdx = mIdx + 1;
			}
		}
		return sIdx;
	}

	private static int getEndIdx(int[] arr, int num) {
		int sIdx = 0;
		int eIdx = arr.length;

		while (sIdx < eIdx) {
			int mIdx = (sIdx + eIdx) / 2;

			if (num < arr[mIdx]) {
				eIdx = mIdx;
			} else {
				sIdx = mIdx + 1;
			}
		}
		return eIdx;
	}

}
