import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr; //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0;j < M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0;i < R;i++) {
            int num = Integer.parseInt(st.nextToken());

            switch (num) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }

        for(int i = 0;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void one() {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length;j++) {
                temp[arr.length - i - 1][j] = arr[i][j];
            }
        }
        arr = temp;
    }

    public static void two() {
        int[][] temp = new int[arr.length][arr[0].length];
        for(int i = 0;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length;j++) {
                temp[i][arr[0].length - j - 1] = arr[i][j];
            }
        }
        arr = temp;
    }

    public static void three() {
        int[][] temp = new int[arr[0].length][arr.length];
        for(int i = 0;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length;j++) {
                temp[j][arr.length - i - 1] = arr[i][j];
            }
        }
        arr = temp;
    }

    public static void four() {
        int[][] temp = new int[arr[0].length][arr.length];
        for(int i = 0;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length;j++) {
                temp[arr[0].length - j - 1][i] = arr[i][j];
            }
        }
        arr = temp;
    }

    public static void five() {
        int[][] temp = new int[arr.length][arr[0].length];

        for(int i = 0;i < arr.length / 2;i++) {
            for(int j = 0;j < arr[0].length / 2;j++) {
                temp[i][j + arr[0].length / 2] = arr[i][j];
            }
        }

        for(int i = 0;i < arr.length / 2;i++) {
            for(int j = arr[0].length / 2;j < arr[0].length;j++) {
                temp[i + arr.length / 2][j] = arr[i][j];
            }
        }

        for(int i = arr.length / 2;i < arr.length;i++) {
            for(int j = arr[0].length / 2;j < arr[0].length;j++) {
                temp[i][j - arr[0].length / 2] = arr[i][j];
            }
        }

        for(int i = arr.length / 2;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length / 2;j++) {
                temp[i - arr.length / 2][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    public static void six() {
        int[][] temp = new int[arr.length][arr[0].length];

        for(int i = 0;i < arr.length / 2;i++) {
            for(int j = 0;j < arr[0].length / 2;j++) {
                temp[i+ arr.length / 2][j] = arr[i][j];
            }
        }

        for(int i = 0;i < arr.length / 2;i++) {
            for(int j = arr[0].length / 2;j < arr[0].length;j++) {
                temp[i][j - arr[0].length / 2] = arr[i][j];
            }
        }

        for(int i = arr.length / 2;i < arr.length;i++) {
            for(int j = arr[0].length / 2;j < arr[0].length;j++) {
                temp[i - arr.length / 2][j] = arr[i][j];
            }
        }

        for(int i = arr.length / 2;i < arr.length;i++) {
            for(int j = 0;j < arr[0].length / 2;j++) {
                temp[i][j + arr[0].length / 2] = arr[i][j];
            }
        }

        arr = temp;
    }


}