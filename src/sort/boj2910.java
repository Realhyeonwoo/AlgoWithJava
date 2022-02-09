package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class boj2910 {
	static class Num {
		int num, cnt, idx;

		Num(int num, int cnt, int idx) {
			this.num = num;
			this.cnt = cnt;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<Num> list = new ArrayList<>();
		HashSet<Integer> set = new LinkedHashSet<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>(); // <숫자, 갯수>
		HashMap<Integer, Integer> indexMap = new HashMap<>(); // <숫자, 최초인덱스>

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}

			if (!indexMap.containsKey(n)) {
				indexMap.put(n, i);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int n = entry.getKey();
			int cnt = entry.getValue();
			int idx = indexMap.get(n);
			
			list.add(new Num(n, cnt, idx));
		}
		
		Collections.sort(list, new Comparator<Num>() {
			public int compare(Num o1, Num o2) {
				if(o1.cnt == o2.cnt) {
					return o1.idx - o2.idx;
				} else {
					return o2.cnt - o1.cnt;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Num num : list) {
			int cnt = num.cnt;
			while(cnt > 0) {
				sb.append(num.num + " ");
				cnt--;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
