package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759 {
	static int L, C;
	static char[] alp;
	static int[] arr;
	
	static boolean isValid() {
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < L; i++) {
			char tmp = alp[arr[i]];
			if (tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		if (cnt1 >= 1 && cnt2 >= 2) {
			return true;
		} else {
			return false;
		}
	}

	static void sol(int cur, int st) {
		if (cur == L) {
			if (isValid()) {
				for (int i = 0; i < L; i++) {
					System.out.print(alp[arr[i]]);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = st; i < C; i++) { // i는 alp의 인덱스
			arr[cur] = i;
			sol(cur + 1, i + 1);
		}
			
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		alp = new char[C];
		arr = new int[L];
		
		for (int i = 0; i < C; i++) {
			alp[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(alp);
		
		sol(0, 0);
	}
}
