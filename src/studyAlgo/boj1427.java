import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1427 {
	static int SIZE = 10;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[SIZE]; // 0 ~ 9
		int N = Integer.parseInt(br.readLine());
		
		while(N > 0) {
			arr[N%10]++;
			N /= 10;
		}
		
		for(int i=9; i>=0; i--) {
			for(int j=0; j<arr[i]; j++) {
				sb.append(i);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
