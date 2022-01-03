import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2447 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// INPUT
		int N = Integer.parseInt(br.readLine());
		
		makeStar(N);
	}

	private static void makeStar(int n) {
		if(n == 0) return;
		
		
		System.out.println("***\n* *\n***");
		
		makeStar(n-1);
		
	}
}
//*** *** *** *** *** *** *** *** ***

