package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] temp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp[i] = arr[i];
		}
		Arrays.sort(arr);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int val = arr[0];
		list.add(val);
		for(int i=1; i<N; i++) {
			if(arr[i] != val) {
				val = arr[i];
				list.add(val);
			}
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), i);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(map.get(temp[i]) + " ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
