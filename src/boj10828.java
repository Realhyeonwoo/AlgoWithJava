import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stk = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int num = 0;
			if(st.hasMoreTokens())
				 num = Integer.parseInt(st.nextToken());
			
			if(order.equals("push")) {
				stk.push(num);
			} else if(order.equals("pop")) {
				sb.append(stk.isEmpty() ? -1 + "\n" : stk.pop() + "\n");
			} else if(order.equals("size")) {
				sb.append(stk.size() + "\n");
			} else if(order.equals("empty")) {
				sb.append(stk.isEmpty() ? 1 + "\n" : 0 + "\n");
			} else if(order.equals("top")) {
				sb.append(stk.isEmpty() ? -1 + "\n" : stk.peek() + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
