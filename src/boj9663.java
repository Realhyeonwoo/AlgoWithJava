import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj9663 {
	static int N;
	static boolean[] visitedVertical; // j
	static boolean[] visitedRightCross; // i-j 
	static boolean[] visitedLeftCross; //i+j
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		visitedVertical = new boolean[N];
		visitedRightCross = new boolean[N*2];
		visitedLeftCross = new boolean[N*2];
		
		backTracking(0);
		
		System.out.println(answer);
	}

	private static void backTracking(int depth) {
		if(depth == N) {
			answer++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visitedVertical[i] || visitedRightCross[depth-i+N-1] || visitedLeftCross[depth+i]) continue;
			
			visitedVertical[i] = true;
			visitedRightCross[depth-i+N-1] = true;
			visitedLeftCross[depth+i] = true;

			backTracking(depth + 1);
			
			visitedVertical[i] = false;
			visitedRightCross[depth-i+N-1] = false;
			visitedLeftCross[depth+i] = false;
		}
	}
}
