package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[][] visited = new boolean[100000+1][2];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N][0] = true;
		int time = 0;
		int telePortCnt = 0;
		boolean isFind = false;
		while(!q.isEmpty()) {
			int qSize = q.size();
			System.out.println("time : " + time);
			for(int i=0; i<qSize; i++) {
				int n = q.poll();
				System.out.print(n + " ");
				if(n-1 >= 0 && !visited[n-1][0]) {
					if(n-1 == K) {
						 isFind = true;
					}
					visited[n-1] = true;
					q.add(n-1);
				}
				
				if(n+1 <= 100000 && !visited[n+1]) {
					if(n+1 == K) {
						 isFind = true;
					}
					visited[n+1] = true;
					q.add(n+1);
				}
				
				if(n*2 <= 100000 && !visited[n*2]) {
					if(n*2 == K) {
						 isFind = true;
					}
					visited[n*2] = true;
					q.add(n*2);
					telePortCnt++;
				}
			}
			System.out.println();
			if(isFind) {
				time++;
				break;
			}
			if(!q.isEmpty()) time++;
		}
		
		System.out.println(time - telePortCnt);
	}
}
