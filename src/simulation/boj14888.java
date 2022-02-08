package simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14888 {
	static int N;
	static ArrayList<Integer> numList = new ArrayList<>();
	static int[] operations = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			numList.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			operations[i] = Integer.parseInt(st.nextToken());
		
		dfs(numList.get(0), 1);
		
		System.out.println(max + "\n" + min);
	}

	private static void dfs(Integer ans, int depth) {
		if(depth == N) {
			max = Math.max(ans, max);
			min = Math.min(ans, min);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operations[i] == 0) continue;
			operations[i]--;
			if(i == 0) dfs(ans + numList.get(depth), depth+1);
			else if(i == 1) dfs(ans - numList.get(depth), depth+1);
			else if(i == 2) dfs(ans * numList.get(depth), depth+1);
			else if(i == 3) dfs(ans / numList.get(depth), depth+1);
			operations[i]++;
		}
	}
}
