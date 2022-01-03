import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj18870 {
	static int SIZE = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] tempArr = arr.clone();
		Arrays.sort(tempArr);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int index = 0;
		for(int v : tempArr) {
			if(hm.containsKey(v)) continue;
			hm.put(v, index++);
		}
		for(int v : arr) {
			sb.append(hm.get(v) + " ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
