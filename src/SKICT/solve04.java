package SKICT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class solve04 {
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int sum = 0;
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1}, {0, 2}, {1, 2}, {1, 4}};
		long answer = solution(n, edges);
	}

	private static long solution(int n, int[][] edges) {
		visited = new boolean[n];
		
		int[][] graph = new int[n][n];
		for(int i=0; i<edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		
//		for(int y=0; y<n; y++) {
//			for(int x=0; x<n; x++) {
//				System.out.print(graph[y][x] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		dfs(0, n, graph);
		
		System.out.println(sum);
		
		
		return 0;
	}

	private static void dfs(int depth, int n, int[][] graph) {
		if(depth == 3) {
			System.out.println("[ " + list.get(0) + " " + list.get(1) + " " + list.get(2) + "]");
			int a = distance(list.get(0), list.get(1), graph);
			System.out.println("================");
			int b = distance(list.get(1), list.get(2), graph);
			System.out.println("================");
			int c = distance(list.get(0), list.get(2), graph);
			System.out.println("================");
			System.out.println(a + " " + b + " " + c);
			System.out.println();
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			list.add(i);
			dfs(depth+1, n, graph);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}

	private static int distance(Integer num1, Integer num2, int[][] graph) {
		boolean[] v = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num1);
		v[num1] = true;
		
		int count = 0;
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int n = q.poll();
				System.out.println("N : " + n);
				System.out.println("COUNT : " + count);
				if(n == num2) {
					System.out.println(count);
					return count;
				}
				
				for(int j=0; j<graph.length; j++) {
					if(n == j || v[j]) continue;
					
					if(graph[n][j] == 1) {
						v[j] = true;
						q.add(j);
					}
				}
				
				count++;
			}
		}
		
		return -1;
	}
}
