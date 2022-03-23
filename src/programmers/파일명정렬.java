package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 파일명정렬 {
	static class File implements Comparable<File> {
		int index;
		String head;
		String number;
		String tail;

		File(int index, String head, String number, String tail) {
			this.index = index;
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		public int compareTo(File f) {
			if (this.head.toLowerCase().compareTo(f.head.toLowerCase()) == 0
					&& (!this.number.equals("") && !f.number.equals(""))) {
				int compareNumber = Integer.compare(Integer.parseInt(this.number), Integer.parseInt(f.number));
				if (compareNumber == 0) {
					return Integer.compare(this.index, f.index);
				} else {
					return compareNumber;
				}
			} else {
				return this.head.toLowerCase().compareTo(f.head.toLowerCase());
			}
		}
	}

	public static void main(String[] args) {
		String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };

		String[] answer = solution(files);

	}

	public static String[] solution(String[] files) {
		ArrayList<File> list = new ArrayList<>();

		for (int idx = 0; idx < files.length; idx++) {
			String file = files[idx];

			int headLastIdx = getHeadLastIdx(file);
			int numberLastIdx = getNumberLastIdx(headLastIdx + 1, file);

			String head = file.substring(0, headLastIdx + 1);
			String number = file.substring(headLastIdx + 1, numberLastIdx + 1);
			String tail = file.substring(numberLastIdx + 1);

			list.add(new File(idx, head, number, tail));
		}

		Collections.sort(list);

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			File f = list.get(i);
			answer[i] = f.head + f.number + f.tail;
		}

		return answer;
	}

	private static int getHeadLastIdx(String file) {
		char[] arr = file.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i]))
				return i - 1;
		}
		return -1;
	}

	private static int getNumberLastIdx(int startIdx, String file) {
		char[] arr = file.toCharArray();

		for (int i = startIdx; i < arr.length; i++) {
			if (!Character.isDigit(arr[i]))
				return i - 1;
		}
		return arr.length - 1;

	}
}
