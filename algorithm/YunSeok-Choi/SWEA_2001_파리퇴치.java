import java.util.Scanner;

class SWEA_2001_파리퇴치 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {      // 입력
                map[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i <= n - m; i++) {          //  맵 크기에서 파리채의 크기를 뺀 만큼 반복하여 배열 크기를 벗어나지 않게 설정
            for (int j = 0; j <= n - m; j++) {
                int sum = 0;
                for (int j2 = i; j2 < m + i; j2++) {    // 파리채 크기 만큼 파리 잡기
                    for (int k = j; k < m + j; k++) {
                        sum += map[j2][k];
                    }
                }
                res = Math.max(res, sum);
            }
        }

        System.out.println(res);


    }
}