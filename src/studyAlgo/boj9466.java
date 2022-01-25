//package studyAlgo;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//<<<<<<< HEAD
//import java.util.StringTokenizer;
//
//public class boj9466 {
//	static int[] arr;
//	static int[] visited;
//=======
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class boj9466 {
//	static int NOT_VISITED = 0;
//	static int IN_CYCLE = -1;
//	static int n;
//	static int[] arr;
//	static int[] visited;
//	static ArrayList<Integer> list = new ArrayList<>();
//
//>>>>>>> 8d26abd3dc63bf0221941a63537f5043bb4a4476
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
//<<<<<<< HEAD
//		
//		int T = Integer.parseInt(br.readLine());
//		for(int tc=1; tc<=T; tc++) {
//			int N = Integer.parseInt(br.readLine());
//			arr = new int[N+1];
//			visited = new int[N+1];
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for(int i=1; i<=N; i++) 
//				arr[i] = Integer.parseInt(st.nextToken());
//			
//			for(int i=1; i<=N; i++) {
//				if(visited[i] == 0) run(i);
//				System.out.println();
//				for(int j=1; j<=N; j++)
//					System.out.print(visited[j] + " ");
//				System.out.println();
//				
//			}
//			
//			int cnt = 0;
//			for(int i=1; i<=N; i++)
//				if(visited[i] != -1) cnt++;
//			sb.append(cnt + "\n");
//		}
//		
//=======
//
//		int T = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			// INPUT
//			n = Integer.parseInt(br.readLine());
//			arr = new int[n + 1];
//			visited = new int[n + 1];
//
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int i = 1; i <= n; i++)
//				arr[i] = Integer.parseInt(st.nextToken());
//			Arrays.fill(visited, NOT_VISITED);
//
//			// SIMULATION
//			for (int i = 1; i <= n; i++) {
//				if (visited[i] == NOT_VISITED)
//					isCycle(i);
//			}
//
//			// OUTPUT
//			int cnt = 0;
//			for (int i = 1; i <= n; i++) {
//				if (visited[i] != IN_CYCLE)
//					cnt++;
//			}
//			sb.append(cnt + "\n"); 
//		}
//>>>>>>> 8d26abd3dc63bf0221941a63537f5043bb4a4476
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
//	}
//<<<<<<< HEAD
//	
//	private static void run(int start) {
//		int cur = start;
//		
//=======
//
//	private static void isCycle(int start) {
//		int cur = start;
//>>>>>>> 8d26abd3dc63bf0221941a63537f5043bb4a4476
//		while(true) {
//			visited[cur] = start;
//			cur = arr[cur];
//			
//			if(visited[cur] == start) {
//<<<<<<< HEAD
//				while(visited[cur] != -1) {
//					visited[cur] = -1;
//					cur = arr[cur];
//				}
//				return;
//			} else if(visited[cur] != 0) { 
//=======
//				while(visited[cur] != IN_CYCLE) {
//					visited[cur] = IN_CYCLE;
//					cur = arr[cur];
//				}
//				return;
//			} else if(visited[cur] != NOT_VISITED) {
//>>>>>>> 8d26abd3dc63bf0221941a63537f5043bb4a4476
//				return;
//			}
//		}
//	}
//}
