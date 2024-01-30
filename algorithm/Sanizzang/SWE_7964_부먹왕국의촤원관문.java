package Sanizzang;

import java.util.Scanner;

public class SWE_7964_부먹왕국의촤원관문 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test = 1;test <= T;test++) {
            int N = sc.nextInt(); // 도시 수
            int D = sc.nextInt(); // 이동 제한 거리
            int[] arr = new int[N]; // 지도 정보
            for(int i = 0;i < N;i++) {
                arr[i] = sc.nextInt();
            }

            int cnt = 0; // 추가 건설해야 할 차원 관문 수
            int distance = 0; // 이동한 거리
            for(int i = 0;i < N;i++) {
                distance++;
                if(arr[i] == 1) { // 차원문이 있다면 이동한 거리 0으로 초기화
                    distance = 0;
                }
                else if(arr[i] == 0 && distance == D) { // 만약 이동한 거리가 이동 제한 거리와 같고 차원문이 없다면 추가 건설 ++
                    cnt++;
                    distance = 0;
                }
            }

            System.out.println("#" + test + " " + cnt);
        }
    }
}
