package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15650 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		combination(0, 1, N, M, visited, list, sb);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void combination(int cnt, int start, int n, int m, boolean[] visited, ArrayList<Integer> list, StringBuilder sb) {
		if(cnt == m) {
			for(int v : list)
				sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i);
			combination(cnt+1, i, n, m, visited, list, sb);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
}
