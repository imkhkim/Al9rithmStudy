package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			setUnion(a, b);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++)
			if (arr[i] == 0)
				answer++;

		System.out.println(answer);
	}

	private static void setUnion(int a, int b) {
		int aRoot = findRoot(a), bRoot = findRoot(b);
		if (aRoot == bRoot)
			return;

		arr[bRoot] = aRoot;
	}

	private static int findRoot(int a) {
		if (arr[a] == 0)
			return a;

		return arr[a] = findRoot(arr[a]);
	}
}