package programmers.lv2;

public class N개의최소공배수 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 4}));
	}

	public static int solution(int[] arr) {
		int answer = 0;

		// 가장 큰 수 찾기
		for (int num : arr)
			answer = Math.max(answer, num);
		// 최소공배수 찾기
		int idx = 1;
		while (true) {
			int num = answer * idx;

			boolean isDone = true;
			for (int i = 0; i < arr.length; i++) {
				if (num % arr[i] != 0) {
					isDone = false;
					break;
				}
			}
			idx++;
			if (isDone) {
				answer = num;
				break;
			}
		}
		return answer;
	}
}
