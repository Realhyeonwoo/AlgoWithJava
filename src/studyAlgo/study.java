package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class study {

	public static void main(String[] args) throws Exception {
		String str = solution("3people unFollowed me");
		System.out.println(str);
		str = solution("for the last week");
		System.out.println(str);
//		str = solution("3ab   ab");
//		System.out.println(str);
		
		String a = "3ab   ab";
		a = a.replaceFirst(a.charAt(0) + "", Character.toUpperCase(a.charAt(0)) + "");
	}

	public static String solution(String s) {
		String answer = "";
		// 공백(" ")으로 분리
		String[] strArr = s.split(" ");
		// 첫 문자가 숫자일 때
		if (Character.isDigit(strArr[0].charAt(0))) {
			answer += strArr[0].toLowerCase() + " ";
			for (int i = 1; i < strArr.length; i++) {
				if (strArr[i] == " ") {
					answer += " ";
					continue;
				}
				strArr[i] = strArr[i].toLowerCase();
				strArr[i] = strArr[i].replaceFirst(strArr[i].charAt(0) + "", Character.toUpperCase(strArr[i].charAt(0)) + "");

				answer += strArr[i] + " ";
			}
			// 첫 문자가 숫자가 아닐 때
		} else {
			for (int i = 0; i < strArr.length; i++) {
				if (strArr[i] == " ") {
					answer += " ";
					continue;
				}
				strArr[i] = strArr[i].toLowerCase();
				strArr[i] = strArr[i].replaceFirst(strArr[i].charAt(0) + "",
						Character.toUpperCase(strArr[i].charAt(0)) + "");
				answer += strArr[i] + " ";
			}
		}

		answer = answer.substring(0, answer.length() - 1);
		return answer;
	}
}