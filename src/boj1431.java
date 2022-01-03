import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class boj1431 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// INPUT
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		// SIMULATION
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return Integer.compare(o1.length(), o2.length());
				} else {
					int sum1 = sum(o1);
					int sum2 = sum(o2);
					if (sum1 != sum2) {
						return Integer.compare(sum1, sum2);
					} else {
						return o1.compareTo(o2);
					}
				}
			}

			private int sum(String str) {
				int sum = 0;
				for (int i = 0; i < str.length(); i++) {
					sum += (Character.isDigit(str.charAt(i))) ? Integer.parseInt(str.charAt(i) + "") : 0;
				}
				return sum;
			}
		});

		// OUTPUT
		for (String v : arr)
			bw.write(v + "\n");
		bw.flush();
		bw.close();
	}
}
