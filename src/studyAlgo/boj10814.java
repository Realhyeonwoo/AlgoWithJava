import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Member {
	int age;
	int index;
	String name;

	Member(int age, int index, String name) {
		this.age = age;
		this.index = index;
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String getName() {
		return this.name;
	}
}

public class boj10814 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Member> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Member(Integer.parseInt(st.nextToken()), i, st.nextToken()));
		}
		
		Collections.sort(arr, new Comparator<Member>() {
			public int compare(Member o1, Member o2) {
				if(o1.getAge() == o2.getAge()) {
					return Integer.compare(o1.getIndex(), o2.getIndex());
				} else {
					return Integer.compare(o1.getAge(), o2.getAge());
				}
			}
		});
		
		for(Member o : arr) {
			sb.append(o.getAge() + " " + o.getName() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
