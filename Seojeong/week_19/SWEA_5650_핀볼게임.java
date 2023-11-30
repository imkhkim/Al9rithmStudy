package Seojeong.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5650_핀볼게임 {
    static final int OPPOSITE = 11, RIGHT_ANGLE = 12;
    static int N, map[][], maxScore;
    static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1}; // 상, 우, 하, 좌
    static ArrayList<Point> wormhole;

    static class Point {
        int i, j, dir;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Point(int i, int j, int dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", dir=" + dir +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            maxScore = Integer.MIN_VALUE;
            wormhole = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 웜홀인 경우
                    if (6 <= map[i][j] && map[i][j] <= 10) {
                        wormhole.add(new Point(i, j));
                    }
                }
            }

            simulation();

            sb.append("#" + t + " ").append(maxScore).append("\n");
        }

        System.out.println(sb);
    }

    private static void simulation() {
        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 빈칸에서 출발
                if (map[i][j] == 0) {
                    // 출발 위치에서 사방으로 출발해보기
                    for (int d = 0; d < 4; d++) {
                        score = gameStart(new Point(i, j), d);
                    }
                }
            }
        }

        maxScore = Math.max(score, maxScore);
    }

    private static int gameStart(Point start, int dir) {
        int score = 0;

        Point now = new Point(start.i, start.j);

        while (true) {
            Point next = new Point(now.i + di[dir], now.j + dj[dir]);
            System.out.println(next);
            //  벽 만나면 방향 반대로
            if (isWall(next)) {
                score++;
                dir = changeDir(next, dir, OPPOSITE);
                continue;
            }

            // 게임 종료 조건 : 블랙홀 만나거나 출발 위치로 돌아오면
            if (map[next.i][next.j] == -1) break;
            if (next.i == start.i && next.j == start.j) break;

            // 빈칸이면 그냥 이동
            if (map[next.i][next.j] == 0) {
                now.i = next.i;
                now.j = next.j;
                continue;
            }

            // 블록 만나면 진행 방향 바꿔서 이동
            if (1 <= map[next.i][next.j] && map[next.i][next.j] <= 5) {
                score++;

                // 경사면 만나는지 아닌지 알아오기
                boolean isIncline = checkIncline(next, dir);

                if (isIncline) // 경사면 만난 경우
                {
                    dir = changeDir(next, dir, RIGHT_ANGLE);
                    now.i = next.i;
                    now.j = next.j;
                    continue;
                } else // 수평면 or 수직면 만난 경우
                    dir = changeDir(next, dir, OPPOSITE);
            }


            // 웜홀 만나면 짝 웜홀로 이동
            if (6 <= map[next.i][next.j] && map[next.i][next.j] <= 10) {
                // 짝 웜홀 찾고 이동, 방향 유지
                Point pair = getPair(next);
                next.i = pair.i;
                next.j = pair.j;
            }


        }

        return score;
    }

    private static boolean checkIncline(Point p, int dir) {

        //  블록 모양에 따라....
        int blockType = map[p.i][p.j];

        switch (blockType) {
            case 1:
                if (dir == 2 || dir == 3) return true;
                else return false;
            case 2:
                if (dir == 0 || dir == 3) return true;
                else return false;
            case 3:
                if (dir == 0 || dir == 1) return true;
                else return false;
            case 4:
                if (dir == 1 || dir == 2) return true;
                else return false;
            case 5:
                return false;
        }

        return false;
    }

    private static Point getPair(Point now) {

        for (int i = 0; i < wormhole.size(); i++) {
            Point w = wormhole.get(i);
            // 위치는 다르고(내가 아니고), 동일한 숫자를 가진 웜홀이면
            if (now.i != w.i && now.j != w.j && map[now.i][now.j] == map[w.i][w.j]) {
                return w;
            }
        }
        return null;
    }

    private static int changeDir(Point now, int dir, int type) {

        if (type == OPPOSITE) {
            switch (dir) {
                case 0: // 상
                    return 2;
                case 1: // 우
                    return 3;
                case 2: // 하
                    return 0;
                case 3: // 좌
                    return 1;
            }
        } else if (type == RIGHT_ANGLE) {
            switch (dir) {
                case 0: // 상
                    return 1;
                case 1: // 우
                    return 2;
                case 2: // 하
                    return 3;
                case 3: // 좌
                    return 0;
            }
        }

        return dir;
    }

    private static boolean isWall(Point p) {
        return p.i < 0 || p.i > N - 1 || p.j < 0 || p.j > N - 1;
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
