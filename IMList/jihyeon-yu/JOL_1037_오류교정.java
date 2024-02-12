package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JOL_1037_오류교정 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		System.out.println(isParity(map));
	}
	
	public static String isParity(int[][] map) {
		int[] rowChecker = new int[map.length];
		int[] colChecker = new int[map[0].length];
		
		boolean rowOK = true;
		boolean colOK = true;
		
		int oddR = 0;
		int oddC = 0;
		
		for (int r = 0; r < map.length; r++) {
			int rowCheck = 0;
			for (int c = 0; c < map[0].length; c++) {
				if(map[r][c] == 1) rowCheck++;
			}
			rowChecker[r] = rowCheck;
			if(rowCheck % 2 == 1) {
				rowOK = false;
				oddR = r;
			}
			
		}
		
		for (int c = 0; c < map[0].length; c++) {
			int colCheck = 0;
			for (int r = 0; r < map.length; r++) {
				if(map[r][c] == 1) colCheck++;
			}
			colChecker[c] = colCheck;
			if(colCheck % 2 == 1) {
				colOK = false;
				oddC = c;
			}
		}
		
		
		if(rowOK && colOK) return "OK";
		else {
			map[oddR][oddC] = map[oddR][oddC] == 0? 1 : 0;
			if(isParity(map) == "OK") return "Change bit ("+ (oddR+1) + "," + (oddC+1) + ")";
			else return "Corrupt";
		}
	}

}
