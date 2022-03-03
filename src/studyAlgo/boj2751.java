import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class boj2751 {
	static int SIZE = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) sb.append(arr.get(i) + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
//		// INPUT
//		int[] arr = new int[SIZE + 1];
//		int[] minusArr = new int[SIZE + 1];
//		int N = Integer.parseInt(br.readLine());
//		for (int i = 0; i < N; i++) {
//			int num = Integer.parseInt(br.readLine());
//			if (num >= 0) {
//				arr[num]++;
//			} else {
//				minusArr[Math.abs(num)]++;
//			}
//		}
//
//		StringBuilder sb = new StringBuilder();
//		// SIMULATION
//		int count = 0;
//		for (int i = minusArr.length-1; i>0; i--) {
//			while (minusArr[i] > 0) {
//				sb.append((i*(-1)) + "\n");
//				minusArr[i]--;
//				count++;
//			}
//			if (count == N)
//				break;
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			while (arr[i] > 0) {
//				sb.append(i + "\n");
//				arr[i]--;
//				count++;
//			}
//			if (count == N)
//				break;
//		}
//
//		// OUTPUT
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
		
	}
}
