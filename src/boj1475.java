import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1475 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int[] arr = new int[10];
		for(int i=0; i<str.length(); i++) {
			arr[Integer.parseInt(str.charAt(i)+"")]++;
		}
		
		int maxIndex = 0;
		int maxValue = 0;
		for(int i=0; i<arr.length; i++) {
			if(maxValue < arr[i]) {
				maxValue = arr[i];
				maxIndex = i;
			}
		}	
		
		if(maxIndex == 6 || maxIndex == 9) {
			boolean flag = false;
			for(int i=0; i<arr.length; i++) {
				if(i!=6 && i!=9 && maxValue == arr[i]) {
					maxValue = arr[i];
					flag = true;
				}
			}
			
			if(flag) {
				sb.append(maxValue);
			} else {				
				int cnt = (arr[6] + arr[9]) / 2;
				sb.append((arr[6]+arr[9])%2==0 ? cnt : cnt+1);
			}
		} else {
			sb.append(maxValue);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
