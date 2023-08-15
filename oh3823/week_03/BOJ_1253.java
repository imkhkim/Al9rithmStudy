package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int selected, i, j;
		for (int t = 0; t < N; t++) {
			selected = arr[t];

			i = 0;
			j = N - 1;
			while (i < j) {
				if (i == t)
					++i;
				if (j == t)
					--j;
				if (i == j)
					break;

				if (arr[i] + arr[j] == selected) {
					++answer;
					break;
				} else if (arr[i] + arr[j] > selected)
					--j;
				else
					++i;

			}
		}

		System.out.println(answer);
	}
}
