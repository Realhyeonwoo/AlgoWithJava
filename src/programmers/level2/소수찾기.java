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
		 * 1. numbers 1 ~ nubers.length 만큼 숫자 선택
		 * 2. 선택된 숫자 갯수데로 순열 리스트 생성
		 * 3. 생성된 숫자 소수 인지 판별
		 *  - 소수이면 Set에 저장
		 * 4. set size() 값 리턴
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
