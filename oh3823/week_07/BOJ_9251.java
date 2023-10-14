package oh3823.week_07;

// LCS
// https://www.acmicpc.net/problem/9251

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_9251 {
    static char[] A, B;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        int N = A.length;
        int M = B.length;

        D = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i - 1] == B[j - 1]) {
                    D[i][j] = D[i - 1][j - 1] + 1;
                } else {
                    D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                }
            }
        }

        System.out.println(D[N][M]);
    }
}