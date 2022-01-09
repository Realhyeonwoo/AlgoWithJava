import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stk = new Stack<>();
		ArrayList<Integer> output = new ArrayList<>();
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=arr.length-1; i>=0; i--) {
			int num = arr[i];
			while (true) {
				if (stk.isEmpty()) {
					output.add(-1);
					stk.push(num);
					break;
				} else if (!stk.isEmpty() && stk.peek() <= num) {
					stk.pop();
				} else {
					output.add(stk.peek());
					stk.push(num);
					break;
				}
			}
		}
		
		for(int i=output.size()-1; i>=0; i--)
			sb.append(output.get(i) + " ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
