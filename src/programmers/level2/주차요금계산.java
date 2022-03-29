package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 주차요금계산 {

	static final String END_TIME = "23:59";

	static class Car implements Comparable<Car> {
		String number;
		int fee;

		Car(String number, int fee) {
			this.number = number;
			this.fee = fee;
		}

		public int compareTo(Car c) {
			return Integer.parseInt(number) - Integer.parseInt(c.number);
		}
	}

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		
		int[] answer = solution(fees, records);
		
		for(int f : answer)
			System.out.println(f);
	}

	public static int[] solution(int[] fees, String[] records) {
		// 李⑤웾蹂� �떆媛� ���옣 MAP<李⑤웾踰덊샇, 李⑤웾�떆媛�>
		Map<String, Integer> carTimeRecord = new HashMap<>();
		// 二쇱감�옣MAP <李⑤웾踰덊샇 : �엯李⑥떆媛�>
		Map<String, String> parkRecord = new HashMap<>();
		// record �닚�쉶�븯�뿬 李⑤웾 �떆媛� 怨꾩궛
		for (String str : records) {
			// �젙蹂� �뙆�떛
			String[] info = str.split(" ");
			String time = info[0];
			String number = info[1];
			String status = info[2];
			// IN : 二쇱감�옣 MAP ���옣
			if (status.equals("IN")) {
				parkRecord.put(number, time);
				// OUT : 二쇱감�옣 MAP 異쒓퀬
			} else if (status.equals("OUT")) {
				int t = calcTime(parkRecord.get(number), time);
				// �쟾�뿉 遺�愿��맂 �슂湲덉씠 �엳�뒗吏� �솗�씤 �븘�슂
				if (carTimeRecord.containsKey(number)) {
					int preTime = carTimeRecord.get(number);
					t += preTime;
				}
				carTimeRecord.put(number, t);
				parkRecord.remove(number);
			}
		}
		// parkRecord�뿉 �궓�븘�엳�뒗 李⑤웾 �떆媛� �젙�궛
		for (String number : parkRecord.keySet()) {
			int time = calcTime(parkRecord.get(number), END_TIME);
			if (carTimeRecord.containsKey(number)) {
				int preTime = carTimeRecord.get(number);
				time += preTime;
			}
			carTimeRecord.put(number, time);
		}
		// �슂湲� 怨꾩궛 �븯�뿬 Car List�뿉 ���옣 諛� �젙�젹
		ArrayList<Car> list = new ArrayList<>();
		for (String number : carTimeRecord.keySet()) {
			int fee = (int) calcFee(carTimeRecord.get(number), fees);
			list.add(new Car(number, fee));
		}
		Collections.sort(list);
		// 李⑤웾蹂� �슂湲� 諛곗뿴�뿉 ���옣
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i).fee;
		return answer;
	}

	private static int calcTime(String start, String end) {
		String[] st1 = start.split(":");
		String[] st2 = end.split(":");
		int startHour = Integer.parseInt(st1[0]);
		int startMinute = Integer.parseInt(st1[1]) + startHour * 60;
		int endHour = Integer.parseInt(st2[0]);
		int endMinute = Integer.parseInt(st2[1]) + endHour * 60;

		return endMinute - startMinute;
	}

	private static double calcFee(int time, int[] fees) {
		if (time <= fees[0]) {
			// System.out.println(fees[1]);
			return fees[1];
		} else {
			return fees[1] + Math.ceil(((time - fees[0]) / (double) fees[2])) * fees[3];
		}

	}
}
