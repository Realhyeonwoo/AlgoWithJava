package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686 {
	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int N, M;
	static int[][] arr;
	static boolean[] visited;
	static ArrayList<Pos> homeList = new ArrayList<>();
	static ArrayList<Pos> chickenList = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 1)
					homeList.add(new Pos(y, x));
				if (arr[y][x] == 2)
					chickenList.add(new Pos(y, x));
			}
		}
		visited = new boolean[chickenList.size()];

		backTracking(0, 0);

		System.out.println(ans);
	}

	private static void backTracking(int depth, int start) {
		if (depth == M) {
			int sum = 0;
			for (Pos h : homeList) {
				int tempSum = Integer.MAX_VALUE;
				for (int i = 0; i < chickenList.size(); i++) {
					if(!visited[i]) continue;
					int dist = Math.abs(h.y - chickenList.get(i).y) + Math.abs(h.x - chickenList.get(i).x);
					tempSum = Math.min(tempSum, dist);
				}
				sum += tempSum;
			}

			ans = Math.min(ans, sum);
			return;
		}

		for (int i = start; i < chickenList.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			backTracking(depth + 1, i);
			visited[i] = false;
		}

	}
}
