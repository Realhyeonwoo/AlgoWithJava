import java.util.Scanner;

public class boj2588 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		scan.close();
		
		System.out.println(A * (B%10));
		System.out.println(A * (B%100-B%10)/10);
		System.out.println(A * (B/100));
		System.out.println(A * B);
	}
}
