package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13335 {
	static class Car {
		int weight, dist;

		Car(int weight, int dist) {
			this.weight = weight;
			this.dist = dist;
		}
	}

	static int N, W, L;
	static ArrayList<Car> cars = new ArrayList<>();
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			cars.add(new Car(Integer.parseInt(st.nextToken()), W));

		int idx = 0;
		Queue<Car> q = new LinkedList<>();
		q.add(cars.get(idx++));
		time = 1;
		while (true) {
			time++;
			int qSize = q.size();
			int nowWeight = 0;
			for (int i = 0; i < qSize; i++) {
				Car c = q.poll();
				int w = c.weight;
				int d = c.dist - 1;

				if (d != 0) {
					q.add(new Car(w, d));
					nowWeight += w;
				}
			}
			if (idx == N && q.isEmpty())
				break;

			if (idx != N) {
				nowWeight += cars.get(idx).weight;
				if (nowWeight <= L) {
					q.add(cars.get(idx));
					idx++;
				}
			}
		}

		System.out.println(time);
	}
}
