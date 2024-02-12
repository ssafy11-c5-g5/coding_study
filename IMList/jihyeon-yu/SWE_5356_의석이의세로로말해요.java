package imlist;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5356_의석이의세로로말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			char[][] arr = new char[15][15];
			for (int r = 0; r < 15; r++) {
				for (int c = 0; c < 15; c++) {
					arr[r][c] = '.';
				}
			}
			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			for (int c = 0; c < 15; c++) {
				for (int r = 0; r < 15; r++) {
					if(arr[r][c] == '.') continue;
					else sb.append(arr[r][c]);
				}
			}
			System.out.println("#" + t + " " + sb);
			sb.setLength(0);
		}
	}

}
