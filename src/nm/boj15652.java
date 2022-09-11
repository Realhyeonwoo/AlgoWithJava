package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15652 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		dupCombination(0, 1, N, M, list, sb);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void dupCombination(int cnt, int start, int n, int m, ArrayList<Integer> list, StringBuilder sb) {
		if(cnt == m) {
			for(int v : list)
				sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			list.add(i);
			dupCombination(cnt+1, i, n, m, list, sb);
			list.remove(list.size()-1);
		}
	}
}
