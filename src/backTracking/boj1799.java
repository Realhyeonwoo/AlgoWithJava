package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1799 {
	static class Pos {
		int y, x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int chkCnt;
	static int N;
	static int[][] arr;
	static boolean[] rightupCross;
	static boolean[] rightDownCross;
	static ArrayList<Pos> list1 = new ArrayList<>();
	static ArrayList<Pos> list2 = new ArrayList<>();
	
	static boolean[] visited;
	static int ans1 = Integer.MIN_VALUE;
	static int ans2 = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		rightupCross = new boolean[2 * N + 1];
		rightDownCross = new boolean[2 * N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 1 && (y+x)%2 == 0)
					list1.add(new Pos(y, x));
				if (arr[y][x] == 1 && (y+x)%2 != 0)
					list2.add(new Pos(y, x));
			}
		}
		visited = new boolean[list1.size()];

		backTracking(0);
		
		Arrays.fill(rightupCross, false);
		Arrays.fill(rightDownCross, false);
		visited = new boolean[list2.size()];
		
		backTracking2(0);
//		System.out.println(ans1);
//		System.out.println(ans2);
		System.out.println(ans1 + ans2);
//		System.out.println("TEMP : " + chkCnt);
	}

	private static void backTracking2(int depth) {
		if (depth == list2.size()) {
			int cnt = 0;
			for(boolean v : visited)
				if(v) cnt++;
			ans2 = Math.max(ans2, cnt);
			return;
		}

		int y = list2.get(depth).y;
		int x = list2.get(depth).x;
		
		if (!rightupCross[y + x] && !rightDownCross[y - x + N - 1]) {
			rightupCross[y + x] = true;
			rightDownCross[y - x + N - 1] = true;
			visited[depth] = true;
			
			backTracking2(depth + 1);
			
			rightupCross[y + x] = false;
			rightDownCross[y - x + N - 1] = false;
			visited[depth] = false;
		}
		backTracking2(depth + 1);
		return;
	}
	
	private static void backTracking(int depth) {
		if (depth == list1.size()) {
			int cnt = 0;
			for(boolean v : visited)
				if(v) cnt++;
			ans1 = Math.max(ans1, cnt);
//			System.out.println(ans);
//			System.exit(0);
			
			chkCnt++;
			int[][] temp = new int[N][N];
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					int y = list1.get(i).y;
					int x = list1.get(i).x;
					temp[y][x] = 2;
				}
			}
			
//			System.out.println();
//			for(int y=0; y<temp.length; y++) {
//				for(int x=0; x<temp.length; x++) {
//					System.out.print(temp[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println("CNT : " + cnt);

			return;
		}

		int y = list1.get(depth).y;
		int x = list1.get(depth).x;
		
		
		if (!rightupCross[y + x] && !rightDownCross[y - x + N - 1]) {
			rightupCross[y + x] = true;
			rightDownCross[y - x + N - 1] = true;
			visited[depth] = true;
			
			backTracking(depth + 1);
			
			rightupCross[y + x] = false;
			rightDownCross[y - x + N - 1] = false;
			visited[depth] = false;
		}
		backTracking(depth + 1);
		return;
	}
}
