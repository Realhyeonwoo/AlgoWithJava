import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {
	static final int MAX_VALUE = 100000;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited = new boolean[MAX_VALUE + 1];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		q.add(N);
		visited[N] = true;
		while(!q.isEmpty()) {
			boolean isFind = false;
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int n = q.poll();
				if(n == K) isFind = true;
				if(n-1>=0 && !visited[n-1]) { 
					q.add(n-1);
					visited[n-1] = true;
				}
				if(n+1<=MAX_VALUE && !visited[n+1]) {
					q.add(n+1);
					visited[n+1] = true;
				}
				if(n*2<=MAX_VALUE && !visited[n*2]) {
					q.add(n*2);
					visited[n*2] = true;
				}
			}
			if(isFind) break;
			else cnt++;
		}
		
		System.out.println(cnt);
	}
}
