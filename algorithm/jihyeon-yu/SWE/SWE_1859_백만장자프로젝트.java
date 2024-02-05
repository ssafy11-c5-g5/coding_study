package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] price = new int[N];
			long income = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxVal = price[N - 1];
			for (int i = N - 2; i >= 0; i--) {
					if(maxVal > price[i]) {
						income += maxVal - price[i];
					}
					else {
						maxVal = price[i];
					}
			}
			
			System.out.println("#" + t + " " + income);
		}
	}

}
