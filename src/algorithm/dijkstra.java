package algorithm;

public class dijkstra {

	private final static int INF = Integer.MAX_VALUE;
	private final static int SIZE = 6;
	
	public static void main(String[] args) {
		int[][] arr = initArray();
		
		for(int i=0; i<SIZE; i++) {
			boolean[] visited = new boolean[SIZE];
			int[] dist = dijkstra(i, arr, visited);
			printResult(i, dist);
		}
	}

	private static int[] dijkstra(int start, int[][] arr, boolean[] visited) {
		int[] dist = arr[start].clone();
		visited[start] = true;
		
		while(true) {
			// 모든 노드 방문했는지 확인
			boolean isFinished = true;
			for(boolean b : visited) {
				if(!b) {
					isFinished = false;
					break;
				}
			}
			if(isFinished) break;
			
			int minValue = Integer.MAX_VALUE;
			int minIndex = start;
			for(int i=0; i<SIZE; i++) {
				if(visited[i]) continue;
				if(dist[i] < minValue) {
					minValue = dist[i];
					minIndex = i;
				}
			}
			
//			System.out.println(">>> " + minIndex);
			visited[minIndex] = true;
			for(int i=0; i<SIZE; i++) {
				if(visited[i] || arr[minIndex][i] == Integer.MAX_VALUE) continue;
				if(dist[minIndex] + arr[minIndex][i] < dist[i]) {
					dist[i] = dist[minIndex] + arr[minIndex][i];
				}
			}
			
//			for(int v : dist)
//				System.out.print(v + " ");
//			System.out.println();
		}
		
		return dist;
	}

	private static int[][] initArray() {
		int[][] arr = {
				{0, 4, 2, INF, INF, INF},
				{4, 0, INF, 4, 5, INF},
				{2, INF, 0, INF, 4, INF},
				{INF, 4, INF, 0, INF, 1},
				{INF, 5, 4, INF, 0, 2},
				{INF, INF, INF, 1, 2, 0},
		};
		return arr;
	}
	
	private static void printResult(int i, int[] dist) {
		System.out.println("==============================");
		System.out.println("START >> " + (i+1));
		for(int v : dist)
			System.out.print(v + " ");
		System.out.println();
		System.out.println("==============================");
	}
}
