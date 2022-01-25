package backTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class boj15649 {
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		visited = new boolean[N+1];
		
		backTracking(0, N, M);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void backTracking(int depth, int N, int M) {
		if(depth == M) {
			for(int v : list)
				sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(i);
			backTracking(depth+1, N, M);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
}
