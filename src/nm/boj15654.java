package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj15654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		while(st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		arr.sort(null);
		
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[N];
		ArrayList<Integer> list = new ArrayList<>();
		permutation(0, arr, M, visited, list, sb);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void permutation(int cnt, ArrayList<Integer> arr, int m, boolean[] visited, ArrayList<Integer> list, StringBuilder sb) {
		if(cnt == m) {
			for(int idx : list) {
				sb.append(arr.get(idx) + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i);
			permutation(cnt+1, arr, m, visited, list, sb);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
