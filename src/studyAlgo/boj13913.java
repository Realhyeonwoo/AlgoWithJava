package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj13913 {
	static int SIZE = 100000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] history = new int[SIZE + 1];
		int[] visited = new int[SIZE + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;
		history[N] = N;
		
		while(!q.isEmpty()) {
			int n = q.poll();

			if(n == K) {
				sb.append(visited[n]-1 + "\n");
				Stack<Integer> stk = new Stack<>();
				while(history[n] != n) {
					stk.add(n);
					n = history[n];
				}
				sb.append(N + " ");
				while(!stk.isEmpty())
					sb.append(stk.pop() + " ");
				break;
			}
			
			if(n*2 <= SIZE && visited[n*2] == 0) {
				visited[n*2] = visited[n] + 1;
				history[n*2] = n;
				q.add(n*2);
			}
			
			if(n+1 <= SIZE && visited[n+1] == 0) {
				visited[n+1] = visited[n] + 1;
				history[n+1] = n;
				q.add(n+1);
			}
			
			if(n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n] + 1;
				history[n-1] = n;
				q.add(n-1);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
