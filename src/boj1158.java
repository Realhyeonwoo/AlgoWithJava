import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=N; i++)
			list.add(i);
		
		int idx = 0;
		sb.append("<");
		while(!list.isEmpty()) {
			if(list.size() == 1) {
				sb.append(list.remove(0) + ">");
				break;
			}
			for(int i=0; i<K-1; i++) {
				idx++;
				if(idx >= list.size()) idx = 0;
			}
			sb.append(list.remove(idx) + ", ");
			
			if(idx >= list.size()) idx = 0;
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
