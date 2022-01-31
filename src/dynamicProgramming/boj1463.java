package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int n = q.poll();
				if(n == 1) {
					System.out.println(cnt-1);
					System.exit(0);
				}
				
				if(n % 3 == 0) q.add(n / 3);
				if(n % 2 == 0) q.add(n / 2);
				q.add(n - 1);
			}
			cnt++;
		}
	}
}
