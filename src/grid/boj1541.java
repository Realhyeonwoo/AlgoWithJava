package grid;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("\\-");
		
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			String[] temp = arr[i].split("\\+");
			int sum = 0;
			for(int t=0; t<temp.length; t++) {
				sum += Integer.parseInt(temp[t]);
			}
			if(i == 0) ans = sum;
			else ans -= sum;
		}
		
		System.out.println(ans);
	}
}
