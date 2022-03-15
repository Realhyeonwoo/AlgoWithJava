package SKICT;

public class solve02 {
	public static void main(String[] args) {
		int n = 5;
		boolean clockwise = true;

		int[][] answer = solution(n, clockwise);
	}

	private static int[][] solution(int n, boolean clockwise) {
		int[][] answer = new int[n][n];

		// 배열 회전 횟수
		int size = (n % 2 == 0) ? (n - 1) / 2 : n / 2;
		int[] gapValue = new int[size];
		for (int i = 0; i < size; i++) {
			gapValue[i] = i + 1;
		}
		
		
		
		
		
		//시계 방향
		if(clockwise) {
			// (0, 0)
			int[] dy = {0, 1, 0, -1};
			int[] dx = {1, 0, -1, 0};
			int num = 1;
			int curY = 0;
			int curX = -1;
			int dis = n-1;
			for(int dir=0; dir<4; dir++) {
				for(int i=0; i<dis; i++) {
					curY += dy[dir];
					curX += dx[dir];
					answer[curY][curX] = num++;
				}
				
				dis -= 2;
			}
			answer[curY][curX-1] = num;
			
			//(0, n-1)
			
			
			
			
			//(n-1, 0)
			
			
			
			
			
			//(n-1, n-1)
			System.out.println("========");
			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < answer[i].length; j++) {
					System.out.print(answer[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("========");
		} else {
		//반시계 방
			
		}
		
		
		return answer;
	}
}
