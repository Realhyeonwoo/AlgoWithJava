import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class boj5397 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			LinkedList<Character> list = new LinkedList<>();
			String str = br.readLine();
			int idx = 0;
			for(int i=0; i<str.length(); i++) {
				switch(str.charAt(i)) {
				case '<':
					if(idx != 0) idx--;
					break;
				case '>':
					if(idx != list.size()) idx++;
					break;
				case '-':
					if(idx != 0) {
						list.remove(idx-1);
						idx--;
					}
					break;
				default:
					list.add(idx++, str.charAt(i));
				}
			}
			for(char c : list)
				sb.append(c+"");
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
