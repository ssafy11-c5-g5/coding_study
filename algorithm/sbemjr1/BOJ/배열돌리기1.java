package sbemjr1.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {
	static int n,m,k,min,map[][];
	static int[] dr = new int[] {0,1,0,-1};
	static int[] dc = new int[] {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for (int r = 0; r < n; r++) {
    		st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Math.min(n, m);
		
		for(int i=1; i<=k; i++) {
    		rotate();
    	}
		
		print();
	}

	private static void print() {
		for(int r=0; r<n; r++) {
    		for(int c=0; c<m; c++) {
    			System.out.print(map[r][c] + " ");
    		}
    		System.out.println();
    	}
	}

	private static void rotate() {
		for (int t = 0; t < min/2; t++) {
			int x = t;
			int y = t;
			
			int tmp = map[x][y];
			
			int idx = 0;
			while(idx < 4) {
				int nx = x + dr[idx];
				int ny = y + dc[idx];
				
				if(nx < n-t && ny < m-t && nx >= t && ny >= t) {
    				map[x][y] = map[nx][ny];
    				x = nx;
    				y = ny;
    			} else {
    				idx++;
    			}
			}
			
			map[t+1][t] = tmp;
		}
	}
}
