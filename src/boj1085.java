import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1085 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int d1 = ((w-x) < (h-y)) ? w-x : h-y;
		int d2 = (x < y) ? x : y;

		if(d1 > d2) {
			System.out.println(d2);
		} else {
			System.out.println(d1);
		}
		
	}
}
