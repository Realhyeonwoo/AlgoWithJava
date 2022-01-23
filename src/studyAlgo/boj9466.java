package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj9466 {
	static int NOT_VISITED = 0;
	static int IN_CYCLE = -1;
	static int n;
	static int[] arr;
	static int[] visited;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// INPUT
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new int[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(visited, NOT_VISITED);

			// SIMULATION
			for (int i = 1; i <= n; i++) {
				if (visited[i] == NOT_VISITED)
					isCycle(i);
			}

			// OUTPUT
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (visited[i] != IN_CYCLE)
					cnt++;
			}
			sb.append(cnt + "\n"); 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void isCycle(int start) {
		int cur = start;
		while(true) {
			visited[cur] = start;
			cur = arr[cur];
			
			if(visited[cur] == start) {
				while(visited[cur] != IN_CYCLE) {
					visited[cur] = IN_CYCLE;
					cur = arr[cur];
				}
				return;
			} else if(visited[cur] != NOT_VISITED) {
				return;
			}
		}
	}
}
