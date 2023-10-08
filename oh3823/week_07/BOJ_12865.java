package oh3823.week_07;

// 평범한 배낭
// https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_12865 {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        D = new int[N + 1][K + 1];
        int w, v;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K; j++) {
                D[i][j] = D[i - 1][j];
                if (j >= w && D[i - 1][j - w] + v > D[i][j]) {
                    D[i][j] = D[i - 1][j - w] + v;
                }
            }
        }

        System.out.println(D[N][K]);
    }
}