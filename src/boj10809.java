import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj10809 {
	static int N = 26;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[N];
		Arrays.fill(arr, -1);
		
		// 입력
		String str = br.readLine();
		
		// 인덱스 저장
		for(int i=0; i<str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			if(arr[idx] == -1) arr[idx] = i;
		}
		
		// 출력
		for(int i=0; i<arr.length; i++) {
			bw.write(String.valueOf(arr[i]) + " ");
		}
		bw.flush();
		bw.close();
	}
}
