import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj10773 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stk = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stk.pop();
			} else {
				stk.push(num);
			}
		}
		
		int sum = 0;
		while(!stk.isEmpty()) {
			sum += stk.pop();
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
