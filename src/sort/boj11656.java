package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj11656 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String[] arr = new String[str.length()];
		Arrays.fill(arr, "");
		for(int i=0; i<str.length(); i++) {
			for(int j=i; j<str.length(); j++) {
				arr[i] += str.charAt(j);
			}
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(String s : arr)
			sb.append(s + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
