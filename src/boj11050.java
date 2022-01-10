import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj11050 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int n = 1, m = 1;
		for (int i = N; i >= (N - K + 1); i--) {
			n *= i;
		}
		
		for(int i=K; i>=1; i--) {
			m *= i;
		}
		
		bw.write(n/m + "");
		bw.flush();
		bw.close();

	}
}
