package sbemjr1.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {
	static int T,N,ans;
	static boolean[] v;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());

			Point[] customer = new Point[N];
			Point[] sel = new Point[N];
			v = new boolean[N];
			Point company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < N; i++) {
				customer[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			permutation(customer, sel, 0, company, home);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void permutation(Point[] customer, Point[] sel, int idx, Point company, Point home) {
		if (idx == N) {
			for (int i = 0; i < sel.length; i++) {
				int cToFirst = Math.abs(company.r - sel[0].r) + Math.abs(company.c - sel[0].c);
				int LastToH = Math.abs(home.r - sel[N-1].r) + Math.abs(home.c - sel[N-1].c);
				int LessSum = 0;
				for (int j = 0; j < N-1; j++) {
					LessSum += Math.abs(sel[j].r - sel[j+1].r) + Math.abs(sel[j].c - sel[j+1].c);
				}
				ans = Math.min(ans, LessSum+cToFirst + LastToH);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = customer[i];
				permutation(customer, sel, idx+1, company, home);
				v[i] = false;
			}
		}
	}	

}
