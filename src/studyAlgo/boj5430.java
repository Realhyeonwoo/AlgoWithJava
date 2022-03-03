import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			char[] order = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			char[] str = br.readLine().toCharArray();
//			LinkedList<Integer> list = new LinkedList<>();
			Queue<Integer> list = new LinkedList<Integer>();
			for(int i=1; i<str.length-1; i+=2) {
				list.add(Integer.parseInt(str[i]+""));
			}
			
			boolean isError = false;
			for(char c : order) {
				if(c == 'R') {
//					Collections.reverse(list);
					int size = list.size();
					for(int i=0; i<size; i++) {
						int num = list.poll();
						list.add(num);
					}
				} else if(c == 'D') {
					if(list.size() == 0) {
						isError = true;
						break;
					}
					list.poll();
				}
				System.out.println(list);
			}
			
			
			if(isError) {
				sb.append("error\n");
			} else if(!isError && list.size() == 0) {
				sb.append("[]\n");
			} else {
				sb.append("[");
				for(int i=0; i<list.size()-1; i++)
					sb.append(list.poll() + ",");
//					sb.append(list.get(i) + ",");
//				sb.append(list.get(list.size()-1) + "]\n");
				sb.append(list.poll() + "]\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
