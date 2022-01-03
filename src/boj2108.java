import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class boj2108 {
	static int SIZE = 4000 + 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Integer> arr = new ArrayList<>();
		int[] minusArr = new int[SIZE];
		int[] plusArr = new int[SIZE];
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr.add(num);
			if(num >=0) {
				plusArr[num]++;
			} else {
				minusArr[num*(-1)]++;
			}
		}
		Collections.sort(arr);
		
		//»ê¼úÆò±Õ
		double sum = 0.0;
		for(int i=0; i<arr.size(); i++) sum+= arr.get(i);
		sb.append(Math.round(sum/N) + "\n");
		
		//Áß¾Ó°ª
		sb.append(arr.get(N/2) + "\n");
		
		//ÃÖºó°ª
		int MAX = Integer.MIN_VALUE;
		int value = 0;
		for(int i=0; i<minusArr.length; i++) {
			if(minusArr[i] == 0) continue;
			if(minusArr[i] > MAX) {
				MAX = minusArr[i];
				value = i * (-1);
			}
		}
		for(int i=0; i<minusArr.length; i++) {
			if(plusArr[i] == 0) continue;
			if(plusArr[i] > MAX) {
				MAX = plusArr[i];
				value = i;
			}
		}
		
		int count = 0;
		for(int i=0; i<minusArr.length; i++) {
			if(minusArr[i] == MAX || plusArr[i] == MAX) count++;
		}
		
		if(count > 1) {
			int check = 0;
			for(int i=minusArr.length-1; i>0; i--) {
				if(check == 2) break;
				if(minusArr[i] == MAX) {
					check++;
					value = i *(-1);
				}
			}
			for(int i=0; i<plusArr.length; i++) {
				if(check == 2) break;
				if(plusArr[i] == MAX) {
					check++;
					value = i;
				}
			}
			sb.append(value + "\n");
		} else {
			sb.append(value + "\n");
		}
		
		//¹üÀ§
		sb.append(Collections.max(arr) - Collections.min(arr) + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
