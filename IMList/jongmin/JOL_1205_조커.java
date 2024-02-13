package algorithm.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JOL_1205_조커 {

    static int N, cards[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cards);
        //System.out.println(Arrays.toString(cards));

        int joker = 0;
        for (int i = 0; i < N; i++) {
            if (cards[i] == 0) {
                joker++;
            }
            if (cards[i] > 0) {
                break;
            }
        }
        //System.out.println("joker Cnt: " + joker);
        System.out.println(findStraight(joker));
    }

    private static int findStraight(int joker) {
        int start = joker;
        int maxStraightLen = joker;

        for (int i = start; i < N - 1; i++) {
            int straightLen = 1;
            int jokerCnt = joker;
            int[] tempCards = cards.clone();
            for (int j = i; j < N - 1; j++) {
                if (tempCards[j + 1] - tempCards[j] == 1) {
                    straightLen++;
                } else if (tempCards[j + 1] == tempCards[j]) {

                } else {
                    if (jokerCnt > 0) {
                        jokerCnt--;
                        tempCards[j]++;
                        j--;
                        straightLen++;
                    } else {
                        break;
                    }
                }
            }
            maxStraightLen = Math.max(maxStraightLen, straightLen+jokerCnt);
        }
        return maxStraightLen;
    }
}
