package Seojeong.week_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
    static int N, M, R, C, L, map[][], count;
    static int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1}; // 상,하,좌,우
    static boolean[][] visited;

    static class Position {
        int i, j, lv;

        public Position(int i, int j, int lv) {
            this.i = i;
            this.j = j;
            this.lv = lv;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "i=" + i +
                    ", j=" + j +
                    ", lv=" + lv +
                    '}';
        }
    }

    static int[][] type = {{}, // 0
            {1, 1, 1, 1}, // 1: 상,하,좌,우
            {1, 1, 0, 0}, // 2: 상,하
            {0, 0, 1, 1}, // 3: 좌,우
            {1, 0, 0, 1}, // 4: 상,우
            {0, 1, 0, 1}, // 5: 하,우
            {0, 1, 1, 0}, // 6: 하,좌
            {1, 0, 1, 0}, // 7: 상,좌
    };
    static int[] type_bin = {0, 15, 12, 3, 9, 5, 6, 10};


    public static boolean isAvailable(Position now, Position next, int dir) {
        // now 에서 갈 수 있는 방향인지 확인
        int typeNum = map[now.i][now.j];

        // 터널이 없거나 now 터널에서 갈 수 없는 방향이면
        if (typeNum == 0 || type[typeNum][dir] == 0) return false;

        // now 에서 갔을 때 next 에서 돌아올 수 있는지 확인 (연결되어 있는지)
        return isConnected(next, dir);
    }

    public static boolean isConnected(Position next, int dir) {
        /*  now     next
         * 0(상) <-> 1(하) 00 01
         * 1(하) <-> 0(상) 01 00
         * 2(좌) <-> 3(우) 10 11
         * 3(우) <-> 2(좌) 11 10
         * */

        /* dir  p
         * 0 > 1
         * 1> 0
         * 2> 0
         * 3>0
         * */

        int typeNum = map[next.i][next.j];
        dir = dir ^ (1 << 0);
        if (typeNum == 0 || type[typeNum][dir] == 0) return false;
        return true;
    }

    public static boolean outOfBound(Position pos) {
        return pos.i < 0 || pos.i >= N || pos.j < 0 || pos.j >= M;
    }

    public static void bfs(Position start) {

        Queue<Position> queue = new LinkedList<>();

        queue.offer(start);
        visited[start.i][start.j] = true;

        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if (now.lv > L) break;
//            System.out.println(now);
            count++;
            for (int d = 0; d < 4; d++) {
                Position next = new Position(now.i + di[d], now.j + dj[d], now.lv + 1);
                if (outOfBound(next)) continue;
                if (isAvailable(now, next, d) && !visited[next.i][next.j]) {
                    queue.offer(next);
                    visited[next.i][next.j] = true;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(new Position(R, C, 1));

            sb.append("#" + t + " " + count).append('\n');
        }

        System.out.println(sb);
    }
}
