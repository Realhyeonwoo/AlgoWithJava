package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj14500 {
	static int N, M;
	static int ans = Integer.MIN_VALUE;
	static int[][] arr;
	static int[][][] blocks = { { { 1, 1 }, { 1, 1 } }, { { 1, 1, 1, 1 } }, { { 1, 0 }, { 1, 0 }, { 1, 1 } },
			{ { 1, 0 }, { 1, 1 }, { 0, 1 } }, { { 1, 1, 1 }, { 0, 1, 0 } } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < blocks.length; i++) {
			simulation(blocks[i], i);
		}

		System.out.println(ans);
	}

	private static void simulation(int[][] block, int num) {
//		System.out.println("NUM : " + num);
//		System.out.println();
//		for (int i = 0; i < block.length; i++) {
//			for (int j = 0; j < block[i].length; j++) {
//				System.out.print(block[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		int[][] temp;
		int[][] temp2;
		int[][] temp3;
		switch (num) {
		case 0:
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (block.length + y - 1 >= N || block[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < block.length + y; i++) {
						for (int j = x; j < block[0].length + x; j++) {
							sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			break;
		case 1:
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (block.length + y - 1 >= N || block[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < block.length + y; i++) {
						for (int j = x; j < block[0].length + x; j++) {
							sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}

			// È¸Àü
			temp = new int[block[0].length][block.length];
			for (int y = 0; y < block.length; y++) {
				for (int x = 0; x < block[0].length; x++) {
					temp[x][block.length - y - 1] = block[y][x];

				}
			}

//			System.out.println();
//			for (int i = 0; i < temp.length; i++) {
//				for (int j = 0; j < temp[i].length; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp.length + y - 1 >= N || temp[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp.length + y; i++) {
						for (int j = x; j < temp[0].length + x; j++) {
							sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			break;
		case 2:
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (block.length + y - 1 >= N || block[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < block.length + y; i++) {
						for (int j = x; j < block[0].length + x; j++) {
							if (block[i - y][j - x] != 0)
								if (block[i - y][j - x] != 0)
									sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// ´ëÄª
			temp3 = new int[block.length][block[0].length];
			for (int y = 0; y < temp3.length; y++) {
				for (int x = 0; x < temp3[y].length; x++) {
					if (x == 0) {
						temp3[y][x] = block[y][x + 1];
					} else {
						temp3[y][x] = block[y][x - 1];
					}
				}
			}

//			System.out.println();
//			for (int i = 0; i < temp3.length; i++) {
//				for (int j = 0; j < temp3[i].length; j++) {
//					System.out.print(temp3[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp3.length + y - 1 >= N || temp3[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp3.length + y; i++) {
						for (int j = x; j < temp3[0].length + x; j++) {
							if (temp3[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// È¸Àü
			temp = new int[block[0].length][block.length];
			for (int y = 0; y < block.length; y++) {
				for (int x = 0; x < block[0].length; x++) {
					temp[x][block.length - y - 1] = block[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp.length; i++) {
//				for (int j = 0; j < temp[i].length; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp.length + y - 1 >= N || temp[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp.length + y; i++) {
						for (int j = x; j < temp[0].length + x; j++) {
							if (temp[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// ´ëÄª
			temp3 = new int[temp.length][temp[0].length];
			temp3[0][0] = temp[0][2];
			temp3[0][1] = temp[0][1];
			temp3[0][2] = temp[0][0];
			temp3[1][0] = temp[1][2];
			temp3[1][1] = temp[1][1];
			temp3[1][2] = temp[1][0];
//			System.out.println();
//			for (int i = 0; i < temp3.length; i++) {
//				for (int j = 0; j < temp3[i].length; j++) {
//					System.out.print(temp3[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp3.length + y - 1 >= N || temp3[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp3.length + y; i++) {
						for (int j = x; j < temp3[0].length + x; j++) {
							if (temp3[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// È¸Àü
			temp2 = new int[temp[0].length][temp.length];
			for (int y = 0; y < temp.length; y++) {
				for (int x = 0; x < temp[0].length; x++) {
					temp2[x][temp.length - y - 1] = temp[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp2.length; i++) {
//				for (int j = 0; j < temp2[i].length; j++) {
//					System.out.print(temp2[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp2.length + y - 1 >= N || temp2[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp2.length + y; i++) {
						for (int j = x; j < temp2[0].length + x; j++) {
							if (temp2[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// ´ëÄª
			temp3 = new int[temp2.length][temp2[0].length];
			for (int y = 0; y < temp3.length; y++) {
				for (int x = 0; x < temp3[y].length; x++) {
					if (x == 0) {
						temp3[y][x] = temp2[y][x + 1];
					} else {
						temp3[y][x] = temp2[y][x - 1];
					}
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp3.length; i++) {
//				for (int j = 0; j < temp3[i].length; j++) {
//					System.out.print(temp3[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp3.length + y - 1 >= N || temp3[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp3.length + y; i++) {
						for (int j = x; j < temp3[0].length + x; j++) {
							if (temp3[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// È¸Àü
			temp = new int[temp2[0].length][temp2.length];
			for (int y = 0; y < temp2.length; y++) {
				for (int x = 0; x < temp2[0].length; x++) {
					temp[x][temp2.length - y - 1] = temp2[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp.length; i++) {
//				for (int j = 0; j < temp[i].length; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp.length + y - 1 >= N || temp[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp.length + y; i++) {
						for (int j = x; j < temp[0].length + x; j++) {
							if (temp[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// ´ëÄª
			temp3 = new int[temp.length][temp[0].length];
			temp3[0][0] = temp[0][2];
			temp3[0][1] = temp[0][1];
			temp3[0][2] = temp[0][0];
			temp3[1][0] = temp[1][2];
			temp3[1][1] = temp[1][1];
			temp3[1][2] = temp[1][0];
//			System.out.println();
//			for (int i = 0; i < temp3.length; i++) {
//				for (int j = 0; j < temp3[i].length; j++) {
//					System.out.print(temp3[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp3.length + y - 1 >= N || temp3[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp3.length + y; i++) {
						for (int j = x; j < temp3[0].length + x; j++) {
							if (temp3[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// È¸Àü
			break;
		case 3:
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (block.length + y - 1 >= N || block[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < block.length + y; i++) {
						for (int j = x; j < block[0].length + x; j++) {
							if (block[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// ´ëÄª
			temp3 = new int[block.length][block[0].length];
			temp3[0][0] = block[0][1];
			temp3[0][1] = block[0][0];
			temp3[1][0] = block[1][1];
			temp3[1][1] = block[1][0];
			temp3[2][0] = block[2][1];
			temp3[2][1] = block[2][0];
//			System.out.println();
//			for (int i = 0; i < temp3.length; i++) {
//				for (int j = 0; j < temp3[i].length; j++) {
//					System.out.print(temp3[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp3.length + y - 1 >= N || temp3[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp3.length + y; i++) {
						for (int j = x; j < temp3[0].length + x; j++) {
							if (temp3[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// È¸Àü
			temp = new int[block[0].length][block.length];
			for (int y = 0; y < block.length; y++) {
				for (int x = 0; x < block[0].length; x++) {
					temp[x][block.length - y - 1] = block[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp.length; i++) {
//				for (int j = 0; j < temp[i].length; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp.length + y - 1 >= N || temp[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp.length + y; i++) {
						for (int j = x; j < temp[0].length + x; j++) {
							if (temp[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			// ´ëÄª
			temp3 = new int[temp.length][temp[0].length];
			temp3[0][0] = temp[0][2];
			temp3[0][1] = temp[0][1];
			temp3[0][2] = temp[0][0];
			temp3[1][0] = temp[1][2];
			temp3[1][1] = temp[1][1];
			temp3[1][2] = temp[1][0];
//			System.out.println();
//			for (int i = 0; i < temp3.length; i++) {
//				for (int j = 0; j < temp3[i].length; j++) {
//					System.out.print(temp3[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp3.length + y - 1 >= N || temp3[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp3.length + y; i++) {
						for (int j = x; j < temp3[0].length + x; j++) {
							if (temp3[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			break;
		case 4:
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (block.length + y - 1 >= N || block[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < block.length + y; i++) {
						for (int j = x; j < block[0].length + x; j++) {
							if (block[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			temp = new int[block[0].length][block.length];
			for (int y = 0; y < block.length; y++) {
				for (int x = 0; x < block[0].length; x++) {
					temp[x][block.length - y - 1] = block[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp.length; i++) {
//				for (int j = 0; j < temp[i].length; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp.length + y - 1 >= N || temp[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp.length + y; i++) {
						for (int j = x; j < temp[0].length + x; j++) {
							if (temp[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			temp2 = new int[temp[0].length][temp.length];
			for (int y = 0; y < temp.length; y++) {
				for (int x = 0; x < temp[0].length; x++) {
					temp2[x][temp.length - y - 1] = temp[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp2.length; i++) {
//				for (int j = 0; j < temp2[i].length; j++) {
//					System.out.print(temp2[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp2.length + y - 1 >= N || temp2[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp2.length + y; i++) {
						for (int j = x; j < temp2[0].length + x; j++) {
							if (temp2[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}

			temp = new int[temp2[0].length][temp2.length];
			for (int y = 0; y < temp2.length; y++) {
				for (int x = 0; x < temp2[0].length; x++) {
					temp[x][temp2.length - y - 1] = temp2[y][x];
				}
			}
//			System.out.println();
//			for (int i = 0; i < temp.length; i++) {
//				for (int j = 0; j < temp[i].length; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (temp.length + y - 1 >= N || temp[0].length + x - 1 >= M)
						continue;
					int sum = 0;
					for (int i = y; i < temp.length + y; i++) {
						for (int j = x; j < temp[0].length + x; j++) {
							if (temp[i - y][j - x] != 0)
								sum += arr[i][j];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			break;
		default:
		}
	}
}

//int[][] test = {{1, 0}, {1,0}, {1,1}};
//for(int i=0; i<test.length; i++) {
//	for(int j=0; j<test[i].length; j++) {
//		System.out.print(test[i][j] + " ");
//	}
//	System.out.println();
//}
//int[][] temp = new int[test[0].length][test.length];
//for(int y=0; y<test.length; y++) {
//	for(int x=0; x<test[0].length; x++) {
//		temp[x][test.length-y-1] = test[y][x];
//
//	}
//}
//for(int y=0; y<temp.length; y++) {
//	for(int x=0; x<temp[0].length; x++) {
//		System.out.print(temp[y][x] + " ");
//	}
//	System.out.println();
//}
