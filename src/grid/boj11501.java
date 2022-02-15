package grid;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i] = n;
			}
			int maxV = arr[N-1];
			long sum = 0;
			for(int i=N-2; i>=0; i--) {
				if(arr[i] > maxV) maxV = arr[i];
				sum += maxV - arr[i];
			}
			
			sb.append(sum + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
