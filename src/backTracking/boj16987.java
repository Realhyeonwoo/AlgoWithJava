package backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16987 {
	static class Egg {
		int s, w;

		Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}

	static int N;
	static Egg[] arr;
	static int cnt;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		backTracking(0);
		
		System.out.println(ans);
	}

	private static void backTracking(int depth) {
		if (depth == N) {
			ans = Math.max(ans, cnt);
			return;
		}
		
		if (arr[depth].s <= 0 || cnt == N - 1) {
			backTracking(depth + 1);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (depth == i || arr[i].s <= 0)
				continue;

			arr[depth].s -= arr[i].w;
			arr[i].s -= arr[depth].w;
			if (arr[depth].s <= 0)
				cnt++;
			if (arr[i].s <= 0)
				cnt++;

			backTracking(depth + 1);

			if (arr[depth].s <= 0)
				cnt--;
			if (arr[i].s <= 0)
				cnt--;
			arr[depth].s += arr[i].w;
			arr[i].s += arr[depth].w;

		}

	}
}
