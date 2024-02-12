package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_8382_방향전환 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		for (int t = 1; t <= T; t++) {
 			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int xAbs = Math.abs(x2 - x1);
			int yAbs = Math.abs(y2 - y1);
			
			int move = 0;
			if((xAbs + yAbs) % 2 == 0) {
				if(xAbs >= yAbs) {
					move += xAbs * 2;
				} else {
					move += yAbs * 2;
				}
			} else {
				move += (Math.max(xAbs, yAbs)-1) * 2 + 1;
			}
			
			System.out.println("#" + t + " " + move);
		}
	}
}
