package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17837 {
	static class Pawn {
		int y, x, dir, pos;
		Pawn(int y, int x, int dir, int pos) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.pos = pos;
		}
		@Override
		public String toString() {
			return "( " + y + ", " + x + ") dir : " + dir + " pos : " + pos;
		}
	}
	static int[] dy = {0, 0, 0, -1, 1};
	static int[] dx = {0, 1, -1, 0, 0};
	
	static int N, K;
	static int[][] map;
	static int[][][] pawnMap;
	static Pawn[] pawnArr;
	public static void main(String[] args) throws Exception {
		// INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pawnMap = new int[N+1][N+1][10];
		map = new int[N+1][N+1];
		for(int y=1; y<=N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=1; x<=N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		pawnArr = new Pawn[K+1];
		for(int k=1; k<=K; k++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			pawnArr[k] = new Pawn(y, x, dir, 0);
			pawnMap[y][x][0] = k;
		}
		
		
		int time = 0;
		while(time<4) {
			System.out.println();
			for(int t=1; t<=K; t++) {
				System.out.println(pawnArr[t]);
			}
			System.out.println();
			
			boolean isMove = false;
			boolean isDone = false;
			
			for(int p=1; p<pawnArr.length; p++) {
				System.out.println("======" + p + "=======");
				int py = pawnArr[p].y;
				int px = pawnArr[p].x;
				int dir = pawnArr[p].dir;
				int pos = pawnArr[p].pos;
				
				int ny = py + dy[dir];
				int nx = px + dx[dir];
				
				if(ny<1 || ny>N || nx<1 || nx>N) {
					dir = (dir%2 == 0) ? dir-1 : dir+1;
					ny = py + dy[dir];
					nx = px + dx[dir];
					if(map[ny][nx] != 2) {
						int idx = 0;
						for(int i=0; i<K; i++) {
							if(pawnMap[ny][nx][i] == 0) continue;
							idx++;
						}
						while(pawnMap[py][px][pos] != 0) {
							pawnMap[ny][nx][idx] = pawnMap[py][px][pos];
							pawnArr[pawnMap[py][px][pos]] = new Pawn(ny, nx, pawnArr[pawnMap[py][px][pos]].dir, idx);
							pawnMap[py][px][pos] = 0;
							idx++;
							pos++;
						}
						isMove = true;
					} else {
						pawnArr[p] = new Pawn(py, px, dir, pos);
					}
					System.out.println();
					for(int t=1; t<=K; t++) {
						System.out.println(pawnArr[t]);
					}
					System.out.println();
					
				} else {
//					System.out.println("=====" + "P : " + p + " DIR : " + dir + " MAP : " + map[ny][nx] + "==========");
					switch(map[ny][nx]) {
					case 0:
						int idx = 0;
						for(int i=0; i<K; i++) {
							if(pawnMap[ny][nx][i] == 0) break;
							idx++;
						}
						while(pawnMap[py][px][pos] != 0) {
//							System.out.println("B : " + py + " " + px + " " + pos);
//							System.out.println("A : " + ny + " " + nx + " " + idx);
							pawnMap[ny][nx][idx] = pawnMap[py][px][pos];
							pawnArr[pawnMap[py][px][pos]] = new Pawn(ny, nx, pawnArr[pawnMap[py][px][pos]].dir, idx);
//							System.out.println(pawnMap[py][px][pos] + " : " + pawnArr[pawnMap[py][px][pos]]);
							pawnMap[py][px][pos] = 0;
							idx++;
							pos++;
						}
						isMove = true;
						if(idx == K) isDone = true;
						break;
					case 1:
//						System.out.println("B : " + py + " " + px + " " + pos);
						idx = 0;
						for(int i=0; i<K; i++) {
							if(pawnMap[ny][nx][i] == 0) break;
							idx++;
						}
//						System.out.println("A : " + ny + " " + nx + " " + idx);
						int idx2 = pos;
						for(int i=pos; i<K; i++) {
							if(pawnMap[py][px][i] == 0) break;
							idx2++;
						}
						idx2 -= 1;
//						System.out.println("IDX : " + idx + " IDX2 : " + idx2);
						for(int i=idx2; i>=pos; i--) {
							pawnMap[ny][nx][idx] = pawnMap[py][px][i];
							pawnArr[pawnMap[py][px][i]] = new Pawn(ny, nx, pawnArr[pawnMap[py][px][i]].dir, idx);
							pawnMap[py][px][i] = 0;
//							System.out.println("PAWN : " + pawnMap[ny][nx][idx]);
							idx++;
						}
						isMove = true;
						if(idx == K) isDone = true;
						break;
					case 2:
						dir = (dir%2 == 0) ? dir-1 : dir+1;
						System.out.println("c DIR : " + dir);
						ny = py + dy[dir];
						nx = px + dx[dir];
						if(ny<1 || ny>N || nx<1 || nx>N) {
							pawnArr[p] = new Pawn(py, px, dir, pos);
							break;
						}
						if(map[ny][nx] != 2) {
							idx = 0;
							for(int i=0; i<K; i++) {
								if(pawnMap[ny][nx][i] == 0) break;
								idx++;
							}
							while(pawnMap[py][px][pos] != 0) {
								pawnMap[ny][nx][idx] = pawnMap[py][px][pos];
								pawnArr[pawnMap[py][px][pos]] = new Pawn(ny, nx, pawnArr[pawnMap[py][px][pos]].dir, idx);
								pawnMap[py][px][pos] = 0;
								idx++;
								pos++;
							}
							isMove = true;
							if(idx == K) isDone = true;
						} else {
							pawnArr[p] = new Pawn(py, px, dir, pos);
						}
						break;
						default:
					}
					
				}
				if(isDone) break;
				
				System.out.println();
				for(int t=1; t<=K; t++) {
					System.out.println(pawnArr[t]);
				}
				System.out.println();
				
			}
			time++;
		
			
			if(!isMove) {
				time = -1;
				break;
			}
		}
		
		System.out.println(time);
	}
}
