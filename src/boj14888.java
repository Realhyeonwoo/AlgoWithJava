import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class boj14888 {
	static int N;
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<String> operator = new ArrayList<>();
	static ArrayList<Integer> output = new ArrayList<>();
	static ArrayList<String> temp= new ArrayList<>();
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int num = Integer.parseInt(st.nextToken());
			switch(i) {
			case 0:
				for(int j=0; j<num; j++) operator.add("+");
				break;
			case 1:
				for(int j=0; j<num; j++) operator.add("-");
				break;
			case 2:
				for(int j=0; j<num; j++) operator.add("*");
				break;
			case 3:
				for(int j=0; j<num; j++) operator.add("/");
				break;
				default :
			}
		}
		visited = new boolean[operator.size()];
//		for(String v : operator)
//			System.out.print(v + " ");
		
		backTracking(0);
		
//		for(String v : set)
//			System.out.println(v);
		for(String operatorString : set) {
			

			int sum = 0;
			switch(operatorString.charAt(0)) {
			case '+':
				sum = arr.get(0) + arr.get(1);
				break;
			case '-':
				sum = arr.get(0) - arr.get(1);
				break;
			case '*':
				sum = arr.get(0) * arr.get(1);
				break;
			case '/':
				sum = arr.get(0) / arr.get(1);
				break;
				default:
			}
			for(int i=1; i<operatorString.length(); i++) {
				switch(operatorString.charAt(i)) {
				case '+':
					sum += arr.get(i+1);
					break;
				case '-':
					sum -= arr.get(i+1);
					break;
				case '*':
					sum *= arr.get(i+1);
					break;
				case '/':
					sum /= arr.get(i+1);
					break;
					default:
				}
			}
			output.add(sum);
		}
		Collections.sort(output);
		StringBuilder sb = new StringBuilder();
		sb.append(Collections.max(output) + "\n" + Collections.min(output));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void backTracking(int depth) {
		if(depth == operator.size()) {
			String str = "";
			for(String v : temp)
				str += v;
			set.add(str);
			return;
		}
		
		for(int i=0; i<operator.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			temp.add(operator.get(i));
			backTracking(depth + 1);
			temp.remove(temp.size()-1);
			visited[i] = false;
		}
	}
}
