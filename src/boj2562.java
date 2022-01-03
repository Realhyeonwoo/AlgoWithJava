import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2562 {
	static int N = 9;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int max = -1, index = 0;;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(max < num) {
				max = num;
				index = i;
			}
		}
		
		
		bw.write(max + "\n" + (index+1));
		bw.flush();
		bw.close();
	}
}
