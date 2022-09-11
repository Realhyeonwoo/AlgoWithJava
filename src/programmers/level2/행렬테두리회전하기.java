package programmers.level2;

public class 행렬테두리회전하기 {
	public static void main(String[] args) {
		int row = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}}; 
		
		int[] arr = solution(row, columns, queries);
		
		for(int v : arr)
			System.out.print(v + " ");
	}

	private static int[] solution(int rows, int columns, int[][] queries) {

		// init
		int[][] arr = new int[rows + 1][columns + 1];
		int[][] tempArr = new int[rows + 1][columns + 1];
		int num = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				arr[i][j] = num;
				tempArr[i][j] = num++;
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			answer[i] = doRotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3], arr, tempArr);
		}

		return answer;
	}

	private static int doRotate(int x1, int y1, int x2, int y2, int[][] arr, int[][] tempArr) {
		int minValue = Integer.MAX_VALUE;
		// System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
		// rotate(arr > tempArr)
		for (int i = y1; i < y2; i++) {
			tempArr[x1][i + 1] = arr[x1][i];
			minValue = Math.min(minValue, arr[x1][i]);
		}
		for (int i = x1; i < x2; i++) {
			tempArr[i + 1][y2] = arr[i][y2];
			minValue = Math.min(minValue, arr[i][y2]);
		}
		for (int i = y2; i > y1; i--) {
			tempArr[x2][i - 1] = arr[x2][i];
			minValue = Math.min(minValue, arr[x2][i]);
		}
		for (int i = x2; i > x1; i--) {
			tempArr[i - 1][y1] = arr[i][y1];
			minValue = Math.min(minValue, arr[i][y1]);
		}

		// clone(tempArr > arr)
		for (int i = 0; i < arr.length; i++)
			arr[i] = tempArr[i].clone();

		return minValue;
	}

}
