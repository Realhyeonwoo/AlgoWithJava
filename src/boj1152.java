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
		
		// �Է�
//		st = new StringTokenizer(br.readLine());
		String str = br.readLine();
		
		// ���� ���ϱ�
//		int count = 0;
//		while(st.hasMoreTokens()) {
//			st.nextToken();
//			count++;
//		}
		
		
		// ���
//		bw.write(String.valueOf(count));
		bw.write(String.valueOf((str.trim().isEmpty()) ? 0 : str.trim().split(" ").length));
		bw.flush();
		bw.close();
	}
}
