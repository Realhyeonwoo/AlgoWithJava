import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1152 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 입력
//		st = new StringTokenizer(br.readLine());
		String str = br.readLine();
		
		// 갯수 구하기
//		int count = 0;
//		while(st.hasMoreTokens()) {
//			st.nextToken();
//			count++;
//		}
		
		
		// 출력
//		bw.write(String.valueOf(count));
		bw.write(String.valueOf((str.trim().isEmpty()) ? 0 : str.trim().split(" ").length));
		bw.flush();
		bw.close();
	}
}
