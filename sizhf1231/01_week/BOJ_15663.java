package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15663 {
	static int N;
	static int M;
	static int[] num;
	static int[] numIdx;
	static boolean[] isUsed;

	static void sol(int cur) { // cur : 현재까지 선택한 개수
		if (cur == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[numIdx[i]] + " ");
			}
			System.out.println();
			return;
		}

		int lastNum = 0;
		for (int i = 0; i < N; i++) { // i는 num의 인덱스
			if (isUsed[i] == true) continue;
			if (i > 0 && num[i] == lastNum) continue;
			
			numIdx[cur] = i;
			
			lastNum = num[i];
			isUsed[i] = true;
			sol(cur + 1);
			isUsed[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		isUsed = new boolean[N];
		numIdx = new int[M];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);

		sol(0);
	}
}
