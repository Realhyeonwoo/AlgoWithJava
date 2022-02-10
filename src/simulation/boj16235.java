package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16235 {
	static class Tree implements Comparable<Tree>{
		int y, x, age;
		Tree(int y, int x, int age) {
			this.y = y;
			this.x = x;
			this.age = age;
		}
		@Override
		public int compareTo(Tree t) {
			return this.age - t.age;
		}
	}
	static int N, M, K;
	static int[][] map;
	static int[][] riceMap;
	static PriorityQueue<Tree> treeQ = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		// INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int y=1; y<=N; y++)
			Arrays.fill(map[y], 5);
		riceMap = new int[N+1][N+1];
		for(int y=1; y<=N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=1; x<=N; x++) {
				riceMap[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			treeQ.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// SIMULATION
		for(int k=0; k<K; k++) {
			Queue<Tree> diedTree = new LinkedList<>();
			Queue<Tree> livedTree = new LinkedList<>();
			// 봄
			while(!treeQ.isEmpty()) {
				Tree t = treeQ.poll();
				map[t.y][t.x] -= t.age;
				if(map[t.y][t.x] < 0) {
					map[t.y][t.x] += t.age;
					diedTree.add(new Tree(t.y, t.x, t.age));
				} else {
					livedTree.add(new Tree(t.y, t.x, t.age+1));
				}
			}
			while(!livedTree.isEmpty()) 
				treeQ.add(livedTree.poll());
			
//			System.out.println("SPRING");
//			System.out.println("TREE LIST");
//			Iterator a = treeQ.iterator();
//			while(a.hasNext()) {
//				Tree t = (Tree)a.next();
//				System.out.println(t.y + " " + t.x + " " + t.age);
//			}
//			System.out.println("MAP");
//			for(int y=1; y<=N; y++) {
//				for(int x=1; x<=N; x++) {
//					System.out.print(map[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================");
			
			// 여름
			while(!diedTree.isEmpty()) {
				Tree t = diedTree.poll();
				map[t.y][t.x] += t.age/2; 
			}
			
//			System.out.println("SUMMER");
//			System.out.println("TREE LIST");
//			 a = treeQ.iterator();
//			while(a.hasNext()) {
//				Tree t = (Tree)a.next();
//				System.out.println(t.y + " " + t.x + " " + t.age);
//			}
//			System.out.println("MAP");
//			for(int y=1; y<=N; y++) {
//				for(int x=1; x<=N; x++) {
//					System.out.print(map[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================");

			// 가을
			int dy[] = {0, 0, 1, -1, -1, -1, 1, 1};
			int dx[] = {1, -1, 0, 0, -1, 1, -1, 1};
			Queue<Tree> newTree = new LinkedList<>();
			Iterator iter = treeQ.iterator();
			while(iter.hasNext()) {
				Tree t = (Tree) iter.next();
				if(t.age%5 == 0) {
					for(int dir=0; dir<8; dir++) {
						int ny = t.y + dy[dir];
						int nx = t.x + dx[dir];
						
						if(ny<1 || ny>N || nx<1 || nx>N) continue;
						newTree.add(new Tree(ny, nx, 1));
					}
				}
			}
			while(!newTree.isEmpty()) 
				treeQ.add(newTree.poll());
			
//			System.out.println("FALL");
//			System.out.println("TREE LIST");
//			 a = treeQ.iterator();
//			while(a.hasNext()) {
//				Tree t = (Tree)a.next();
//				System.out.println(t.y + " " + t.x + " " + t.age);
//			}
//			System.out.println("MAP");
//			for(int y=1; y<=N; y++) {
//				for(int x=1; x<=N; x++) {
//					System.out.print(map[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================");
			
			// 겨울
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=N; x++) {
					map[y][x] += riceMap[y][x];
				}
			}
			
//			System.out.println("WINTER");
//			System.out.println("TREE LIST");
//			a = treeQ.iterator();
//			while(a.hasNext()) {
//				Tree t = (Tree)a.next();
//				System.out.println(t.y + " " + t.x + " " + t.age);
//			}
//			System.out.println("MAP");
//			for(int y=1; y<=N; y++) {
//				for(int x=1; x<=N; x++) {
//					System.out.print(map[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================");
		}
		
		// OUTPUT
		System.out.println(treeQ.size());
	}
}
