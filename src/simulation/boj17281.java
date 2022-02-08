package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17281 {
	static int N;
	static int[][] arr;
	static boolean[] isPicked  = new boolean[10];
	static int[] player  = new int[10];
	static int[] temp  = new int[10];
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][10]; // 1~N 이닝, 1~9번 선수
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backTracking(1);
		
		System.out.println(ans);
	}
	
	private static void backTracking(int depth) {
		if(depth == 9) {
			for(int i=1; i<4; i++) {
				player[i] = temp[i];
			}
			player[4] = 1;
			for(int i=5; i<10; i++) {
				player[i] = temp[i];
			}
			
//			if(player[4] != 1) return;
			
			int score = 0;
			int idx = 1;
			for(int n=1; n<=N; n++) { // 이닝
				int outCnt = 0;
				int[] ground = new int[4]; // 0, 1, 2, 3
				while(outCnt < 3) {
					switch(arr[n][player[idx]]) {
					case 0:
						outCnt++;
						break;
					case 1:
						if(ground[3] == 1) {
							ground[3] = 0;
							score++;
						}
						for(int i=2; i>0; i--) {
							if(ground[i] == 1) {
								ground[i] = 0;
								ground[i+1] = 1;
							}
						}
						ground[1] = 1;
						break;
					case 2:
						for(int i=3; i>1; i--) {
							if(ground[i] == 1) {
								score++;
								ground[i] = 0;
							}
						}
						if(ground[1] == 1) {
							ground[1] = 0;
							ground[3] = 1;
						}
						ground[2] = 1;
						break;
					case 3:
						for(int i=3; i>0; i--) {
							if(ground[i] == 1) {
								score++;
								ground[i] = 0;
							}
							ground[3] = 1;
						}
						break;
					case 4:
						for(int i=1; i<4; i++) { // 필드 선수
							if(ground[i] == 1) {
								score++;
								ground[i] = 0;
							}
						}
						score++; // 홈런 친 선수 
						break;
					}
					idx++;
					if(idx == 10) idx = 1;
				}
				
			}
			ans = Math.max(ans, score);
			return;
		}
		
		for(int i=2; i<=9; i++) {
			if(isPicked[i]) continue;
			isPicked[i] = true;
			temp[depth] = i;
			backTracking(depth + 1);
			isPicked[i] = false;
		}
		
	}
}
