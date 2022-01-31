package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class boj15688 {
 //	static int SIZE = 1000000;
//	static int[] plusArr = new int[SIZE + 1];
//	static int[] minusArr = new int[SIZE + 1];
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		for(int v : list)
			sb.append(v + "\n");
//		int[] arr = new int[SIZE*2 + 1];
//		int N = Integer.parseInt(br.readLine());
//		for(int i=0; i<N; i++) {
//			arr[Integer.parseInt(br.readLine()) + SIZE]++;
//		}
//		
//		for(int i=0; i<=SIZE*2; i++) {
//			while(arr[i]-- != 0) {
//				sb.append(i-SIZE + "\n");
//			}
//		}
		
//		int N = Integer.parseInt(br.readLine());
//		int plusMaxValue = Integer.MIN_VALUE;
//		int minusMaxValue = Integer.MIN_VALUE;
//		for(int i=0; i<N; i++) {
//			int n = Integer.parseInt(br.readLine());
//			if(n>=0) {
//				plusArr[n]++;
//				plusMaxValue = Math.max(plusMaxValue, n);
//			} else {
//				minusArr[Math.abs(n)]++;
//				minusMaxValue = Math.max(minusMaxValue, Math.abs(n));
//			}
//
//		}
//		
//		for(int i=minusMaxValue; i>0; i--) {
//			while(minusArr[i] > 0) {
//				sb.append(-i + "\n");
//				minusArr[i]--;
//			}
//		}
//		for(int i=0; i<=plusMaxValue; i++) {
//			while(plusArr[i] > 0) {
//				sb.append(i + "\n");
//				plusArr[i]--;
//			}
//		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
