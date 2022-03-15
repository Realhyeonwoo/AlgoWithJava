package SKICT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class solve01 {
	
	static class coinInfo {
		
		public int coin;
		public int price;
		public double onePrice;
		
		public coinInfo(int coin, int price, double onePrice) {
			this.coin = coin;
			this.price = price;
			this.onePrice = onePrice;
		}
	}
	
	public static void main(String[] args) {
		
//		 int money = 4578;
//		 int[] costs = {1, 4, 99, 35, 50, 1000};
		 
		 int money = 1999;
		 int[] costs = {2, 11, 20, 100, 200, 600};
		
		int answer = solution(money, costs);
		
		System.out.println(answer);
	}

	private static int solution(int money, int[] costs) {

		// 각 금액이 1원 만들때 드는 비용 정 오름차순으로 정렬
		int[] m = {1, 5, 10, 50, 100, 500};
		ArrayList<coinInfo> list = new ArrayList<coinInfo>();
		for(int i=0; i<m.length; i++)
			list.add(new coinInfo(m[i], costs[i], (double)costs[i] / m[i]));
		
		Collections.sort(list, new Comparator<coinInfo>() {

			@Override
			public int compare(coinInfo o1, coinInfo o2) {
				if(o1.onePrice == o2.onePrice) {
					return o1.coin - o2.coin;
				} else if(o1.onePrice < o2.onePrice){
					return -1; 
				} else {
					return 1;
				}
			}
		});
		
		for(coinInfo c : list) 
			System.out.println(c.coin + " " + c.onePrice + " " + c.price);
		
		
		// money가 0이 될때까지 1원비용 적은거로 나누기
		int answer = 0;
		int idx = 0;
		while(money != 0) {
			coinInfo ci = list.get(idx++);
			answer += (money / ci.coin) * ci.price;
			money %= ci.coin;
		}
		
		return answer;
	}
	
}
