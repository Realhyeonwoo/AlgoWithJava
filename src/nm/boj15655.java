package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15655 {

	public static void main(String[] args) throws Exception {
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
		combination(0, 0, M, arr, visited, list, sb);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void combination(int cnt, int start, int m, int[] arr, boolean[] visited, ArrayList<Integer> list, StringBuilder sb) {
		if(cnt == m) {
			for(int idx : list)
				sb.append(arr[idx] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
				if(visited[i]) continue;
				visited[i] = true;
				list.add(i);
				combination(cnt+1, i, m, arr, visited, list, sb);
				visited[i] = false;
				list.remove(list.size() - 1);
		}
	}
}
