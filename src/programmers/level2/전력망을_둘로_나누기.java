package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {

	public static void main(String[] args) {
		
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		
		int answer = solution(n, wires);
//		System.out.println(answer);
	}

	private static int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		int[][] map = new int[n+1][n+1];
		for(int i=0; i<wires.length; i++) {
			map[wires[i][0]][wires[i][1]] = 1;
			map[wires[i][1]][wires[i][0]] = 1;
		}
		
		for(int i=0; i<wires.length; i++) {
			int[][] cloneMap = makeCloneMap(n+1, map);
			
			cloneMap[wires[i][0]][wires[i][1]] = 0;
			cloneMap[wires[i][1]][wires[i][0]] = 0;
			
			int gapCnt = countGapWires(cloneMap);
//			System.out.println();
			answer = Math.min(answer, gapCnt);
			
		}
		
		return answer;
	}

	private static int countGapWires(int[][] cloneMap) {
		boolean doFlag = false;
		int cnt = 0;
		for(int i=0; i<cloneMap.length; i++) {
			for(int j=0; j<cloneMap[i].length; j++) {
				if(cloneMap[i][j] == 1) {
					doFlag = true;
					boolean[] visited = new boolean[cloneMap.length];
					Queue<Integer> q = new LinkedList<>();
					q.add(i);
					cnt++;
					visited[i] = true;
					while(!q.isEmpty()) {
						int wire = q.poll();
//						System.out.print(wire + " ");
						for(int w=0; w<cloneMap.length; w++) {
							if(cloneMap[wire][w] != 0 && !visited[w]) {
								q.add(w);
								visited[w] = true;
								cloneMap[wire][w] = 0;
								cloneMap[w][wire] = 0;
								cnt++;
							}
						}
					}
					
				}
				if(doFlag) break;
			}
			if(doFlag) break;
		}
		
		for(int i=0; i<cloneMap.length; i++) {
			for(int j=0; j<cloneMap[i].length; j++) {
				if(cloneMap[i][j] == 1) {
					cloneMap[j][i] = 0;
				}
			}
		}
		int cnt2 = 0;
		for(int i=0; i<cloneMap.length; i++) {
			for(int j=0; j<cloneMap[i].length; j++) {
				if(cloneMap[i][j] == 1) {
					cnt2++;
				}
			}
		}
		cnt2++;
		
//		System.out.println("CNT1 : " + cnt + ",  CNT2 : " + cnt2);
		return Math.abs(cnt - cnt2);
	}

	private static int bfs(int i, int j, int[][] cloneMap, boolean[] visited, int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		return 0;
	}

	private static int[][] makeCloneMap(int n, int[][] map) {
		int[][] cloneMap = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cloneMap[i][j] = map[i][j];
			}
		}
		return cloneMap;
	}
}
