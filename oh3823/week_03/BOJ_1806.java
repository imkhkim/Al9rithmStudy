package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int i = 0, j = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;

		while (j < N) {
			while (j < N && sum < S)
				sum += arr[j++];

			while (sum >= S) {
				answer = Math.min(j - i, answer);
				sum -= arr[i++];
			}

			if (j < N)
				sum += arr[j++];
		}

		while (i < N && sum >= S) {
			answer = Math.min(N - i, answer);
			sum -= arr[i++];
		}

		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
