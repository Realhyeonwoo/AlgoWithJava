package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1182_2 {
	static int N;
	static int S;
	static int[] arr;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		backTracking(0, 0);
		
		if(S == 0) ans--;
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	private static void backTracking(int depth, int sum) {
		if (depth == N) {
			if(sum == S) ans++;
			return;
		}
		
		backTracking(depth+1, sum);
		backTracking(depth+1, sum + arr[depth]);
	}
}
