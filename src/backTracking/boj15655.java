package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15655  {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		backTracking(0, N, M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	private static void backTracking(int depth, int n, int m) {
		if(depth == m) {
			for(int v : list)
				sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			list.add(arr[i]);
			
			backTracking(depth+1, n, m);
			
			list.remove(list.size()-1);
		}
	}
}
