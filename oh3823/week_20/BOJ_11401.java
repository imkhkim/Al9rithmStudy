package oh3823.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_11401 {
    static int N, K;
    static final int MOD = 1000000007;

    static long[] F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        F = new long[N + 1];
        F[0] = 1;

        for (int i = 1; i <= N; i++)
            F[i] = (F[i - 1] * i) % MOD;

        System.out.println((F[N] * exp(F[K] * F[N - K] % MOD, MOD - 2)) % MOD);

    }

    static long exp(long n, int e) {
        if (e == 1) return n;
        long m = exp(n, e >> 1);
        return (((m * m) % MOD) * ((e & 1) == 1 ? n : 1)) % MOD;
    }
}