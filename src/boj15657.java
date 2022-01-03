import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15657 {
	static int N, M;
	static int[] input, output;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		output = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		backTracking(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void backTracking(int depth) {
		if(depth == M) {
			for(int v : output)
				sb.append(v + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<input.length; i++) {
			if(depth != 0 && output[depth-1] > input[i]) continue;
			
			output[depth] = input[i];
			backTracking(depth+1);
		}
	}
}
