package BOJ;

import java.util.Scanner;

public class BOJ_1182 {
	static int N, S, cnt;
	static int[] num = new int[20];
	
	static void sol(int cur, int sum) {
		if (cur == N) {
			if (sum == S) cnt++;
			return;
		}
		
		sol(cur + 1, sum);
		sol(cur + 1, sum + num[cur]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		sol(0, 0);
		
		if (S == 0) cnt--;
		
		System.out.println(cnt);
	} // main
}
