import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int y, x;
	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class boj2580 {
	
	static int[][] arr = new int[9][9];
	static ArrayList<Pos> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) {
					list.add(new Pos(i, j));
				}
			}
		}
		backTracking(0);
	}

	private static void backTracking(int depth) {
		if(depth == list.size()) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		Pos p = list.get(depth);
		int y = p.y;
		int x = p.x;
		
		for(int i=1; i<=9; i++) {
			if(!isPossible(y, x, i)) continue;
			
			arr[y][x] = i;
			backTracking(depth + 1);
			arr[y][x] = 0;
		}
	}

	private static boolean isPossible(int y, int x, int num) {
		
		//check Row
		for(int i=0; i<9; i++) {
			if(num == arr[y][i]) return false;
		}
		
		//check Vertical
		for(int i=0; i<9; i++) {
			if(num == arr[i][x]) return false;
		}
		
		
		//check Square
		int row = y/3 * 3;
		int col = x/3 * 3;
		for(int i=row; i<row+3; i++) {
			for(int j=col; j<col+3; j++) {
				if(num == arr[i][j]) return false;
			}
		}
		
		return true;
	}
}
