import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj2675 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for(int i=0; i<str.length(); i++) {
				for(int j=0; j<R; j++) {
					sb.append(str.charAt(i));
				}
			}
			sb.append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}
}
