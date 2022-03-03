import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj15666 {
	static int N, M;
	static int[] input;
	static int[] output;
	static StringBuilder sb;
	static LinkedHashSet<String> ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		Arrays.sort(input);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		output = new int[M];
		
		ans = new LinkedHashSet<>(); 
		backTracking(0);
		sb = new StringBuilder();
		for(String str : ans)
			sb.append(str+"\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void backTracking(int depth) {
		if(depth == M) {
			sb = new StringBuilder();
			for(int v : output)
				sb.append(v + " ");
			ans.add(sb.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(depth != 0 && output[depth-1] > input[i]) continue;
			output[depth] = input[i];
			backTracking(depth + 1);
		}
	}
}
