import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력
		String str = br.readLine();
		
		// 대문자로 통일
		str = str.toUpperCase();
		
		// 배열로 카운팅
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i) - 'A']++;
		}
		
		// 배열 중 최댓값 찾아서 알파벳 출력(idx + 'a')
		int idx = 0, max = arr[idx];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) {
				idx = i;
				max = arr[i];
			}
		}
		
		// 가장 많이 사용된거 갯수가 갈을 때 출력
		int same = 0;
		for(int i=0; i<arr.length; i++) {
			if(max == arr[i]) same++;
		}
		
		// 출력
		if(same >= 2) {
			bw.write("?");
		} else {
			bw.write(String.valueOf((char)('A'+idx)));
		}
		bw.flush();
		bw.close();
	}
}
