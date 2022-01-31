 package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj11652 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);

		int cnt = 1, max = 1, maxIdx = 0;
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i - 1])
				cnt++;
			else
				cnt = 1;

			if (cnt > max) {
				max = cnt;
				maxIdx = i;
			}
		}
		System.out.println(arr[maxIdx]);
	}
}
