package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class study {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N+1];
		int[] h = new int[N+1];
		d[1] = 0;
		
		for(int i=2; i<=N; i++) {
			d[i] = d[i-1] + 1;
			h[i] = i-1;
			if(i%3 == 0 && d[i/3]+1 < d[i]) {
				d[i] = d[i/3] + 1;
				h[i] = i/3;
			}
			if(i%2 == 0 && d[i/2]+1 < d[i]) {
				d[i] = d[i/2] + 1;
				h[i] = i/2;
			}
		}
		
		sb.append(d[N] + "\n");
		int cur = N;
		while(cur != 1) {
			sb.append(cur + " ");
			cur = h[cur];
		}
		sb.append(1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}