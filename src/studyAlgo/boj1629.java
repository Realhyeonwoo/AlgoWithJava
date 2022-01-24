package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1629 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(doMultiple(A, B, C));
	}

	private static long doMultiple(long a, long b, long c) {
		if(b == 1) return a % c;
		long val = doMultiple(a, b/2, c);
		val = val * val % c;
		if(b%2 == 0) return val;
		return val * a % c;
	}
}

// ������ �ͳ���
// 1�� ���̳밡 ��������.
// K�� ���̳밡 �������� (K+1)�� ���̳뵵 ��������.
