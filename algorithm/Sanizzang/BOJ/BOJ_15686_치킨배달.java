import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class House {
    int r;
    int c;

    House(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Chicken {
    int r;
    int c;

    Chicken(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int N, M;
    static Chicken[] sel;
    static int result = Integer.MAX_VALUE;

    static House[] houses;
    static Chicken[] chickens;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new Chicken[M];

        List<House> houseList = new ArrayList<>();
        List<Chicken> chickenList = new ArrayList<>();

        for(int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    houseList.add(new House(i, j));
                }
                else if(num == 2) {
                    chickenList.add(new Chicken(i, j));
                }
            }
        }
        houses = houseList.toArray(new House[houseList.size()]);
        chickens = chickenList.toArray(new Chicken[chickenList.size()]);

        recursive(0, 0);
        System.out.println(result);
    }

    private static void recursive(int cnt, int start) {
        if(cnt == M) {
            result = Math.min(result, CalChickenStreet());
            return;
        }

        for(int i = start;i < chickens.length;i++) {
            sel[cnt] = chickens[i];
            recursive(cnt + 1, i + 1);
        }
    }

    private static int CalChickenStreet() {

        int[] chickenDistance = new int[houses.length];

        for(Chicken pos : sel) {
            int cr = pos.r;
            int cc = pos.c;
            for(int i = 0;i < houses.length;i++) {
                int hr = houses[i].r;
                int hc = houses[i].c;
                if (chickenDistance[i] == 0) {
                    chickenDistance[i] = Math.abs(cr - hr) + Math.abs(cc - hc);
                    continue;
                }
                chickenDistance[i] = Math.min(chickenDistance[i], Math.abs(cr - hr) + Math.abs(cc - hc));
            }
        }
        int chickenCity = 0;
        for (int n : chickenDistance) {
            chickenCity += n;
        }
        return chickenCity;
    }


}