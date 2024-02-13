package imlist;

import java.util.Scanner;

public class BOJ_2991_사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int[] person = new int[3];
		for (int i = 0; i < 3; i++) {
			person[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 3; i++) {
			int dog1 = person[i] % (A + B);
			int dog2 = person[i] % (C + D);
			int attackDog = 0;
			if(dog1 > 0 && dog1 <= A) attackDog++;
			if(dog2 > 0 && dog2 <= C) attackDog++;
			System.out.println(attackDog);
		}
		
	}

}
