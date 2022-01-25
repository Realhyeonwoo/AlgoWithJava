package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj15666  {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] arr;
	static HashSet<String> set = new LinkedHashSet<String>();
	
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
		
		backTracking(0, 0, N, M);
		
		for(String str : set)
			sb.append(str + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	private static void backTracking(int depth, int start, int n, int m) {
		if(depth == m) {
			String str = "";
			for(int v : list)
				str = str + String.valueOf(v) + " ";
			set.add(str);
			return;
		}
		
		for(int i=start; i<n; i++) {
			list.add(arr[i]);
			
			backTracking(depth+1, i, n, m);
			
			list.remove(list.size()-1);
		}
	}
}
