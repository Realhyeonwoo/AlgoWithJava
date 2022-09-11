package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class boj15649 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		permutation(0, N, M, visited, list, sb);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void permutation(int start, int n, int m, boolean[] visited, ArrayList<Integer> list, StringBuilder sb) {
		
		if(start == m) {
			for(Integer i : list) {
				sb.append(i + " ");
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i+1);
			permutation(start+1, n, m, visited, list, sb);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
}
