package programmers.level2;

public class 전력망을_둘로_나누기2 {
	
	public static void main(String[] args) {
		
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		
		int answer = solution(n, wires);
		System.out.println(answer);
	}
	
	private static int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		int[][] wireMap = new int[n+1][n+1];
		for(int[] wire : wires) {
			wireMap[wire[0]][wire[1]] = 1;
			wireMap[wire[1]][wire[0]] = 1;
		}
		
		for(int i=0; i<wires.length; i++) {
			int[][] map = cloneMap(n+1, wireMap);
			boolean[] visited = new boolean[n+1];
			
			map[wires[i][0]][wires[i][1]] = 0;
			map[wires[i][1]][wires[i][0]] = 0;

			int cnt = dfs(wires[i][0], map, visited);
			answer = Math.min(answer, Math.abs(cnt - (Math.abs(cnt - n))));
		}
		
		return answer;
	}
	
	private static int dfs(int wire, int[][] map, boolean[] visited) {
		if(visited[wire]) {
			return 0;
		}
		
		visited[wire] = true;
		int sum = 1;
		
		for(int i=0; i<map.length; i++) {
			if(visited[i] || map[wire][i] == 0) continue;
			map[wire][i] = 0;
			map[i][wire] = 0;
			sum += dfs(i, map, visited);
		}
		
		return sum;
	}

	private static int[][] cloneMap(int N, int[][] wireMap) {
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = wireMap[i][j];
			}
		}
		return arr;
	}
}
