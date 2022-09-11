package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj15665 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
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
		
		Set<String> set = new LinkedHashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		dupPermutation(0, M, arr, list, set);
		
		StringBuilder sb = new StringBuilder();
		for(String str : set)
			sb.append(str + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void dupPermutation(int cnt, int m, int[] arr, ArrayList<Integer> list, Set<String> set) {
		if(cnt == m) {
			String str = "";
			for(int idx : list)
				str += Integer.toString(arr[idx]) + " ";
			set.add(str);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			list.add(i);
			dupPermutation(cnt+1, m, arr, list, set);
			list.remove(list.size() - 1);
			
		}
	}
		
}
