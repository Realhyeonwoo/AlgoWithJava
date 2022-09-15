package programmers.level2;

import java.util.ArrayList;

public class 피로도 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20}, {50,40}, {30,10}};
		
		int answer = solution(k, dungeons);
		System.out.println(answer);
	}

	private static int solution(int k, int[][] dungeons) {
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[dungeons.length];
		int[] ans = new int[1];
		
		permutation(0, k, dungeons, visited, ans);
		
		return ans[0];
	}

	private static void permutation(int depth, int hp, int[][] dungeons, boolean[] visited, int[] ans) {
		if(depth == dungeons.length) {
			ans[0] = Math.max(ans[0], depth);
			return;
		}
		
		for(int i=0; i<dungeons.length; i++) {
			if(visited[i]) continue;
			if(hp < dungeons[i][0]) {
				ans[0] = Math.max(ans[0], depth);
				continue;
			}
			visited[i] = true;
			hp -= dungeons[i][1];
			permutation(depth+1, hp, dungeons, visited, ans);
			visited[i] = false;
			hp += dungeons[i][1];
		}
	}
}
