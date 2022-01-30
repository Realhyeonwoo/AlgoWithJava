package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj18808 {
	static int N, M, K;
	static int[][] arr;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// INPUT
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		// 스티커 1개씩 입력하여 배치
		for (int k = 0; k < K; k++) {
//			System.out.println("K : " + k);
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] sticker;
			int[][] tempSticker;
			
			// 0도
			sticker = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(isPutSticker(sticker, R, C)) continue;
			
			// 90도
			tempSticker = new int[C][R];
			for(int y=0; y<R; y++) {
				for(int x=0; x<C; x++) {
					tempSticker[x][R-1-y] = sticker[y][x];
				}
			}
			if(isPutSticker(tempSticker, C, R)) continue;
			
			// 180도
			sticker = new int[R][C];
			for(int y=0; y<C; y++) {
				for(int x=0; x<R; x++) {
					sticker[x][C-1-y] = tempSticker[y][x];
				}
			}
			if(isPutSticker(sticker, R, C)) continue;
			// 270도
			tempSticker = new int[C][R];
			for(int y=0; y<R; y++) {
				for(int x=0; x<C; x++) {
					tempSticker[x][R-1-y] = sticker[y][x];
				}
			}
			if(isPutSticker(tempSticker, C, R)) continue;
		}
		
//		System.out.println("RESULT");
//		for (int y = 0; y < N; y++) {
//			for (int x = 0; x < M; x++) {
//			System.out.print(arr[y][x] + " ");
//			}
//			System.out.println();
//		}
		// OUTPUT
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (arr[y][x] == 1)
					ans++;
			}
		}
		System.out.println(ans);

	}

	private static boolean isPutSticker(int[][] sticker, int r, int c) {
		int[][] cloneArr = new int[N][M];
		for (int i = 0; i < N; i++)
			cloneArr[i] = arr[i].clone();
		
		for (int i = 0; i < N-r+1; i++) {
			for (int j = 0; j < M-c+1; j++) {
				// sticker 맞춰보기
				boolean isFail = false;
				for (int y = i; y < i+r; y++) {
					for (int x = j; x < j+c; x++) {
						if (cloneArr[y][x] == 1 && sticker[y - i][x - j] == 1) {
							isFail = true;
							break;
						}
						if (cloneArr[y][x] == 0 && sticker[y - i][x - j] == 1) {
							cloneArr[y][x] = sticker[y - i][x - j];
						}
					}
					if(isFail) break;
				}
				// 성공여부 체크
				if(!isFail) {
					for (int t = 0; t < N; t++)
						arr[t] = cloneArr[t].clone();
					return true;
				} else {
					for (int t = 0; t < N; t++)
						cloneArr[t] = arr[t].clone();
				}
			}
		}
		return false;
	}

}
