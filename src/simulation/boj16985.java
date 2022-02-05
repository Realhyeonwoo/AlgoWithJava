package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16985 {
	static class Pos {
		int h, y, x;
		Pos(int h, int y, int x) {
			this.h = h;
			this.y = y;
			this.x = x;
		}
	}
	
	static final int SIZE = 5;
	static int[][][] arr = new int[SIZE][SIZE][SIZE];
	static ArrayList<Integer> list = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// INPUT
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<SIZE; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 돌리기
		dfs(0);
		
		// OUTPUT(탈출불가 : -1)
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void dfs(int depth) {
		if(depth == SIZE) {
			int[][][] cloneMap = new int[SIZE][SIZE][SIZE];
			for(int h=0; h<SIZE; h++) {
				for(int y=0; y<SIZE; y++) {
					for(int x=0; x<SIZE; x++) {
						cloneMap[h][y][x] = arr[h][y][x];
					}
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				// d: 0, 1, 2, 3
				int[][] tempArr = new int[SIZE][SIZE];
				for(int y=0; y<SIZE; y++) {
					for(int x=0; x<SIZE; x++) {
						tempArr[y][x] = arr[i][y][x];
					}
				}
				for(int d=0; d<list.get(i); d++) {
					for(int y=0; y<SIZE; y++) {
						for(int x=0; x<SIZE; x++) {
							cloneMap[i][x][5-y-1] = tempArr[y][x];
						}
					}
					for(int y=0; y<SIZE; y++) {
						for(int x=0; x<SIZE; x++) {
							tempArr[y][x] = cloneMap[i][y][x];
						}
					}
				}
			}
			
			 
			for(int a=0; a<5; a++) {
				int[][][] tempClone = new int[SIZE][SIZE][SIZE];
				for(int h=0; h<SIZE; h++) {
					for(int y=0; y<SIZE; y++) {
						for(int x=0; x<SIZE; x++) {
							tempClone[h][y][x] = cloneMap[h][y][x];
						}
					}
				}
				for(int b=0; b<5; b++) {
					if(b == a) continue;
					for(int c=0; c<5; c++) {
						if(c == a || c == b) continue;
						for(int d=0; d<5; d++) {
							if(d == a || d == b || d == c) continue;
							for(int e=0; e<5; e++) {
								if(e == a || e == b || e == c || e == d) continue;
									for(int y=0; y<5; y++) {
										for(int x=0; x<5; x++) {
											cloneMap[0][y][x] = tempClone[a][y][x];
											cloneMap[1][y][x] = tempClone[b][y][x];
											cloneMap[2][y][x] = tempClone[c][y][x];
											cloneMap[3][y][x] = tempClone[d][y][x];
											cloneMap[4][y][x] = tempClone[e][y][x];
										}
									}
									
									// 탈출해보자(cloneMap)
									if(cloneMap[0][0][0] == 0 || cloneMap[4][4][4] == 0) break;
									
									int dh[] = {0, 0, 0, 0, 1, -1};
									int dy[] = {0, 0, 1, -1, 0, 0};
									int dx[] = {1, -1, 0, 0, 0, 0};
									boolean[][][] visited = new boolean[SIZE][SIZE][SIZE];
									Queue<Pos> q = new LinkedList<>();
									q.add(new Pos(0, 0, 0));
									visited[0][0][0] = true;
									int time = 0;
									boolean isEscape = false;
									while(!q.isEmpty()) {
										int qSize = q.size();
										for(int i=0; i<qSize; i++) {
											Pos p = q.poll();
											if(p.h == 4 && p.y == 4 && p.x == 4) {
												isEscape = true;
												ans = Math.min(ans, time);
												break;
											}
											for(int dir=0; dir<6; dir++) {
												int nh = p.h + dh[dir];
												int ny = p.y + dy[dir];
												int nx = p.x + dx[dir];
												
												if(nh<0 || nh>=SIZE || ny<0 || ny>=SIZE || nx<0 || nx>=SIZE) continue;
												if(visited[nh][ny][nx] || cloneMap[nh][ny][nx] == 0) continue;
												q.add(new Pos(nh, ny, nx));
												visited[nh][ny][nx] = true;
											}
										}
										if(isEscape) break;
										time++;
									}
								
							}
						}
					}
				}
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			list.add(i);
			dfs(depth + 1);
			list.remove(list.size()-1);
		}
	}
}
