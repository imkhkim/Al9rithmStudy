package oh3823.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
    static int N, M, R, C, L;
    static int[][] arr;

    // N : 지하터널 지도 세로
    // M : 지하터널 지도 가로
    // (R, C) : 맨홀의 좌표,
    // L : 탈출 후 소요된 시간

    static int[][][] D = {{},
            // 우 하 좌 상
            {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, {{0, 0}, {1, 0}, {0, 0}, {-1, 0}},
            {{0, 1}, {0, 0}, {0, -1}, {0, 0}}, {{0, 1}, {0, 0}, {0, 0}, {-1, 0}},
            {{0, 1}, {1, 0}, {0, 0}, {0, 0}}, {{0, 0}, {1, 0}, {0, -1}, {0, 0}},
            {{0, 0}, {0, 0}, {0, -1}, {-1, 0}}};

    static int[] type = {0, 15, 10, 5, 9, 3, 6, 12};
    // type[i]는 i 터널 기준으로 4방에서 올 수 있는 방향을 비트로 저장
    // 4자리의 비트이고 자리수가 큰 순서대로 위, 왼쪽, 아래, 오른쪽 방향을 의미함
    // 예시로 type[2]는 1010이고, 위, 아래에서 올 수 있는 터널임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; ++tc) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; ++j) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs(R, C);
            System.out.println("#" + tc + " " + answer);

        }

    }

    static int bfs(int startI, int startJ) {
        Queue<Pos> Q = new LinkedList<>();
        Q.add(new Pos(startI, startJ, 0));

        int[][] visited = new int[N][M];
        visited[startI][startJ] = 1;

        int count = 0;
        int di, dj, reverse;
        int[][] dir;
        while (!Q.isEmpty()) {
            Pos now = Q.poll();
            if (now.lv == L)
                break;

            ++count;
            dir = D[arr[now.i][now.j]];
            for (int d = 0; d < 4; d++) {
                di = now.i + dir[d][0];
                dj = now.j + dir[d][1];

                if (di < 0 || dj < 0 || di >= N || dj >= M || arr[di][dj] == 0 || visited[di][dj] == 1)
                    continue;

                reverse = 1 << (d ^ 2);
                if ((type[arr[di][dj]] & reverse) != 0) {
                    visited[di][dj] = 1;
                    Q.add(new Pos(di, dj, now.lv + 1));
                }

            }
        }

        return count;

    }

    static class Pos {
        int i, j, lv;

        public Pos(int i, int j, int lv) {
            super();
            this.i = i;
            this.j = j;
            this.lv = lv;
        }
    }
}