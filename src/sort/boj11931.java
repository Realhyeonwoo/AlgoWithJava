package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class boj11931 {
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list, new Comparator<Integer> () {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		
		});
		for(int v : list)
			sb.append(v + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
