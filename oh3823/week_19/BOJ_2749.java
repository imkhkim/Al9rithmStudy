package oh3823.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_2749 {
    static long N;
    static final int MOD = 1000000;

    static int[][] b = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Long.parseLong(st.nextToken());

        if (N < 2) {
            System.out.println(1);
            return;
        }
        // b^(N-1)을 구하고 [2][1] {{1},{0}} 과 곱한 결과 res[0][0]이 n번째 피보나치 수
        int[][] res = exp(b, N - 1);
        res = multiply(res, new int[][]{{1}, {0}});
        System.out.println(res[0][0]);
    }

    static int[][] exp(int[][] M, long e) {
        if (e == 1) return M;
        int[][] m = exp(M, e >> 1);
        int[][] res = multiply(m, m);
        if ((e & 1) == 1) res = multiply(res, M);
        return res;
    }

    static int[][] multiply(int[][] A, int[][] B) {
        int N = A.length, M = B.length, L = B[0].length;
        int[][] C = new int[N][L];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                for (int k = 0; k < M; k++)
                    C[i][j] = (int) (C[i][j] + ((long) A[i][k] * (long) B[k][j]) % MOD) % MOD;
            }
        }

        return C;

    }
}

// 1000000000000000000