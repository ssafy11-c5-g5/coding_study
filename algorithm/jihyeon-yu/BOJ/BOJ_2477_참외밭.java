package swea;

import java.util.Arrays;
import java.util.Scanner;

public class 참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num_oriental_melon_per_pyeong = sc.nextInt();
		int[][] points = new int[6][2];
		int[] zero_point = {0, 0};
		for (int i = 0; i < 6; i++) {
			int[] directions = new int[2];
			int direction_num = sc.nextInt();
			int length = sc.nextInt();
			switch (direction_num) {
			case 1: //east
				directions[0] = 1;
				directions[1] = 0;
				break;
			case 2: //west
				directions[0] = -1;
				directions[1] = 0;
				break;
			case 3: //south
				directions[0] = 0;
				directions[1] = 1;
				break;
			case 4: //north
				directions[0] = 0;
				directions[1] = -1;
				break;
			}
			zero_point[0] += directions[0] * length;
			zero_point[1] += directions[1] * length;
			int[] coordinate = {zero_point[0], zero_point[1]};
			points[i] = coordinate;
			
		}

		int sum = 0;
		int line;
		for (int i = 0; i < points.length; i++) {
			if(points.length - 1 == i) {
				line = points[i][0] * points[0][1] - points[0][0] * points[i][1];
			} else {
				line = points[i][0] * points[i+1][1] - points[i+1][0] * points[i][1];
			}
			sum += line;
		}
		if (sum < 0) {
			sum = -sum;
		}
		System.out.println(sum/2*num_oriental_melon_per_pyeong);
	}

}
