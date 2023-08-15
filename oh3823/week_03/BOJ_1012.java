package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int M, N, K;
	static int[][] arr;
	static int[][] visited;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visited = new int[M][N];

			int m, n;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				m = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				arr[m][n] = 1;
			}

			int answer = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && visited[i][j] == 0) {
						bfs(i, j);
						answer++;
					}
				}
			}

			System.out.println(answer);
		}
	}

	private static void bfs(int y, int x) {
		Queue<T> Q = new LinkedList<>();
		Q.add(new T(y, x, 0));
		visited[y][x] = 1;

		int dy, dx;
		while (!Q.isEmpty()) {
			T now = Q.poll();

			for (int t = 0; t < 4; t++) {
				dy = now.y + dir[t][0];
				dx = now.x + dir[t][1];
				if (dy < 0 || dx < 0 || dy >= M || dx >= N || arr[dy][dx] == 0 || visited[dy][dx] == 1)
					continue;

				visited[dy][dx] = 1;
				Q.add(new T(dy, dx, now.lv + 1));
			}
		}
	}

	static class T {
		int y, x, lv;

		public T(int y, int x, int lv) {
			super();
			this.y = y;
			this.x = x;
			this.lv = lv;
		}

	}
}