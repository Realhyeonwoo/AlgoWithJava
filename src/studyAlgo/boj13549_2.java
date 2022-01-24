package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13549_2 {
	static class Point implements Comparable<Point>{
		int n, time;

		Point(int n, int time) {
			this.n = n;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
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
		boolean[] visited = new boolean[MAX_SIZE + 1];
		
		int ans = Integer.MAX_VALUE;
		PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(N, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.n] = true; 
            if (point.n == K) {
                ans = Math.min(ans, point.time);
            }
            if (point.n * 2 <= 100000 && !visited[point.n * 2]) { 
                queue.offer(new Point(point.n * 2, point.time));
            }
            if (point.n + 1 <= 100000 && !visited[point.n + 1]) { 
                queue.offer(new Point(point.n + 1, point.time + 1));
            }
            if (point.n - 1 >= 0 && !visited[point.n - 1]) { 
                queue.offer(new Point(point.n - 1, point.time + 1));
            }
        }
		System.out.println(ans);
		
	}
}
