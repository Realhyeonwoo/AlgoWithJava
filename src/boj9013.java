import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj9013 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			sb.append(isVps(str) ? "YES\n" : "NO\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean isVps(String str) {
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stk.push(c);
			} else {
				if(stk.isEmpty()) return false;
				if(stk.peek() != '(') return false;
				stk.pop();
			}
		}
		
		return (stk.isEmpty()) ? true : false;
	}
}
