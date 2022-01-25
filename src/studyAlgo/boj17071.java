package studyAlgo;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17071 {
	static int SIZE = 500000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] visited = new int[SIZE + 1];
		
		visited[N] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		int time = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			K += time;
			
			if(K > SIZE) {
				System.out.println(-1);
				return;
			}
			
			System.out.println("K°ª : " + K);
			if(K+time+1 <= SIZE) visited[K+time+1] = 0;
			for(int i=0; i<qSize; i++) {
				int n = q.poll();
				if(K < 10)
					System.out.println(n);
				if(n == K) {
					System.out.println(visited[n] - 1);
					return;
				}
				
				if(n-1 >=0 && visited[n-1] == 0) {
					visited[n-1] = visited[n] + 1;
					q.add(n - 1);
				}
				
				if(n+1 <= SIZE && visited[n+1] == 0) {
					visited[n+1] = visited[n] + 1;
					q.add(n + 1);
				}
				
				if(n*2 <= SIZE && visited[n*2] == 0) {
					visited[n*2] = visited[n] + 1;
					q.add(n * 2);
				}
			}
			time++;
		}
	}
}
