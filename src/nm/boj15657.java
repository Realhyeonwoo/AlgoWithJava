package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15657 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int idx = 0;
		while(st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		dupCombination(0, 0, M, arr, list, sb);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void dupCombination(int cnt, int start, int m , int[] arr, ArrayList<Integer> list, StringBuilder sb) {
		if(cnt == m) {
			for(int idx : list)
				sb.append(arr[idx] + " " );
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			list.add(i);
			dupCombination(cnt+1, i, m, arr, list, sb);
			list.remove(list.size() - 1);
		}
	}
}
