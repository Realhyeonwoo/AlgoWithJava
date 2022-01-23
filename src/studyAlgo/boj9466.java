package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj9466 {
	static int n;
	static int[] arr = new int[100000 + 1];
	static boolean[] visited = new boolean[100000 + 1];
	static boolean[] tempVisited = new boolean[100000 + 1];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			// INPUT
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(visited, false);
			
			// SIMULATION
			for(int i=1; i<=n; i++) {
				if(visited[i]) continue;
				Arrays.fill(tempVisited, false);
				
			}

			// OUTPUT
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(!visited[i]) cnt++;
			}
			System.out.println(cnt);
		}
	}

	private static boolean isCycle(int start, int i) {
		if(start == arr[start]) {
			tempVisited[start] = true;
			return true;
		}
		
		int now = i;
		int next = arr[now];
		tempVisited[now] = true;
		while(true) {
			if(start == next) {
				tempVisited[start] = true;
				tempVisited[next] = true;
				return true;
			}
			
			if(tempVisited[next]) return false;
			tempVisited[next] = true;
				
			now = arr[now];
			next = arr[arr[now]];
		}
	}
}

