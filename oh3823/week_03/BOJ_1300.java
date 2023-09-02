package oh3823.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1300 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

//		for (K = 1; K <= N * N; K++) {
		long left = 1, right = Math.min(1000000000, (long) N * (long) N);
		long mid, order;
		long _mid, num;
		while (left <= right) {
			mid = (left + right) >> 1;
			_mid = mid * 2;
			order = 0;
			for (int i = 1; i <= N; i++) {
				num = Math.min((mid - 1) / i, N);
				order += num;
				_mid = Math.min(_mid, i * (num + 1));
			}
			if (order < K) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
//		}
	}

}