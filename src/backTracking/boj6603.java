package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj6603 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			visited = new boolean[N];
			arr = new int [N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			backTracking(0, 0);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void backTracking(int depth, int start) {
		if(depth == 6) {
			for(int i=0; i<N; i++)
				if(visited[i]) sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			backTracking(depth+1, i);
			visited[i] = false;
		}
	}
}
