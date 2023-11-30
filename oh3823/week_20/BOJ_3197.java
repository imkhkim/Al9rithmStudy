package oh3823.week_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_3197 {
    static int R, C;
    static char[][] input;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static final int INF = 1000000007;
    static int max = 0;

    static int sy, sx, dy, dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[R][];
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            input[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
//                if (input[i][j] != 'X') map[i][j] = 0;
//                else map[i][j] = INF;
                map[i][j] = INF;
            }
        }

        checkCost();

        // ✅

        int left = 0, right = max + 1;
        int mid;

        int cost = max;
        while (left < right) {
            mid = (left + right) >> 1;
            boolean found = findSwan(mid);

            if (found) { // 찾으면 저장하고 mid를 줄여보기
                cost = mid;
                right = mid;
            } else { // 못찾으면 mid를 늘리기
                left = mid + 1;
            }
        }

        System.out.println(cost);


    }

    static boolean findSwan(int limit) {
        // limit 이하로 찾을 수 있는지 검사
        Queue<Pos> Q = new ArrayDeque<>();
        boolean[][] v = new boolean[R][C];

        Q.add(new Pos(sy, sx));
        v[sy][sx] = true;

        int di, dj;
        while (!Q.isEmpty()) {
            Pos now = Q.poll();

            for (int d = 0; d < 4; d++) {
                di = now.i + dir[d][0];
                dj = now.j + dir[d][1];
                if (di < 0 || dj < 0 || di >= R || dj >= C || map[di][dj] > limit || v[di][dj])
                    continue;

                if (di == dy && dj == dx)  // 찾음
                    return true;

                v[di][dj] = true;
                Q.add(new Pos(di, dj));
            }
        }

        return false;
    }

    static void checkCost() {
        Queue<Pos> Q = new ArrayDeque<>();
        boolean foundFirst = false;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i][j] == 'L') {
                    if (!foundFirst) {
                        sy = i;
                        sx = j;
                        foundFirst = true;
                    } else {
                        dy = i;
                        dx = j;
                    }
                }
                if (input[i][j] != 'X') {
                    Q.add(new Pos(i, j, 0));
                }
            }
        }

        int di, dj;
        while (!Q.isEmpty()) {
            Pos now = Q.poll();
            if (map[now.i][now.j] <= now.lv) continue;
            map[now.i][now.j] = now.lv;

            for (int d = 0; d < 4; d++) {
                di = now.i + dir[d][0];
                dj = now.j + dir[d][1];
                if (di < 0 || dj < 0 || di >= R || dj >= C
                        || map[di][dj] <= now.lv + 1) continue;

                Q.add(new Pos(di, dj, now.lv + 1));
            }
        }

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                max = Math.max(max, map[i][j]);

    }

    static class Pos {
        int i, j, lv;

        public Pos(int i, int j, int lv) {
            this.i = i;
            this.j = j;
            this.lv = lv;
        }

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

/*

8 17
...XXXXXX..XX.XXX
....XXXXXXXXX.XXX
...XXXXXXXXXXXX..
..XXXXX..XXXXXX..
.XXXXXX..XXXXXX..
XXXXXXX...XXXX...
..XXXXX...XXX....
....XXXXX.XXX....

 */