package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj9663 {
	static int cnt;
	static boolean[] visitedSero;
	static boolean[] visitedDowncross;
	static boolean[] visitedUpcross;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		visitedSero = new boolean[N];
		visitedDowncross = new boolean[30];
		visitedUpcross = new boolean[30];

		backTracking(0, N);

		System.out.println(cnt);
	}

	private static void backTracking(int depth, int n) {
		if (depth == n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visitedSero[i] || visitedUpcross[depth+i] || visitedDowncross[depth-i+n-1]) continue;
			visitedSero[i] = true;
			visitedUpcross[depth + i] = true;
			visitedDowncross[depth - i + n -1] = true;
			backTracking(depth+1, n);
			visitedSero[i] = false;
			visitedUpcross[depth + i] = false;
			visitedDowncross[depth - i + n -1] = false;
		}
	}
}
