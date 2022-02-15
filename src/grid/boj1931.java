package grid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931 {
	static class Time {
		int start, end;

		Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static int N;
	static ArrayList<Time> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Time>() {
			public int compare(Time o1, Time o2) {
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
		});
		
		int ans = 1;
		int time = list.get(0).end;
		for(int i=1; i<list.size(); i++) {
			if(time <= list.get(i).start) {
				ans++;
				time = list.get(i).end;
			}
		}
		
		System.out.println(ans);
	}
}
