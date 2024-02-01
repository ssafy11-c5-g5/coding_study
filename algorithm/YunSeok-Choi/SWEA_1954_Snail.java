import java.util.Scanner;

public class Snail {

	static int[][] map;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		makeSnail(1, 1, 0, 0);

		for (int j2 = 0; j2 < map.length; j2++) {
			for (int k = 0; k < map.length; k++) {
				System.out.print(map[j2][k] + " ");
			}
			System.out.println();
		}
	
	}

	private static void makeSnail(int idx, int loc, int i, int j) {

		map[i][j] = idx;
		
		if (idx == N * N) {
 			return;
		}

		
		
		if (loc == 1) {
			if (j + 1 < N && map[i][j + 1] == 0) {
				makeSnail(idx + 1, loc, i, j + 1);
			} else {
				makeSnail(idx + 1, 2, i + 1, j);
			}
		} else if (loc == 2) {
			if (i + 1 < N && map[i + 1][j] == 0) {
				makeSnail(idx + 1, loc, i + 1, j);
			} else {
				makeSnail(idx + 1, 3, i, j - 1);
			}
		} else if (loc == 3) {
			if (j - 1 >= 0 && map[i][j - 1] == 0) {
				makeSnail(idx + 1, loc, i, j - 1);
			} else {
				makeSnail(idx + 1, 4, i - 1, j);
			}
		} else if (loc == 4) {
			if (i - 1 >= 0 && map[i - 1][j] == 0) {
				makeSnail(idx + 1, loc, i - 1, j);
			} else {
				makeSnail(idx + 1, 1, i, j + 1);
			}
		}

	}

}
