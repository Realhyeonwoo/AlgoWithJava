package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj9466 {
	static int[] arr;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			visited = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<=N; i++) {
				if(visited[i] == 0) run(i);
				System.out.println();
				for(int j=1; j<=N; j++)
					System.out.print(visited[j] + " ");
				System.out.println();
				
			}
			
			int cnt = 0;
			for(int i=1; i<=N; i++)
				if(visited[i] != -1) cnt++;
			sb.append(cnt + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void run(int start) {
		int cur = start;
		
		while(true) {
			visited[cur] = start;
			cur = arr[cur];
			
			if(visited[cur] == start) {
				while(visited[cur] != -1) {
					visited[cur] = -1;
					cur = arr[cur];
				}
				return;
			} else if(visited[cur] != 0) { 
				return;
			}
		}
	}
}
