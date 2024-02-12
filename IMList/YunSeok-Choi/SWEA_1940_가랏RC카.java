
import java.util.Scanner;

class SWEA_1940_가랏RC카 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int ditance = 0;
            int speed = 0;

            for (int i = 0; i < n; i++) {
                int command = sc.nextInt();

                if (command != 0) {
                    int pSpeed = sc.nextInt();
                    if (command == 1) {
                        speed += pSpeed;
                        ditance += speed;
                    } else if (command == 2) {
                        speed -= pSpeed;
                        if (speed <= 0) {
                            speed = 0;
                        }
                        ditance += speed;
                    }
                } else {
                    ditance += speed;
                }

            }

            System.out.println("#" + test_case + " " + ditance);
        }
    }
}