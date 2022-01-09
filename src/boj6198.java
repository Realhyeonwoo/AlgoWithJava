import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj6198 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Long> stk = new Stack<>();
		long sum = 0;
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			
			while(!stk.isEmpty() && stk.peek() <= num) {
				stk.pop();
			}
			
			sum += stk.size();
			stk.push(num);
		}
		
		
		bw.write(sum+"");
		bw.flush();
		bw.close();
		
	}
}
