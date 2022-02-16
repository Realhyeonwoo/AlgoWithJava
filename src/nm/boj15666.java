package nm;

import java.util.*;
import java.io.*;

public class boj15666 {
	static int N, M;
	static int[] input;
	static ArrayList<Integer> list = new ArrayList<>();
	static Set<String> output = new LinkedHashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		
		dfs(0, 0);
		
		for(String str : output)
			sb.append(str + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int depth, int start) {
		if(depth == M) {
			String str = "";
			for(int v : list)
				str = str + v + " ";
			output.add(str);
			return;
	 	}
		
		for(int i=start; i<N; i++) {
			list.add(input[i]);
			dfs(depth + 1, i);
			list.remove(list.size()-1);
		}
		
	}
}
