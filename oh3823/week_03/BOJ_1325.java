package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
	static int N, M;
	static ArrayList<Integer>[] map;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];
		count = new int[N + 1];

		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			map[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			count[i] = bfs(i);
		}

		printAnswer();
	}

	static int bfs(int start) {
		int[] visited = new int[N + 1];
		visited[start] = 1;

		int cnt = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(start);

		while (!Q.isEmpty()) {
			int now = Q.poll();

			for (int child : map[now]) {
				if (visited[child] == 1)
					continue;

				visited[child] = 1;

				cnt++;
				Q.add(child);

//				if (count[child] != 0) {
//					cnt += count[child];
//				} else {
//					cnt++;
//					Q.add(child);
//				}
			}
		}

		return cnt + 1;
	}

	static void printAnswer() {
		int max = 0;
		ArrayList<Integer> indices = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] > max) {
				max = count[i];
				indices.clear();
				indices.add(i);
			} else if (count[i] == max) {
				indices.add(i);
			}
		}

		for (int i : indices)
			System.out.print(i + " ");
	}
}