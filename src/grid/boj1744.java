package grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class boj1744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> plusList = new ArrayList<>();
		ArrayList<Integer> minusList = new ArrayList<>();
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num == 1) ans++;
			else if(num <= 0) {
				minusList.add(num);
			} else if(num >=0) {
				plusList.add(num);
			}
		}
		Collections.sort(plusList, Comparator.reverseOrder());
		Collections.sort(minusList, Comparator.reverseOrder());
		
		for(int i=0; i<plusList.size(); i+=2) {
			if(i+1 < plusList.size()) {
				ans += (plusList.get(i) * plusList.get(i+1));
			}
		}
		if(plusList.size()%2 != 0 && plusList.size() > 0) ans += plusList.get(plusList.size()-1);
		
		if(minusList.size() > 0 && minusList.get(0) == 0) {
			for(int i=minusList.size()-1; i>=0; i-=2) {
				if(i-1 >= 0) {
					ans += (minusList.get(i) * minusList.get(i-1));
				}
			}
		} else {
			for(int i=minusList.size()-1; i>=0; i-=2) {
				if(i-1 >= 0) {
					ans += (minusList.get(i) * minusList.get(i-1));
				}
			}
			if(minusList.size()%2 != 0 && minusList.size() > 0) ans += minusList.get(0);
		}
		
		System.out.println(ans);
	}
}
