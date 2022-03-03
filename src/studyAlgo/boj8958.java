
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			String[] arr = str.split("");
			int score = 1, sum = 0, idx = 0;
			while(arr.length > idx) {			
				if(arr[idx].equals("O")) {
					sum += score;
					score++;
				} else {
					score = 1;
				}
				idx++;
			}
			sb.append(sum + "\n");
			
		}
		System.out.println(sb);
		bw.flush();
		bw.close();
		
}}
