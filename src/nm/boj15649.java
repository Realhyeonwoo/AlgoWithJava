package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15649 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		List<Integer> list = new ArrayList<>();
		
		permutation(0, N, M, visited, list);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void permutation(int cnt, int n, int m, boolean[] visited, List<Integer> list) {
		if(cnt == m) {
			for(int num : list)
				sb.append(num + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i);
			permutation(cnt+1, n, m, visited, list);
			visited[i] = false;
			list.remove(list.size()-1);
		}
			
	}
}
