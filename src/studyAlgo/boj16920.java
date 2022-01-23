package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16920 {
	static class Pos {
		int player, y, x;
		Pos(int player, int y, int x) {
			this.player = player;
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<Pos> q = new LinkedList<>();
		int[] playerValue = new int[P+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<playerValue.length; i++)
			playerValue[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int p=1; p<=P; p++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == '.' || arr[i][j] == '#') continue;
					if(Integer.parseInt(arr[i][j]+"") == p) {
						q.add(new Pos(p, i, j));
						visited[i][j] = true;
					}
				}
			}
		}
		
		int[] dy = {0, 0, 1, -1};
		int[] dx = {1, -1, 0, 0};
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int player = p.player;
			int y = p.y;
			int x = p.x;
			
			for(int s=0; s<playerValue[player]; s++) {
				
			}
			
			for(int dir=0; dir<4; dir++) {
				for(int i=1; i<=playerValue[player]; i++) {
					int ny = y + dy[dir] * i;
					int nx = x + dx[dir] * i;
					
					if(ny<0 || ny>=N || nx<0 || nx>=M) break;
					if(visited[ny][nx] || arr[ny][nx] == '#') continue;
					visited[ny][nx] = true;
					arr[ny][nx] = Character.forDigit(player, 10);
					q.add(new Pos(player, ny, nx));
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		int[] cnt = new int[P+1];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != '.' && arr[i][j] != '#') {
					cnt[Integer.parseInt(arr[i][j]+"")]++;
				}
			}
		}
		for(int i=1; i<P+1; i++) {
			sb.append(cnt[i] + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
