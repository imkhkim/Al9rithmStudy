package oh3823.week_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
	static int N, M;
	static int[] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);

		M = Integer.parseInt(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			bw.write((upperBound(B[i]) - lowerBound(B[i])) + " ");
		}

		bw.close();
	}

	static int upperBound(int value) {
		int left = 0, right = N - 1, mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (A[mid] <= value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	static int lowerBound(int value) {
		int left = 0, right = N - 1, mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (A[mid] >= value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}
