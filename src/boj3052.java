import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[1000];
		Arrays.fill(arr, 0);
		
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num % 42]++;
		}
		
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) count++;
		}
		System.out.println(count);
	}
}
