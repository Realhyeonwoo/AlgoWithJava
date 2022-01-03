import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj15663 {
	static int N, M;
	static int[] input, output;
	static boolean[] visited;
	static LinkedHashSet<String> ans;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		output = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		ans = new LinkedHashSet<>();
		
		backTracking(0);
		
		sb = new StringBuilder();
		for(String str : ans) 
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
			ans.add(sb.toString());
			return;
		}
		
		for(int i=0; i<input.length; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			output[depth] = input[i];
			backTracking(depth+1);
			visited[i] = false;
		}
		
	}
}
