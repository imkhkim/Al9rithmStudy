package oh3823.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_1520 {
    static int N, M;
    static int[][] arr, d;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        d = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);

        System.out.println(answer);
    }

    static int dfs(int i, int j) {
        if (i == N - 1 && j == M - 1) return 1;

        if (d[i][j] != -1) return d[i][j];

        d[i][j] = 0;

        int di, dj;
        for (int t = 0; t < 4; t++) {
            di = i + dir[t][0];
            dj = j + dir[t][1];

            if (di < 0 || dj < 0 || di >= N || dj >= M) continue;
            if (arr[di][dj] < arr[i][j]) {
                d[i][j] += dfs(di, dj);
            }
        }

        return d[i][j];

    }
}