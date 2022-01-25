package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1182 {
	static int[] arr;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) { 
			backTracking(0, i, S);
			System.out.println();
		}
		
		System.out.println(cnt);
	}
	private static void backTracking(int depth, int n, int s) {
		if(n == depth) {
			System.out.println("n°ª : " + n);
			for(int i=0; i<visited.length; i++)
				if(visited[i]) System.out.print(arr[i] + " ");
			System.out.println();
//			int sum = 0;
//			for(int i=0; i<visited.length; i++)
//				if(visited[i]) sum += arr[i];
//			if(sum == s) {
//				for(int i=0; i<visited.length; i++)
//					if(visited[i]) System.out.print(arr[i] + " ");
//				System.out.println();
//				cnt++;
//			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visited[i] || depth > i) continue;
			visited[i] = true;
			backTracking(depth + 1, n, s);
			visited[i] = false;
		}
	}
}
