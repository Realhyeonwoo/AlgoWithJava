package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj14891 {
	static int[][] gears = new int[4][8];
	static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) { // 1:시계방향, -1:반시계방향, 0:N극, 1:S극
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			
			switch(num) {
			case 0:
				if(gears[0][2] != gears[1][6]) {
					if(dir == 1) {
						if(gears[1][2] != gears[2][6]) {
							if(gears[2][2] != gears[3][6]) {
								moveReverseClockDirection(3);
							}
							moveClockDirection(2);
						}
						moveReverseClockDirection(1);
					} else if(dir == -1) {
						if(gears[1][2] != gears[2][6]) {
							if(gears[2][2] != gears[3][6]) {
								moveClockDirection(3);
							}
							moveReverseClockDirection(2);
						}
						moveClockDirection(1);
					}
				}
				if(dir == 1) {
					moveClockDirection(0);
					 
				} else {
					moveReverseClockDirection(0);
					
				}
				break;
			case 1:
				if(gears[1][2] != gears[2][6]) {
					if(dir == 1) {
						if(gears[2][2] != gears[3][6]) {
							moveClockDirection(3);
						}
						moveReverseClockDirection(2);
					} else if(dir == -1) {
						if(gears[2][2] != gears[3][6]) {
							moveReverseClockDirection(3);
						}
						moveClockDirection(2);
					}
				}
				if(gears[1][6] != gears[0][2]) {
					if(dir == 1) {
						moveReverseClockDirection(0);
					} else if(dir == -1) {
						moveClockDirection(0);
					}
				}
				if(dir == 1) {
					moveClockDirection(1);
					
				} else {
					moveReverseClockDirection(1);
				}
				break;
			case 2:
				if(gears[2][2] != gears[3][6]) {
					if(dir == 1) {
						moveReverseClockDirection(3);
					} else if(dir == -1) {
						moveClockDirection(3);
					}
				}
				
				if(gears[2][6] != gears[1][2]) {
					if(dir == 1) {
						if(gears[1][6] != gears[0][2]) {
							moveClockDirection(0);
						}
						moveReverseClockDirection(1);
					} else if(dir == -1) {
						if(gears[1][6] != gears[0][2]) {
							moveReverseClockDirection(0);
						}
						moveClockDirection(1);
					}
				}
				if(dir == 1) {
					moveClockDirection(2);
					
				} else {
					moveReverseClockDirection(2);
				}
				break;
			case 3:
				if(gears[3][6] != gears[2][2]) {
					if(dir == 1) {
						if(gears[2][6] != gears[1][2]) {
							if(gears[1][6] != gears[0][2]) {
								moveReverseClockDirection(0);
							}
							moveClockDirection(1);
						}
						moveReverseClockDirection(2);
					} else if(dir == -1) {
						if(gears[2][6] != gears[1][2]) {
							if(gears[1][6] != gears[0][2]) {
								moveClockDirection(0);
							}
							moveReverseClockDirection(1);
						}
						moveClockDirection(2);
					}
				}
				if(dir == 1) {
					moveClockDirection(3);
					
				} else {
					moveReverseClockDirection(3);
					
				}
				break;
				default:
			}
//			System.out.println("#" + k + " dir : " + dir);
//			for(int i=0; i<4; i++) {
//				for(int j=0; j<8; j++) {
//					if(j == 2 || j==6)
//						System.out.print("["+gears[i][j]+"]" + " ");
//					else
//						System.out.print(gears[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		int sum = 0;
		if(gears[0][0] == 1) sum += 1;
		if(gears[1][0] == 1) sum += 2;
		if(gears[2][0] == 1) sum += 4;
		if(gears[3][0] == 1) sum += 8;
		
		System.out.println(sum);
	}
	public static void moveClockDirection(int num) {
		int[] tempArr = new int[8];
		for(int i=0; i<7; i++)
			tempArr[i+1] = gears[num][i];
		tempArr[0] = gears[num][7];
		for(int i=0; i<8; i++)
			gears[num][i] = tempArr[i];
	}
	public static void moveReverseClockDirection(int num) {
		int[] tempArr = new int[8];
		for(int i=0; i<7; i++)
			tempArr[i] = gears[num][i+1];
		tempArr[7] = gears[num][0];
		for(int i=0; i<8; i++)
			gears[num][i] = tempArr[i];
	}
}
