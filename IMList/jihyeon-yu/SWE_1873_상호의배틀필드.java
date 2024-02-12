package swea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 상호의배틀필드 {

	public static void main(String[] args) throws FileNotFoundException {
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {
			// 입력 시작
			int row = sc.nextInt();
			int col = sc.nextInt();
			char[][] field = new char[row][col];
			for (int r = 0; r < row; r++) {
				String str = sc.next();
				for (int c = 0; c < col; c++) {
					field[r][c] = str.charAt(c);
				}
				
			}
			int n = sc.nextInt();
			char[] attack = new char[n];
			String str = sc.next();
			for (int i = 0; i < n; i++) {
				attack[i] = str.charAt(i);
			}
			// 입력 종료
			
			// 전차 찾기 시작
			int tankX = -1, tankY = -1;
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (field[r][c] == '^' || field[r][c] == 'v' || 
							field[r][c] == '<' || field[r][c] == '>'){
						tankX = c;
						tankY = r;
					}
				}
			}
			
			// 전차 찾기 종료
			
			// process 시작
			for (int i = 0; i < attack.length; i++) {
				switch(attack[i]) {
				case 'U':
					field[tankY][tankX] = '^';
					if (tankY - 1 < 0) break;
					if (field[tankY-1][tankX] == '.') {
						field[tankY][tankX] = '.';
						field[tankY-1][tankX] = '^';
						tankY--;
					}
					break;
				case 'D':
					field[tankY][tankX] = 'v';
					if (tankY + 1 >= row) break;
					if (field[tankY+1][tankX] == '.') {
						field[tankY][tankX] = '.';
						field[tankY+1][tankX] = 'v';
						tankY++;
					}
					break;
				case 'L':
					field[tankY][tankX] = '<';
					if (tankX - 1 < 0) break;
					if (field[tankY][tankX-1] == '.') {
						field[tankY][tankX] = '.';
						field[tankY][tankX-1] = '<';
						tankX--;
					}
					break;
				case 'R':
					field[tankY][tankX] = '>';
					if (tankX + 1 >= col) break;
					if (field[tankY][tankX+1] == '.') {
						field[tankY][tankX] = '.';
						field[tankY][tankX+1] = '>';
						tankX++;
					}
					break;
				default:
					switch(field[tankY][tankX]) {
					case '^':
						for (int y = tankY-1; y >= 0; y--) {
							if (field[y][tankX] == '#') {
								break;
							} else if (field[y][tankX] == '*') {
								field[y][tankX] = '.';
								break;
							}
						}
						break;
					case 'v':
						for (int y = tankY+1; y < row; y++) {
							if (field[y][tankX] == '#') {
								break;
							} else if (field[y][tankX] == '*') {
								field[y][tankX] = '.';
								break;
							}
						}
						break;
					case '<':
						for (int x = tankX-1; x >= 0; x--) {
							if (field[tankY][x] == '#') {
								break;
							} else if (field[tankY][x] == '*') {
								field[tankY][x] = '.';
								break;
							}
						}
						break;
					case '>':
						for (int x = tankX+1; x < col; x++) {
							if (field[tankY][x] == '#') {
								break;
							} else if (field[tankY][x] == '*') {
								field[tankY][x] = '.';
								break;
							}
						}
						break;
					default:
						break;
					}
					break;
				}
			}
			// process 종료
			
			System.out.print("#" + t + " ");
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					System.out.print(field[r][c]);
				}
				System.out.println();
			}
		}
	}
}
