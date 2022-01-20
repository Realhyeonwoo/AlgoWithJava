package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for(int i=0; i<K; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=arr.length-1; i>=0; i--) {
			if(M == 0) break;
			if(arr[i] <= M) {
				cnt += M / arr[i];
				M = M%arr[i];
			}
		}
		
		System.out.println(cnt);
	}
}
