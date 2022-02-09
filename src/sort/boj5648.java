package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj5648 {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] arr;
		arr = new String[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.next();
		
		for(int i=0; i<N; i++) {
			String str = arr[i];
			String temp = "";
			boolean isZero = false;
			for(int j=str.length()-1; j>=0; j--) {
				if(isZero && str.charAt(j) == '0') {
					temp += str.charAt(j);
				}
				if(str.charAt(j) != '0') {
					isZero = true;
					temp += str.charAt(j)+"";
				}
			}
			arr[i] = temp;
		}
		
		int[] num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(num);
		
		for(int i=0; i<num.length; i++)
			System.out.println(num[i]);
//		StringBuilder sb = new StringBuilder();
//		for(int v : num)
//			sb.append(v + "\n");
//		
//		sc.close();
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
		
		
	}
}
