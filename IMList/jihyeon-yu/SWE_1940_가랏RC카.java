package imlist;

import java.util.Scanner;

public class SWE_1940_가랏RC카 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int speed = 0;
			int distance = 0;
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();
				int acceleration = 0;
				if (command == 1) acceleration = sc.nextInt();
				if (command == 2) acceleration = -sc.nextInt();
				speed += acceleration;
				if(speed < 0) speed = 0;
				distance += speed;
			}
			System.out.println("#" + t + " " + distance);
		}
	}
}
