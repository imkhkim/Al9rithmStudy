package oh3823.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_1256 {
    static int N, M, K;

    static long[][] C = new long[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        C[0][0] = 1;
        for (int i = 1; i < 201; i++) {
            C[i][0] = 1;
            for (int j = 1; j < 201; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                if (C[i][j] > 1000000000) C[i][j] = 1000000001;
            }
        }

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (C[N + M][N] < K) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int n = N, m = M, k = K;

        long sep;
        for (int s = N + M; s > 0; s--) {
            sep = n > 0 ? C[s - 1][n - 1] : 0;
            if (k <= sep) {
                sb.append('a');
                --n;
            } else {
                sb.append('z');
                k -= sep;
                --m;
            }
        }

        System.out.println(sb);

    }

}