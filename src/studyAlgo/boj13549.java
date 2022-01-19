package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549 {
	static class Pos {
		int n, time;

		Pos(int n, int time) {
			this.n = n;
			this.time = time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visited = new int[100000 + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 0;

		while (!q.isEmpty()) {
			int n = q.poll();

			if (n == K) {
				System.out.println(visited[n]);
				break;
			}

			if (n - 1 >= 0 && visited[n - 1] >= 0) {
				q.add(n - 1);
				visited[n - 1] = visited[n] + 1;
			}

			if (n + 1 <= 100000 && visited[n + 1] >= 0) {
				q.add(n + 1);
				visited[n + 1] = visited[n] + 1;
			}

			if (n * 2 <= 100000 && visited[n * 2] >= 0) {
				q.add(n * 2);
				visited[n * 2] = visited[n];
			}
		}

	}
}
