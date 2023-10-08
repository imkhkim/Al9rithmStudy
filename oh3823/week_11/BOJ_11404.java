package oh3823.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {
    static int N, M;
    static int[][] arr;
    static final int INF = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s, d, cost;
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            arr[s][d] = Math.min(arr[s][d], cost);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print((arr[i][j] == INF ? 0 : arr[i][j]) + " ");
            }
            System.out.println();
        }

    }
}