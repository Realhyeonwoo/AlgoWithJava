import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stk = new Stack<>();
		for(int i=1; i<=N; i++) {
			while(true) {
				if(stk.isEmpty()) {
					 sb.append(stk.size() + " ");
					 stk.push(i);
					 break;
				}
				
				if(arr[stk.peek()] < arr[i]) {
					stk.pop();
				} else {
					sb.append(stk.peek() + " ");
					stk.push(i);
					break;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
