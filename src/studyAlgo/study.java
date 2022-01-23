package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class study {
	static class Pos implements Comparable<Pos>{
		int n, time;
		Pos(int n, int time) {
			this.n = n;
			this.time = time;
		}
		public int compareTo(Pos o) {
			return this.time - o.time;
		}
	}
	
	static final int MAX = 100000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[MAX+1];
		
		int ans = Integer.MAX_VALUE;
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(N, 0));
		while(!q.isEmpty()) {
			Pos now = q.poll();
			int n = now.n;
			int time = now.time;
			visited[n] = true;
			
			if(n == K)
				ans = Math.min(ans, time);
			
			if(n * 2 <= MAX && !visited[n*2]) {
				q.add(new Pos(n*2, time));
			}
			if(n + 1 <= MAX && !visited[n+1])
				q.add(new Pos(n+1, time+1));
			if(n -1 >= 0 && !visited[n-1])
				q.add(new Pos(n-1, time+1));
		}
		
		System.out.println(ans);
		
	}
}
