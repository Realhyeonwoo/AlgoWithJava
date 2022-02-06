import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class study {
	public static void main(String[] args) {
		int[][] test = {{1}, {1}, {1,1}};
		for(int i=0; i<test.length; i++) {
			for(int j=0; j<test[i].length; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}
		int[][] temp = new int[test.length][];
		for(int y=0; y<test.length; y++) {
			temp[y] = new int[test[y].length];
		}
		for(int y=0; y<test.length; y++) {
			for(int x=0; x<test[y].length; x++) {
				temp[x][test.length-y-1] = test[y][x];
		
			}
		}
		System.out.println();
		for(int y=0; y<temp.length; y++) {
			for(int x=0; x<temp[y].length; x++) {
				System.out.print(temp[y][x] + " ");
			}
			System.out.println();
		}
	}
}