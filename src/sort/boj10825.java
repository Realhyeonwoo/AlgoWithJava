package sort;

import java.util.*;
import java.io.*;

public class boj10825 {
	static class Student {
		String name;
		int kor, eng, math;
		Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Student[] arr = new Student[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				if(o1.kor == o2.kor) {
					if(o1.eng == o2.eng) {
						if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						} else {
							return o2.math - o1.math;
						}
					} else {
						return o1.eng - o2.eng;
					}
				} else {
					return o2.kor - o1.kor;
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++)
			sb.append(arr[i].name + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
