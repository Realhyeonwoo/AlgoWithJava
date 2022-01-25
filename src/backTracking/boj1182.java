package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1182 {
	static int N;
	static int S;
	static int[] arr;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			backTracking(0, 0, i);
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	private static void backTracking(int depth, int start, int n) {
		if (depth == n) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) sum += arr[i];
			}
			ans += (sum == S) ? 1 : 0;
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			backTracking(depth+1, i, n);
			
			visited[i] = false;
		}
	}
}
