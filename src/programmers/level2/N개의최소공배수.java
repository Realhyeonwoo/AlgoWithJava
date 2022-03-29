package programmers.level2;

public class N개의최소공배수 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 4}));
	}

	public static int solution(int[] arr) {
		int answer = 0;

		// 媛��옣 �겙 �닔 李얘린
		for (int num : arr)
			answer = Math.max(answer, num);
		// 理쒖냼怨듬같�닔 李얘린
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
