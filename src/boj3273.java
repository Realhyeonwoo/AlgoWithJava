import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj3273 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int SIZE = 2000000+1;
//		int SIZE = 0;
//		for(int i=0; i<n; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			arr[i] = num;
//			if(num > SIZE) SIZE = num;
//		}
		int x = Integer.parseInt(br.readLine());
		
		int ans = 0;
		boolean[] checkArr = new boolean[SIZE + 1];
		for(int v : arr) {
			if(checkArr[Math.abs(x-v)]) {
				ans++;
			} else {
				checkArr[v] = true;
			}
		}
		
		System.out.println(ans);
	}
}
