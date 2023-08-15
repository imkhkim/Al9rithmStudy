package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static int N, M;
	static char[][] arr;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<T> Q = new LinkedList<>();
		Q.add(new T(0, 0, 1));

		int dy, dx;
		while (!Q.isEmpty()) {
			T now = Q.poll();

			for (int t = 0; t < 4; t++) {
				dy = now.y + dir[t][0];
				dx = now.x + dir[t][1];

				if (dy < 0 || dx < 0 || dy >= N || dx >= M || arr[dy][dx] == '0')
					continue;

				if (dy == N - 1 && dx == M - 1) {
					return now.lv + 1;
				}

				arr[dy][dx] = '0';
				Q.add(new T(dy, dx, now.lv + 1));

			}
		}
		return 0;
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
