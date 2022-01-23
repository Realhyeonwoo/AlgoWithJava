package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj17478 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		recursion(N, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void recursion(int n, int t) {
		if(t > n) return;
		
		if(t == n) {
			for(int i=0; i<t*4; i++) sb.append("_");
			sb.append("\"����Լ��� ������?\"\n");
			for(int i=0; i<t*4; i++) sb.append("_");
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
			for(int i=0; i<t*4; i++) sb.append("_");
			sb.append("��� �亯�Ͽ���.\n");
			return;
		}
		for(int i=0; i<t*4; i++) sb.append("_");
		sb.append("\"����Լ��� ������?\"\n");
		for(int i=0; i<t*4; i++) sb.append("_");
		sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		for(int i=0; i<t*4; i++) sb.append("_");
		sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		for(int i=0; i<t*4; i++) sb.append("_");
		sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		
		recursion(n, t+1);
		
		for(int i=0; i<t*4; i++) sb.append("_");
		sb.append("��� �亯�Ͽ���.\n");
	}
}
