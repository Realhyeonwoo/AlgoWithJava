import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);
		double M = score[N-1];
		double sum = 0;
		for(int i=0; i<score.length; i++) {
			sum = sum + (score[i]/M*100);
		}
		System.out.println(sum/N);
	}
}

