package nm;

import java.util.*;
import java.io.*;

public class boj15663 {
	static int N, M;
	static int[] input;
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static Set<String> output = new LinkedHashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		
		dfs(0);
		
		for(String str : output)
			sb.append(str + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			String str = "";
			for(int i : list)
				str = str + i + " ";
			output.add(str);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(input[i]);
			dfs(depth + 1);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
}
