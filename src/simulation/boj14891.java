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
			
			int[] tempArr = new int[8];
			switch(num) {
			case 0:
				if(gears[0][2] != gears[1][6]) {
					if(dir == 1) {
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[0][i];
						tempArr[0] = gears[0][7];
						for(int i=0; i<8; i++)
							gears[0][i] = tempArr[i];
						
						for(int i=0; i<7; i++)
							tempArr[i] = gears[1][i+1];
						tempArr[7] = gears[1][0];
						for(int i=0; i<8; i++)
							gears[1][i] = tempArr[i];
						
					} else if(dir == -1) {
						for(int i=0; i<7; i++)
							tempArr[i] = gears[0][i+1];
						tempArr[7] = gears[0][0];
						for(int i=0; i<8; i++)
							gears[0][i] = tempArr[i];
						
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[1][i];
						tempArr[0] = gears[1][7];
						for(int i=0; i<8; i++)
							gears[1][i] = tempArr[i];
					}
				}
				break;
			case 1:
				tempArr = new int[8];
				if(gears[1][2] != gears[2][6]) {
					if(dir == 1) {
						for(int i=0; i<7; i++)
							tempArr[i] = gears[2][i+1];
						tempArr[7] = gears[2][0];
						for(int i=0; i<8; i++)
							gears[2][i] = tempArr[i];
					} else if(dir == -1) {
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[2][i];
						tempArr[0] = gears[2][7];
						for(int i=0; i<8; i++)
							gears[2][i] = tempArr[i];
					}
				}
				
				if(gears[1][6] != gears[0][2]) {
					if(dir == 1) {
						for(int i=0; i<7; i++)
							tempArr[i] = gears[0][i+1];
						tempArr[7] = gears[0][0];
						for(int i=0; i<8; i++)
							gears[0][i] = tempArr[i];
					} else if(dir == -1) {
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[0][i];
						tempArr[0] = gears[0][7];
						for(int i=0; i<8; i++)
							gears[0][i] = tempArr[i];
					}
				}
				
				if(dir == 1) {
					for(int i=0; i<7; i++)
						tempArr[i+1] = gears[1][i];
					tempArr[0] = gears[1][7];
					for(int i=0; i<8; i++)
						gears[1][i] = tempArr[i];
				} else if(dir == -1) {
					for(int i=0; i<7; i++)
						tempArr[i] = gears[1][i+1];
					tempArr[7] = gears[1][0];
					for(int i=0; i<8; i++)
						gears[1][i] = tempArr[i];
				}
				break;
			case 2:
				tempArr = new int[8];
				
				if(gears[2][2] != gears[3][6]) {
					if(dir == 1) {
						for(int i=0; i<7; i++)
							tempArr[i] = gears[3][i+1];
						tempArr[7] = gears[3][0];
						for(int i=0; i<8; i++)
							gears[3][i] = tempArr[i];
					} else if(dir == -1) {
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[3][i];
						tempArr[0] = gears[3][7];
						for(int i=0; i<8; i++)
							gears[3][i] = tempArr[i];
					}
				}
				
				if(gears[2][6] != gears[1][2]) {
					if(dir == 1) {
						for(int i=0; i<7; i++)
							tempArr[i] = gears[1][i+1];
						tempArr[7] = gears[1][0];
						for(int i=0; i<8; i++)
							gears[1][i] = tempArr[i];
					} else if(dir == -1) {
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[1][i];
						tempArr[0] = gears[1][7];
						for(int i=0; i<8; i++)
							gears[1][i] = tempArr[i];
					}
				}
			
				if(dir == 1) {
					for(int i=0; i<7; i++)
						tempArr[i+1] = gears[2][i];
					tempArr[0] = gears[2][7];
					for(int i=0; i<8; i++)
						gears[2][i] = tempArr[i];
				} else if(dir == -1) {
					for(int i=0; i<7; i++)
						tempArr[i] = gears[2][i+1];
					tempArr[7] = gears[2][0];
					for(int i=0; i<8; i++)
						gears[2][i] = tempArr[i];
				}
				break;
			case 3:
				tempArr = new int[8];
				if(gears[3][6] != gears[2][2]) {
					if(dir == 1) {
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[3][i];
						tempArr[0] = gears[3][7];
						for(int i=0; i<8; i++)
							gears[3][i] = tempArr[i];
						
						for(int i=0; i<7; i++)
							tempArr[i] = gears[2][i+1];
						tempArr[7] = gears[2][0];
						for(int i=0; i<8; i++)
							gears[2][i] = tempArr[i];
					} else if(dir == -1) {
						for(int i=0; i<7; i++)
							tempArr[i] = gears[3][i+1];
						tempArr[7] = gears[3][0];
						for(int i=0; i<8; i++)
							gears[3][i] = tempArr[i];
						
						for(int i=0; i<7; i++)
							tempArr[i+1] = gears[2][i];
						tempArr[0] = gears[2][7];
						for(int i=0; i<8; i++)
							gears[2][i] = tempArr[i];
					}
				}
				break;
				default:
			}
		}
		
		int sum = 0;
		if(gears[0][0] == 1) sum += 1;
		if(gears[1][0] == 1) sum += 2;
		if(gears[2][0] == 1) sum += 4;
		if(gears[3][0] == 1) sum += 8;
		
		System.out.println(sum);
	}
}
