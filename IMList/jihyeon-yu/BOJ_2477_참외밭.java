package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_2477_참외밭 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int xPoint = 0;
		int yPoint = 0;
		
		int[] xGrid = new int[6];
		int[] yGrid = new int[6];
		
		for (int i = 0; i < 6; i++) {
			int direction = sc.nextInt();
			int length = sc.nextInt();
			
			if(direction == 1) { // east
				xPoint += length;
				xGrid[i] = xPoint;
				yGrid[i] = yPoint;
			} else if(direction == 2) { // west
				xPoint -= length;
				xGrid[i] = xPoint;
				yGrid[i] = yPoint;
			} else if(direction == 3) {
				yPoint += length;
				xGrid[i] = xPoint;
				yGrid[i] = yPoint;
			} else {
				yPoint -= length;
				xGrid[i] = xPoint;
				yGrid[i] = yPoint;
			}
			
		}
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += xGrid[i] * yGrid[i+1] - xGrid[i+1] * yGrid[i];
		}
		sum += xGrid[0] * yGrid[5] - xGrid[5] * yGrid[0];
		
		if(sum<0) sum = -sum;
		sum /= 2;
		System.out.println(sum * k);
	}

}
