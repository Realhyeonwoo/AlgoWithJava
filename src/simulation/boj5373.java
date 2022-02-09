package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj5373 {
	static final int U = 0;
	static final int D = 1;
	static final int F = 2;
	static final int B = 3;
	static final int L = 4;
	static final int R = 5;
	static char[][][] cube = { { { 'w', 'w', 'w' }, { 'w', 'w', 'w' }, { 'w', 'w', 'w' } },
			{ { 'y', 'y', 'y' }, { 'y', 'y', 'y' }, { 'y', 'y', 'y' } },
			{ { 'r', 'r', 'r' }, { 'r', 'r', 'r' }, { 'r', 'r', 'r' } },
			{ { 'o', 'o', 'o' }, { 'o', 'o', 'o' }, { 'o', 'o', 'o' } },
			{ { 'g', 'g', 'g' }, { 'g', 'g', 'g' }, { 'g', 'g', 'g' } },
			{ { 'b', 'b', 'b' }, { 'b', 'b', 'b' }, { 'b', 'b', 'b' } } };
	static char[][][] cloneCube = new char[6][3][3];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			doCloneCube(cube, cloneCube);
			for (int i = 0; i < cnt; i++) {
				String order = st.nextToken();
				moveCube(order.charAt(0), order.charAt(1));
			}
			printUpSapce();
			doCloneCube(cube, cloneCube);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void moveCube(char space, char dir) {
		System.out.println(space + " " + dir);
		switch (space) {
		case 'U':
			if (dir == '+') {
				for(int i=0; i<3; i++) {
					cloneCube[F][0][i] = cube[R][0][i];
					cloneCube[R][0][i] = cube[B][0][i];
					cloneCube[B][0][i] = cube[L][0][i];
					cloneCube[L][0][i] = cube[F][0][i];
				}				
			} else if (dir == '-') {
				for(int i=0; i<3; i++) {
					cloneCube[F][0][i] = cube[L][0][i];
					cloneCube[R][0][i] = cube[F][0][i];
					cloneCube[B][0][i] = cube[R][0][i];
					cloneCube[L][0][i] = cube[B][0][i];
				}
			}
			System.out.println("@@@@@@@== UU ==@@@@@@");
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					System.out.print(cloneCube[U][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");
			break;
		case 'D':
			if (dir == '+') {
				for(int i=0; i<3; i++) {
					cloneCube[F][2][i] = cube[L][2][i];
					cloneCube[R][2][i] = cube[F][2][i];
					cloneCube[B][2][i] = cube[R][2][i];
					cloneCube[L][2][i] = cube[B][2][i];
				}				
			} else if (dir == '-') {
				for(int i=0; i<3; i++) {
					cloneCube[F][2][i] = cube[R][2][i];
					cloneCube[R][2][i] = cube[B][2][i];
					cloneCube[B][2][i] = cube[L][2][i];
					cloneCube[L][2][i] = cube[F][2][i];
				}
			}
			System.out.println("@@@@@@@== D ==@@@@@@");
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					System.out.print(cloneCube[U][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");
			break;
		case 'F':
			if (dir == '+') {
				for(int i=0; i<3; i++) {
					cloneCube[U][2][i] = cube[L][2-i][2];
					cloneCube[L][2-i][2] = cube[D][2][i];
					cloneCube[D][2][i] = cube[R][i][0];
					cloneCube[R][i][0] = cube[U][2][i];
				}
			} else if (dir == '-') {
				for(int i=0; i<3; i++) {
					cloneCube[U][2][i] = cube[R][2-i][0];
					cloneCube[R][2-i][0] = cube[D][2][i];
					cloneCube[D][2][i] = cube[L][2-i][2];
					cloneCube[L][2-i][2] = cube[U][2][i];
				}
			}
			
			System.out.println("@@@@@@@== F ==@@@@@@");
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					System.out.print(cloneCube[U][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");
			break;
		case 'B':
			if (dir == '+') {
				for(int i=0; i<3; i++) {
					cloneCube[U][0][i] = cube[R][i][2];
					cloneCube[R][i][2] = cube[D][0][i];
					cloneCube[D][0][i] = cube[L][2-i][0];
					cloneCube[L][2-i][0] = cube[U][0][i];
				}
			} else if (dir == '-') {
				for(int i=0; i<3; i++) {
					cloneCube[U][0][i] = cube[L][2-i][0];
					cloneCube[L][2-i][0] = cube[D][0][i];
					cloneCube[D][0][i] = cube[R][i][2];
					cloneCube[R][i][2] = cube[U][0][i];
				}
			}
			System.out.println("@@@@@@@== B ==@@@@@@");
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					System.out.print(cloneCube[U][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");
			break;
		case 'L':
			if (dir == '+') {
				for(int i=0; i<3; i++) {
					cloneCube[U][i][0] = cube[B][i][2];
					cloneCube[B][i][2] = cube[D][i][2];
					cloneCube[D][i][2] = cube[F][2-i][0];
					cloneCube[F][2-i][0] = cube[U][2-i][0];
				}
			} else if (dir == '-') {
				for(int i=0; i<3; i++) {
					cloneCube[U][i][0] = cube[F][i][0];
					cloneCube[F][i][0] = cube[D][2-i][2];
					cloneCube[D][2-i][2] = cube[B][2-i][2];
					cloneCube[B][2-i][2] = cube[U][i][0];
				}
			}
			System.out.println("@@@@@@@== L ==@@@@@@");
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					System.out.print(cloneCube[U][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");
			break;
		case 'R':
			if (dir == '+') {
				for(int i=0; i<3; i++) {
					cloneCube[U][i][2] = cube[F][i][2];
					cloneCube[F][i][2] = cube[D][2-i][0];
					cloneCube[D][2-i][0] = cube[B][2-i][0];
					cloneCube[B][2-i][0] = cube[U][i][0];
				}
			} else if (dir == '-') {
				for(int i=0; i<3; i++) {
					cloneCube[U][i][2] = cube[B][2-i][0];
					cloneCube[B][2-i][0] = cube[D][2-i][0];
					cloneCube[D][2-i][0] = cube[F][i][2];
					cloneCube[F][i][2] = cube[U][i][0];
				}
			}
			System.out.println("@@@@@@@== R ==@@@@@@");
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					System.out.print(cloneCube[U][y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("@@@@@@@@@@@@@@");
			break;
		default:
		}
	}

	private static void doCloneCube(char[][][] tempCube, char[][][] realCube) {
		for(int h=0; h<6; h++) {
			for(int y=0; y<3; y++) {
				for(int x=0; x<3; x++) {
					realCube[h][y][x] = tempCube[h][y][x];
				}
			}
		}
	}
	
	private static void printUpSapce() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				sb.append(cloneCube[0][y][x]);
			}
			sb.append("\n");
		}
	}
}
