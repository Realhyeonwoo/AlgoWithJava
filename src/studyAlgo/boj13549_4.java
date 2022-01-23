package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13549_4 {
	static class Pos  implements Comparable<Pos>{
		int n, time;

		Pos(int n, int time) {
			this.n = n;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int MAX_SIZE = 100000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visited = new int[MAX_SIZE + 1];

		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(N, 1));
		visited[N] = 1;

		while (!q.isEmpty()) {
			Pos p = q.poll();

			if (p.n - 1 >= 0) {
				if(visited[p.n-1] == 0 || visited[p.n-1] > p.time+1) {
					visited[p.n-1] = p.time + 1;
					q.add(new Pos(p.n-1, p.time+1));
				}
			}
			
			if (p.n + 1 <= MAX_SIZE) {
				if(visited[p.n+1] == 0 || visited[p.n+1] > p.time+1) {
					visited[p.n+1] = p.time + 1;
					q.add(new Pos(p.n+1, p.time+1));
				}
			}

			if (p.n * 2 <= MAX_SIZE) {
				if(visited[p.n*2] == 0 || visited[p.n*2] > p.time) {
					visited[p.n*2] = p.time;
					q.add(new Pos(p.n*2, p.time));
				}
			}
		}
		
		System.out.println(visited[K]-1);
	}
}
