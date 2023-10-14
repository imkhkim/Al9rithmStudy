package oh3823.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_10422 {

    final static int MOD = 1000000007;
    static long[] D = new long[5001], U = new long[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        D[0] = 1;
        for (int i = 2; i <= 5000; i += 2) {
            U[i] = D[i - 2];
            for (int j = 2; j <= i; j += 2) {
                D[i] = (D[i] + (U[j] * D[i - j]) % MOD) % MOD;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(((n & 1) == 1) ? 0 : D[n]);
        }


    }
}