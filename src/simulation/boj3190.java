package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj3190 {
	static class Bam {
		int y, x, len, dir;
		Bam(int y, int x, int len, int dir) {
			this.y = y;
			this.x = x;
			this.len = len;
			this.dir = dir;
		}
	}
	
	static int N;
	static int[][] arr;
	static Bam bam;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
		}
		int L = Integer.parseInt(br.readLine());
		for(int l=0; l<L; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			int y = 0, x = 0, len = 1;
			bam = new Bam(y, x, len, 1);
			
			boolean isEnd = false;
			while(time > 0) {
				ans++;
				time--;
				
				switch(bam.dir) {
				case 0:
					if(bam.y - bam.len > 0) isEnd = true;
					else {
						for(int i=1; i<=len; i++) {
							int ny = bam.y - 1;
						}
					}
					break;
				case 1:
					if(bam.x + bam.len <= N) isEnd = true;
					else {
						
					}
					break;
				case 2:
					if(bam.y + bam.len <= N) isEnd = true;
					else {
						
					}
					break;
				case 3:
					if(bam.x - bam.len > 0) isEnd = true;
					else {
						
					}
					break;
					default:
				}
				
				if(isEnd) {
					System.out.println(ans);
					System.exit(0);
				}
			}
			
			// 방향 틀기
			int newDir = 0;
			switch(bam.dir) {
			case 0:
				newDir = (dir == 'D') ? 1 : 3;
				break;
			case 1:
				newDir = (dir == 'D') ? 2 : 0;
				break;
			case 2:
				newDir = (dir == 'D') ? 3 : 1;
				break;
			case 3:
				newDir = (dir == 'D') ? 0 : 2;
				break;
				default:
			}
			bam = new Bam(y, x, len, newDir);
		}
		
		System.out.println(ans);
	}
}
