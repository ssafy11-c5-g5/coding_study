package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static int N,M,map[][],arr[],sel[],sum,min;
	static ArrayList<ArrayList<Integer>> d;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		d = new ArrayList<>();
		
		for (int i = 0; i < 2*N*13; i++) {
			d.add(new ArrayList<Integer>());
		}
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
				
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					for (int nr = 0; nr < N; nr++) {
						for (int nc = 0; nc < N; nc++) {
							if (map[nr][nc] == 2) {
								d.get(cnt).add(Math.abs(nr-r)+Math.abs(nc-c));
							}
						}
					}
					cnt++;
				}
			}
		}
		
		arr = new int[d.get(0).size()];
		sel = new int[M];
		for (int i = 0; i < d.get(0).size(); i++) {
			arr[i] = i;
		}

		sum = 0;
		min = Integer.MAX_VALUE;
		result = new int[d.size()];
		combination(0,0);
		
		System.out.println(min);
	}

	private static void combination(int idx, int k) {
		if(k == sel.length) {
			sum = 0;
			result = new int[d.size()];
			for (int i = 0; i < d.size(); i++) {
				result[i] = Integer.MAX_VALUE;
			}
			cal();
			return;
		}
		if(idx == arr.length) {
			return;
		}
		
		sel[k] = arr[idx];
		combination(idx+1, k+1);
		combination(idx+1, k);
	}

	private static void cal() {
		for (int j = 0; j < sel.length; j++) {
			for (int r = 0; r < d.size(); r++) {
				for (int i = 0; i < d.get(0).size(); i++) {
					if (i == sel[j] && !d.get(r).isEmpty()) {
						if (result[r] > d.get(r).get(i)) {
							result[r] = d.get(r).get(i);
						}
					}
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] == Integer.MAX_VALUE) {
				break;
			}
			sum += result[i];
		}
		min = Math.min(min, sum);
	}

}
