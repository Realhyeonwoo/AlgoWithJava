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

		int MAX_SIZE = 100000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[MAX_SIZE + 1];

		int ans = Integer.MAX_VALUE;
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(N, 0));
		while (!q.isEmpty()) {
			Pos p = q.poll();
			visited[p.n] = true;
			if(p.n == K)
				ans = Math.min(ans, p.time);
			
			if(p.n * 2 <= MAX_SIZE && !visited[p.n * 2])
				q.add(new Pos(p.n*2, p.time));
			if(p.n + 1 <= MAX_SIZE && !visited[p.n + 1])
				q.add(new Pos(p.n+1, p.time+1));
			if(p.n - 1 >= 0 && !visited[p.n - 1])
				q.add(new Pos(p.n-1, p.time+1));
		}
		
		System.out.println(ans);
	}
}
