package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5567 {
	static int N, M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}

		// TODO: 최단거리 구하는 방식으로 풀어보기

		int answer = 0;
		int[] d = new int[N + 1];
		for (int i = 1; i <= N; i++)
			d[i] = arr[1][i] == 0 ? N + 1 : arr[1][i];
		d[1] = 0;
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;

		for (int i = 2; i <= N; i++) {
			int next = findNext(visited, d);
			if (next == -1)
				break;
			visited[next] = true;
			for (int j = 1; j <= N; j++) {
				if (arr[next][j] == 0)
					continue;
				if (d[j] > d[next] + 1)
					d[j] = d[next] + 1;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (d[i] <= 2)
				answer++;
		}

		System.out.println(answer);
	}

	static int findNext(boolean[] visited, int[] d) {
		int min = N, mini = -1;
		for (int i = 2; i <= N; i++) {
			if (visited[i])
				continue;
			if (min > d[i]) {
				min = d[i];
				mini = i;
			}
		}

		return mini;
	}
}
