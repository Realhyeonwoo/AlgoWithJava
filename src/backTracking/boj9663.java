package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class boj9663 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// INPUT
		int N = Integer.parseInt(br.readLine());

		// Setting
		boolean[] visitedCol = new boolean[N];
		boolean[] visitedCrsLeft = new boolean[N*2];
		boolean[] visitedCrsRight = new boolean[N*2];
		int[] ans = new int[1];
		
		backTracking(0, N, visitedCol, visitedCrsLeft, visitedCrsRight, ans);
		
		System.out.println(ans[0]);
		
	}
	
	static private void backTracking(int depth, int N, boolean[] visitedCol, boolean[] visitedCrsLeft, boolean[] visitedCrsRight, int[] ans) {
		if(depth == N) {
			ans[0]++;
		}
			
		for(int i=0; i<N; i++) {
			if(visitedCol[i]) continue;
			if(visitedCrsLeft[depth+i]) continue;
			if(visitedCrsRight[depth-i+N-1]) continue;
			
			visitedCol[i] = true;
			visitedCrsLeft[depth+i] = true;
			visitedCrsRight[depth-i+N-1] = true;
			
			backTracking(depth+1, N, visitedCol, visitedCrsLeft, visitedCrsRight, ans);
			
			visitedCol[i] = false;
			visitedCrsLeft[depth+i] = false;
			visitedCrsRight[depth-i+N-1] = false;
			
		}
		return;
	}
}
