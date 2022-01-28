package backTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj1941 {
	static class Pos {
		int y, x;
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int SIZE = 5;
	static char[][] arr;
	static ArrayList<Pos> list = new ArrayList<>();
	static ArrayList<Pos> pickedList= new ArrayList<>();
	static boolean[] visited = new boolean[SIZE*SIZE];
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		arr = new char[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			String str = br.readLine();
			for(int j=0; j<SIZE; j++) {
				arr[i][j] = str.charAt(j);
				list.add(new Pos(i, j));
			}
		}
		
		backTracking(0, 0);
		
		System.out.println(ans);
	}
	private static void backTracking(int depth, int start) {
		if(depth == 7) {
			int[][] tempArr = new int[SIZE][SIZE];
			boolean[][] isUsed = new boolean[SIZE][SIZE];
			// 이다솜파 4명 이상인지 확인
			int cnt = 0;
			for(Pos p : pickedList) {
				tempArr[p.y][p.x] = 1;
				if(arr[p.y][p.x] == 'S') cnt++;
			}
			if(cnt < 4) return;
			
			// 연결성 확인
			int[] dy = {0, 0, 1, -1};
			int[] dx = {1, -1, 0, 0};
			
			Queue<Pos> q = new LinkedList<>();
			q.add(pickedList.get(0));
			isUsed[pickedList.get(0).y][pickedList.get(0).x] = true;
			while(!q.isEmpty()) {
				Pos p = q.poll();
				int y = p.y;
				int x = p.x;
				for(int dir=0; dir<4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					
					if(ny<0 || ny>=SIZE || nx<0 || nx>=SIZE) continue;
					if(isUsed[ny][nx] || tempArr[ny][nx] == 0) continue;
					isUsed[ny][nx] = true;
					q.add(new Pos(ny, nx));
				}
			}
			for(Pos p : pickedList) {
				if(!isUsed[p.y][p.x]) {
					return;
				}
			}
			
			ans++;
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			pickedList.add(list.get(i));
			backTracking(depth+1, i);
			visited[i] = false;
			pickedList.remove(pickedList.size()-1);
		}
	}
}
