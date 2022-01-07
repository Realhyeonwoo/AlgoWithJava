import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class boj1406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> iter = list.listIterator();
		
		for(int i=0; i<str.length(); i++)
			iter.add(str.charAt(i));
		
//		for(int i=0; i<str.length(); i++)
//			list.add(str.charAt(i));
//		int idx = list.size();
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch(order) {
			case "L":
//				if(idx != 0) idx--;
				if(iter.hasPrevious()) 
					iter.previous();
				break;
			case "D":
//				if(idx != list.size()) idx++;
				if(iter.hasNext())
					iter.next();
				break;
			case "B":
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
//				if(idx != 0) {
//					list.remove(idx-1);
//					idx--;
//				}
				break;
			case "P":
//				list.add(idx, st.nextToken().charAt(0));
//				idx++;
				iter.add(st.nextToken().charAt(0));
				break;
				default:
			}
		}
		
		for(char v : list)
			bw.write(v);
		bw.flush();
		bw.close();
//		
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
	}
}
