 package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class boj11652_usingMap {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		Map<Long, Integer> map = new HashMap<>();	
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				int cnt = map.get(arr[i]);
				map.put(arr[i], cnt+1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		int val = Integer.MIN_VALUE;
		long answer = 0;
		for(Long key : map.keySet()) {
			if(val < map.get(key)) {
				val = map.get(key);
				answer = key;
				
			} else if((val == map.get(key)) && (answer > key)) {
				val = map.get(key);
				answer = key;
			}
		}
		
		System.out.println(answer);
		
	}
}