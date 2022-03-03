import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int num = A * B * C;
		
		int[] arr = new int[10];
		Arrays.fill(arr, 0);
		while(num != 0) {
			arr[num % 10]++;
			num /= 10;
		}
		
		for(int idx=0; idx<arr.length; idx++) {
			bw.write(arr[idx] + "\n");
//			System.out.println(arr[idx]);
		}
		bw.flush();
		bw.close();
	}
}
