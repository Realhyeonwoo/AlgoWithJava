package programmers.level2;

import java.util.*;

public class 뉴스클러스트링 {

	static final int VALUE = 65536;

	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		int num = solution(str1, str2);
		System.out.println(num);
	}

	public static int solution(String str1, String str2) {
		int answer = 1 * VALUE;

		// String�쓣 臾몄젣 洹쒖튃�뿉 �뵲�씪 吏묓빀�쑝濡� 留뚮뱾湲�
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		makeSet(str1, list1);
		makeSet(str2, list2);

		// �몮�떎 怨듭쭛�빀�씤 寃쎌슦 珥덇린媛믪쑝濡� 由ы꽩
		if (list1.size() == 0 && list2.size() == 0)
			return answer;

		// 援먯쭛�빀 媛��닔 援ы븯湲�
		double num1 = makeintersection(list1, list2);
		// �빀吏묓빀 媛��닔 援ы븯湲�
		double num2 = makeUnion(list1, list2);

		// 寃곌낵媛� �뿰�궛�븯�뿬 由ы꽩
		answer = (int) ((num1 / num2) * VALUE);
		return answer;
	}

	private static double makeintersection(ArrayList<String> list1, ArrayList<String> list2) {
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for (String s : list1) {
			if (map1.containsKey(s)) {
				int cnt = map1.get(s) + 1;
				map1.put(s, cnt);
			} else {
				map1.put(s, 1);
			}
		}

		for (String s : list2) {
			if (map2.containsKey(s)) {
				int cnt = map2.get(s) + 1;
				map2.put(s, cnt);
			} else {
				map2.put(s, 1);
			}
		}

		for (String s : map1.keySet()) {
			if (map2.containsKey(s)) {
				map1.put(s, Math.min(map1.get(s), map2.get(s)));
			} else {
				map1.put(s, 0);
			}
		}

		double cnt = 0.0;
		for (String s : map1.keySet()) {
			cnt += map1.get(s);
		}

		return cnt;
	}

	private static double makeUnion(ArrayList<String> list1, ArrayList<String> list2) {
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for (String s : list1) {
			if (map1.containsKey(s)) {
				int cnt = map1.get(s) + 1;
				map1.put(s, cnt);
			} else {
				map1.put(s, 1);
			}
		}

		for (String s : list2) {
			if (map2.containsKey(s)) {
				int cnt = map2.get(s) + 1;
				map2.put(s, cnt);
			} else {
				map2.put(s, 1);
			}
		}

		for (String s : map2.keySet()) {
			if (map1.containsKey(s)) {
				map1.put(s, Math.max(map1.get(s), map2.get(s)));
			} else {
				map1.put(s, map2.get(s));
			}
		}

		double cnt = 0.0;
		for (String s : map1.keySet()) {
			cnt += map1.get(s);
		}

		return cnt;
	}

	private static void makeSet(String str, ArrayList<String> list) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (checkString(i, str)) {
				String s = str.substring(i, i + 2);
				list.add(s.toUpperCase());
			}
		}
	}

	private static boolean checkString(int index, String str) {
		String value = str.substring(index, index + 2);

		for (int i = 0; i < value.length(); i++) {
			if (String.valueOf(value.charAt(i)).matches("[^a-zA-Z0-9]"))
				return false;
			if (Character.isDigit(value.charAt(i)))
				return false;
		}
		return true;
	}
}
