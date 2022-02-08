package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class study {
	static int N, M;
	static boolean[] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> input = new ArrayList<>();
	static Set<String> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			input.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(input);
		
		dfs(0, 0);
		
		for(String str : set)
			System.out.println(str);
//		Iterator<String> iter = set.iterator();
//		while(!iter.hasNext()) {
//			System.out.println(iter.next());
//		}
	}
		private static void dfs(int depth, int start) {
		if(depth == M) {
			String str = "";
			for(int i=0; i<list.size(); i++) {
				str += input.get(list.get(i)).toString();
				str += " ";
			}
			set.add(str);

			return;
		}
		
		for(int i=start; i<N; i++) {
//			if(visited[i]) continue;
//			visited[i] = true;
			list.add(i);
			dfs(depth + 1, i);
//			visited[i] = false;
			list.remove(list.size()-1);
		}
	}
}

