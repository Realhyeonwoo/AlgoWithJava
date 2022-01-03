import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// �Է�
		String str = br.readLine();
		
		// �빮�ڷ� ����
		str = str.toUpperCase();
		
		// �迭�� ī����
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}
		
		// �迭 �� �ִ� ã�Ƽ� ���ĺ� ���(idx + 'a')
		int idx = 0, max = arr[idx];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) {
				idx = i;
				max = arr[i];
			}
		}
		
		// ���� ���� ���Ȱ� ������ ���� �� ���
		int same = 0;
		for(int i=0; i<arr.length; i++) {
			if(max == arr[i]) same++;
		}
		
		// ���
		if(same >= 2) {
			bw.write("?");
		} else {
			bw.write(String.valueOf((char)('A'+idx)));
		}
		bw.flush();
		bw.close();
	}
}
