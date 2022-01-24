package studyAlgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class study {
	static int sum = 0;
	
	public static void main(String[] args) {
		System.out.println("printSum");
		printNum(1);
		System.out.println();
		System.out.println("doSum : " + doSum(1));
	}
	public static void printNum(int n) {
		if(n == 11) return;		
		System.out.print(n++ + " ");
		printNum(n);
	}
	public static int doSum(int n) {
		if(n == 10) return 10;
		return n+doSum(n+1);
	}
}
