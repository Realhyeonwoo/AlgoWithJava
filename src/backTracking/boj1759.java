package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {
	static char[] arr;
	static boolean[] visited;
	static char[] vowels = {'a', 'i', 'o', 'u', 'e'};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		visited = new boolean[C];
		String str = br.readLine();
		String[] strArr = str.split(" ");
		for(int i=0; i<C; i++)
			arr[i] = strArr[i].toCharArray()[0];
		Arrays.sort(arr);
		
		backTracking(0, 0, L);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void backTracking(int depth, int start, int l) {
		if(depth == l) {
			int cnt = 0;
			String str = "";
			for(int i=0; i<arr.length; i++) {
				if(visited[i]) {
					 str += String.valueOf(arr[i]);
					 for(int j=0; j<vowels.length; j++)
						 if(arr[i] == vowels[j]) cnt++;
				}
			}
			if(cnt != l && cnt >= 1 && l-cnt>=2)
				sb.append(str + "\n");
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			backTracking(depth+1, i, l);
			visited[i] = false;
		}
	}
}
