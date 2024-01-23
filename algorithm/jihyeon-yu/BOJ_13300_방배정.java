package jihyeon;

import java.util.Arrays;
import java.util.Scanner;

public class 방배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] student = new int[2][6];
		
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			student[s][y-1]++;
		}
		
		int room_num = 0;
		
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[i].length; j++) {
				if(student[i][j] == 0) {
					
				} else if(student[i][j] <= k) {
					room_num++;
				} else {
					room_num += student[i][j] / k + 1;
				}
			}
		}
		System.out.println(room_num);
	}
}
