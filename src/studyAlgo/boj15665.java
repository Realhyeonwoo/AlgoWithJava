import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj15665 {
	static int N, M;
	static int[] input;
	static int[] output;
	static LinkedHashSet<String> linkedHashSet;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		output = new int[M];
		linkedHashSet = new LinkedHashSet<>();
		
		backTracking(0);
		
		sb = new StringBuilder();
		for(String str : linkedHashSet)
			sb.append(str + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void backTracking(int depth) {
		if(depth == M) {
			sb = new StringBuilder();
			for(int v : output) 
				sb.append(v + " ");
			linkedHashSet.add(sb.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			output[depth] = input[i];
			backTracking(depth + 1);
		}
	}
}
