package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15652  {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		backTracking(0, 1, N, M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	private static void backTracking(int depth, int start, int n, int m) {
		if(depth == m) {
			for(int v : list)
				sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			list.add(i);
			
			backTracking(depth+1, i, n, m);
			
			list.remove(list.size()-1);
		}
	}
}
