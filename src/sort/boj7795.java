package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7795 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
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
			
			int cnt = 0;
			for(int i=arrA.length-1; i>=0; i--) {
				for(int j=0; j<arrB.length; j++) {
					if(arrA[i] <= arrB[j]) break;
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
