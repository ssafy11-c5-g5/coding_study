import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SWEA_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<String> list = new LinkedList<>();

		String[] strs = br.readLine().split(" ");

		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}

		int k = Integer.parseInt(br.readLine());
		String[] abs = br.readLine().split("I");		// "I"를 기준으로 삽입해야할 문자열들을 나눔

		for (int i = 1; i < abs.length; i++) {			// 0번째는 공백이기 때문에 1번부터 시작
			String[] checkStrings = abs[i].split(" ");	// 삽입해야할 위치, 삽입할 갯수, 삽입할 수들을 구분 하기위해 " " 기준으로 한 번 더 나눔  
			int c = 0;
			for (int j = 3; j < checkStrings.length; j++) {		// 배열의 0번째는 공백, 1번째는 삽입할 위치 2번째는 삽입할 갯수이기 때문에 3번째부터 반복 시작
				list.add(Integer.parseInt(checkStrings[1]) + c, checkStrings[j]); 	// 삽입할 위치에 한 칸씩 늘려가며 수들을 삽입
				c++;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}

	}

}
