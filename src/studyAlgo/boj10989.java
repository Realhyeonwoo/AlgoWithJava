import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class boj10989 {
	static int SIZE = 10000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// INPUT
		int[] arr = new int[SIZE + 1];
		int N = Integer.parseInt(br.readLine());
		int MAX = Integer.MIN_VALUE;

		// SIMULATION
		for(int i=0; i<N; i++) arr[Integer.parseInt(br.readLine())]++;
		
		// OUTPUT
		for(int i=0; i<=SIZE; i++) {
			while(arr[i] > 0) {
				bw.write(i + "\n");
				arr[i]--;
			}
		}
		bw.flush();
		bw.close();
	}
}
