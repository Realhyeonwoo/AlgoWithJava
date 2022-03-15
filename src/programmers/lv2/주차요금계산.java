package programmers.lv2;

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
		// 차량별 시간 저장 MAP<차량번호, 차량시간>
		Map<String, Integer> carTimeRecord = new HashMap<>();
		// 주차장MAP <차량번호 : 입차시간>
		Map<String, String> parkRecord = new HashMap<>();
		// record 순회하여 차량 시간 계산
		for (String str : records) {
			// 정보 파싱
			String[] info = str.split(" ");
			String time = info[0];
			String number = info[1];
			String status = info[2];
			// IN : 주차장 MAP 저장
			if (status.equals("IN")) {
				parkRecord.put(number, time);
				// OUT : 주차장 MAP 출고
			} else if (status.equals("OUT")) {
				int t = calcTime(parkRecord.get(number), time);
				// 전에 부관된 요금이 있는지 확인 필요
				if (carTimeRecord.containsKey(number)) {
					int preTime = carTimeRecord.get(number);
					t += preTime;
				}
				carTimeRecord.put(number, t);
				parkRecord.remove(number);
			}
		}
		// parkRecord에 남아있는 차량 시간 정산
		for (String number : parkRecord.keySet()) {
			int time = calcTime(parkRecord.get(number), END_TIME);
			if (carTimeRecord.containsKey(number)) {
				int preTime = carTimeRecord.get(number);
				time += preTime;
			}
			carTimeRecord.put(number, time);
		}
		// 요금 계산 하여 Car List에 저장 및 정렬
		ArrayList<Car> list = new ArrayList<>();
		for (String number : carTimeRecord.keySet()) {
			int fee = (int) calcFee(carTimeRecord.get(number), fees);
			list.add(new Car(number, fee));
		}
		Collections.sort(list);
		// 차량별 요금 배열에 저장
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
