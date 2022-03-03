import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj9020 {
	static int MAX = 10001;
	static boolean[] sosu = new boolean [MAX];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �Ƹ������ڷ���ü ����
		Arrays.fill(sosu, true);
		sosu[0] = sosu[1] = false;
		for(int i=2; i<MAX; i++) {
			for(int j=i*i; j<MAX; j+=i) {
				sosu[j] = false;
			}
		} // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40
		// 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
		// 3*3 = 9
		// 4*4 = 16
		// 5*5 = 25 
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			// �Է�
			int n = Integer.parseInt(br.readLine());
			int a = 0, b = 0;
			int sub = MAX;
			
			// üũ
			for(int i=2; i<=n; i++) {
				if(!sosu[i]) continue;
				
				if(sosu[n-i] && (Math.abs(i-(n-i)) < sub)) {
					a = n-i;
					b = i;
					sub = Math.abs(a- b);
				}
			}
			
			// ���
			if(a < b) {
				System.out.println(a + " " + b);
			} else {
				System.out.println(b + " " + a);
			}
			
		}
	}
}	
