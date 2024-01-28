import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {

    static class Car {
        int y;
        int x;
        String direction;

        Car(int y, int x, String direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }

    static Car car = null;
    static int H = 0;
    static int W = 0;
    static String[][] map = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();
        map = new String[H][W];

        for (int i = 0; i < H; i++) {
            String[] width = sc.next().split("");
            for (int j = 0; j < W; j++) {
                map[i][j] = width[j];
                if (map[i][j].equals("<")) {
                    car = new Car(i, j, "L");
                    map[i][j] = ".";
                } else if (map[i][j].equals(">")) {
                    car = new Car(i, j, "R");
                    map[i][j] = ".";
                } else if (map[i][j].equals("v")) {
                    car = new Car(i, j, "D");
                    map[i][j] = ".";
                } else if (map[i][j].equals("^")) {
                    car = new Car(i, j, "U");
                    map[i][j] = ".";
                }
            }
        }

        int n = sc.nextInt();
        String[] N = sc.next().split("");

        for (int i = 0; i < n; i++) {
            switch (N[i]) {
                case "U":
                    car.direction = "U";
                    if (checkSide("U")) {
                        car.y--;
                    }
                    break;
                case "D":
                    car.direction = "D";
                    if (checkSide("D")) {
                        car.y++;
                    }
                    break;
                case "L":
                    car.direction = "L";
                    if (checkSide("L")) {
                        car.x--;
                    }
                    break;
                case "R":
                    car.direction = "R";
                    if (checkSide("R")) {
                        car.x++;
                    }
                    break;
                case "S":
                    switch (car.direction) {
                        case "U":
                            for (int j = car.y; j >= 0; j--) {
                                if (map[j][car.x].equals("*")) {
                                    map[j][car.x] = ".";
                                    break;
                                } else if(map[j][car.x].equals("#")) {
                                    break;
                                }
                            }
                            break;
                        case "D":
                            for (int j = car.y; j < H; j++) {
                                if (map[j][car.x].equals("*")) {
                                    map[j][car.x] = ".";
                                    break;
                                } else if(map[j][car.x].equals("#")) {
                                    break;
                                }
                            }
                            break;
                        case "L":
                            for (int j = car.x; j >= 0; j--) {
                                if (map[car.y][j].equals("*")) {
                                    map[car.y][j] = ".";
                                    break;
                                } else if(map[car.y][j].equals("#")) {
                                    break;
                                }
                            }
                            break;
                        case "R":
                            for (int j = car.x; j < W; j++) {
                                if (map[car.y][j].equals("*")) {
                                    map[car.y][j] = ".";
                                    break;
                                } else if(map[car.y][j].equals("#")) {
                                    break;
                                }
                            }
                            break;
                    }
                    break;
            }
        }

        if (car.direction.equals("U")) {
            map[car.y][car.x] = "^";
        } else if (car.direction.equals("D")) {
            map[car.y][car.x] = "v";
        } else if (car.direction.equals("L")) {
            map[car.y][car.x] = "<";
        } else if (car.direction.equals("R")) {
            map[car.y][car.x] = ">";
        }

        // 출력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    static boolean checkSide(String direct) {
        if (direct.equals("R") && (car.x + 1 < W)) {
            if (!isBlock("R")) {
                return true;
            }
        } else if (direct.equals("L") && (car.x - 1 >= 0)) {
            if (!isBlock("L")) {
                return true;
            }
        } else if (direct.equals("U") && (car.y - 1 >= 0)) {
            if (!isBlock("U")) {
                return true;
            }
        } else if (direct.equals("D") && (car.y + 1 < H)) {
            if (!isBlock("D")) {
                return true;
            }
        }

        return false;
    }

    static boolean isBlock(String direct) {
        switch (direct) {
            case "U":
                int uy = car.y - 1;
                int ux = car.x;
                if (map[uy][ux].equals("*") || map[uy][ux].equals("#") || map[uy][ux].equals("-"))
                    return true;
                break;
            case "D":
                int dy = car.y + 1;
                int dx = car.x;
                if (map[dy][dx].equals("*") || map[dy][dx].equals("#") || map[dy][dx].equals("-"))
                    return true;
                break;
            case "L":
                int ly = car.y;
                int lx = car.x - 1;
                if (map[ly][lx].equals("*") || map[ly][lx].equals("#") || map[ly][lx].equals("-"))
                    return true;
                break;
            case "R":
                int ry = car.y;
                int rx = car.x + 1;
                if (map[ry][rx].equals("*") || map[ry][rx].equals("#") || map[ry][rx].equals("-"))
                    return true;
                break;
        }
        return false;
    }

}
