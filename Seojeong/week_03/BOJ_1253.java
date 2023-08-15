package Seojeong.week_03;

import java.util.Scanner;
import java.util.Arrays;

public class BOJ_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] cnt = new int[N];

        Arrays.sort(A);
//		System.out.println(Arrays.toString(A));

        for (int idx = 0; idx < N; idx++) {
            int i = 0;
            int j = N - 1;

            while (true) {
                if (i >= j) {
                    break;
                }
                if (i == idx) {
                    i++;
                    continue;
                }
                if (j == idx) {
                    j--;
                    continue;
                }

//				System.out.println(A[i] + " " + A[j] + " " + A[idx]);

                if (A[i] + A[j] == A[idx]) {
                    cnt[idx] = 1;
                    break;
                }

                if (A[i] + A[j] <A[idx]) {
                    i++;

                } else if (A[i] + A[j] > A[idx]) {
                    j--;
                }
            }

        }

        int total = 0;
//		System.out.println(Arrays.toString(cnt));
        for (int c = 0; c < cnt.length; c++) {
            if (cnt[c] == 1)
                total++;
        }
        System.out.println(total);
    }

}