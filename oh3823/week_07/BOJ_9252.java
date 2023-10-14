package oh3823.week_07;

// LCS 2
// https://www.acmicpc.net/problem/9252

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_9252 {
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

        StringBuilder sb = new StringBuilder();
        int len = D[N][M];
        int i = N, j = M;

        for (int t = 0; t < len; t++) {
            while (D[i - 1][j] == D[i][j] || D[i][j - 1] == D[i][j]) {
                if (D[i - 1][j] == D[i][j]) --i;
                else if (D[i][j - 1] == D[i][j]) --j;
            }
            sb.append(A[i - 1]);
            --i;
            --j;
        }


        System.out.println(len);
        System.out.println(sb.reverse());
    }
}