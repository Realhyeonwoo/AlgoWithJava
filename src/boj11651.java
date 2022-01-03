import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Coord {
	private int x, y;
	Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int getX() {
		return this.x;
	}
	int getY() {
		return this.y;
	}
}

public class boj11651 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Coord> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr, new Comparator<Coord>() {
			public int compare(Coord o1, Coord o2) {
				return (o1.getY() == o2.getY()) ? Integer.compare(o1.getX(), o2.getX()) : Integer.compare(o1.getY(), o2.getY()); 
			}
		});
		
		for(Coord o : arr) {
			sb.append(o.getX() + " " + o.getY() + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
