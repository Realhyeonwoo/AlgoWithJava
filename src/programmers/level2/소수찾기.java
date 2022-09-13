package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	
	public static void main(String[] args) {
		
//		String numbers = "17";
		String numbers = "011";
		int answer = solution(numbers);
		System.out.println(answer);
	}
	
	static private int solution(String numbers) {
		/**
		 * 
		 * 1. numbers 1 ~ nubers.length 留뚰겮 �닽�옄 �꽑�깮
		 * 2. �꽑�깮�맂 �닽�옄 媛��닔�뜲濡� �닚�뿴 由ъ뒪�듃 �깮�꽦
		 * 3. �깮�꽦�맂 �닽�옄 �냼�닔 �씤吏� �뙋蹂�
		 *  - �냼�닔�씠硫� Set�뿉 ���옣
		 * 4. set size() 媛� 由ы꽩
		 * 
		 */
		Set<Integer> ansSet = new HashSet<>();
		String[] arr = numbers.split("");
		boolean[] visited = new boolean[numbers.length()];
		ArrayList<String> list = new ArrayList<>();
		for(int i=1; i<=numbers.length(); i++) {
			permutation(0, i, arr, list, visited, ansSet);
		}
		return ansSet.size();
	}
	
	static private void permutation(int depth, int cnt, String[] arr, ArrayList<String> list, boolean[] visited, Set<Integer> ansSet) {
		if(depth == cnt) {
			String str = "";
			for(int i=0; i<cnt; i++)
				str += list.get(i);
			int num = Integer.parseInt(str);
			System.out.println(str + " > " + num + " : " + isPrime(num));
			if(isPrime(num)) {
				ansSet.add(num);
			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			list.add(arr[i]);
			permutation(depth+1, cnt, arr, list, visited, ansSet);
			visited[i] = false;
			list.remove(list.size()-1);
		}
	}

	private static boolean isPrime(int num) {
		if(num == 0 || num == 1) return false;
		if(num == 2) return true;
		
		for(int i=2; i<=(num/2); i++) {
			if((num%i) == 0) return false;
		}
		return true;
	}
}
