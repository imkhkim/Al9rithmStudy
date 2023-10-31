package Seojeong.week_13;

import java.util.Scanner;

public class BOJ_10422_괄호 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int MOD = 1000000007;
        int[] L = new int[T + 1];
        int maxL = Integer.MIN_VALUE;

        for (int i = 1; i <= T; i++) {
            L[i] = sc.nextInt();
            maxL = Math.max(maxL, L[i]);
        }

        long[] dp = new long[maxL / 2 + 1]; // 짝수만 저장할거야
        dp[0] = dp[1] = 1;
        for (int p = 2; p < dp.length; p++) { // i는 2로 나눈 몫
            for (int j = 0; j < p; j++) {
//                System.out.println(p + " " + j + " " + (p - 1 - j));
                dp[p] += dp[j] * dp[p - 1 - j];
                dp[p] %= MOD;
            }
        }
//        System.out.println(Arrays.toString(dp));
        for (int i = 1; i <= T; i++) {
            if (L[i] % 2 != 0)
                sb.append(0).append("\n");
//                System.out.println(0);
            else
                sb.append(dp[L[i] / 2]).append("\n");
//                System.out.println(dp[L[i] / 2]);
        }
        System.out.println(sb);


//        int L;
//        int[] dp = new int[5001];
//
//        dp[0] = dp[2] = 1;
//        for (int i = 4; i <= 50; i += 2) { // i는 2로 나눈 몫
//            for (int j = 0; j <= i - 2; j += 2) {
//                System.out.println(i + " " + j + " " + (i - 2 - j));
//                dp[i] += dp[j] * dp[i - 2 - j];
//                dp[i] %= MOD;
//            }
//        }
//
//        for (int i = 1; i <= T; i++) {
//            L = sc.nextInt();
//            if (L % 2 != 0) System.out.println(0);
//            else System.out.println(dp[L]);
//        }

    }
}




/*

ex) L = 6
p=3 (_)(_)(_)
p=2 (_)(_)
p=1 (_)
_ 자리에 괄호 L/2-p쌍 넣는 경우의 수

L(0) = dp[0] = 1
L(2) = dp[1] = 1
L(4) = L(0)*L(2) + L(2)*L(0) =  2
L(6) = L(0)*L(4) + L(2)*L(2) + L(4)*L(0) = 5
L(8) = L(0)*L(6) + L(2)*L(4) + L(4)*L(2) + L(6)*L(0) = 14
* */