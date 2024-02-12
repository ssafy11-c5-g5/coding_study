package imlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		for (int i = 0; i < arr.length; i++) {
			if (str.contains(arr[i])) {
				str = str.replace(arr[i], "0");
			}
		}
		System.out.println(str.length());
	}
}
