package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj15663 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[N];
		ArrayList<Integer> list = new ArrayList<>();
		Set<String> set = new LinkedHashSet<>();
		permutation(0, M, arr, visited, list, set);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void permutation(int cnt, int m, int[] arr, boolean[] visited, ArrayList<Integer> list, Set<String> set) {
		if(cnt == m) {
			String str = "";
			for(int idx : list)
				str += arr[idx] + " ";
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i);
			permutation(cnt+1, m, arr, visited, list, set);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
	
}
