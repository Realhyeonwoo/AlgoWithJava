import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10808 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int[] arr = new int[26];
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i) - 'a']++;
		}
		
		for(int v : arr)
			sb.append(v + " ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
