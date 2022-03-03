import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2839 {
	public static void main(String[] args) throws Exception {
		final int THREE = 3;
		final int FIVE = 5;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = -1;
		int ans = Integer.MAX_VALUE;
		
		for(int i=0; i<=N/FIVE; i++) {
			int temp = N - i * FIVE;
			if(temp%THREE != 0) continue;
			sum = i + (temp/THREE);
			if(ans > sum) ans = sum;
		}
		
		System.out.println((sum == -1) ? -1 : ans);
	}
}
