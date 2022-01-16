import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[F+1];
		
		if(S == G) {
			System.out.println(0);
			System.exit(0);
		}
		
		if(G < S && D == 0) {
			System.out.println("use the stairs");
			System.exit(0);
		}
		
		if(G > S && U == 0) {
			System.out.println("use the stairs");
			System.exit(0);
		}
		
		Queue<Integer> q = new LinkedList<>();
		visited[S] = true;
		q.add(S);
		int cnt = 0;
		boolean isArrived = false;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int n = q.poll();
				if(n == G) {
					isArrived = true;
					break;
				}
				if((n+U) <= F && !visited[n + U]) {
					visited[n+U] = true;
					q.add(n+U);
				}
				if((n-D) >= 1 && !visited[n - D]) {
					visited[n-D] = true;
					q.add(n-D);
				}
			}
			if(isArrived) break;
			if(!q.isEmpty()) cnt++;
		}
		
		if(isArrived) System.out.println(cnt);
		else System.out.println("use the stairs");
	}
}
