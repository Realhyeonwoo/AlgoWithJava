package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj15664 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		boolean[] visited = new boolean[N];
		Set<String> set = new LinkedHashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		combination(0, 0, M, arr, list, visited, set);
		
		StringBuilder sb = new StringBuilder();
		for(String str : set)
			sb.append(str + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void combination(int cnt, int start, int m, int[] arr, ArrayList<Integer> list, boolean[] visited, Set<String> set) {
		if(cnt == m) {
			String str = "";
			for(int idx : list)
				str += Integer.toString(arr[idx]) + " ";
			set.add(str);
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i);
			combination(cnt+1, i, m, arr, list, visited, set);
			visited[i] = false;
			list.remove(list.size() - 1);
			
		}
	}
		
}
