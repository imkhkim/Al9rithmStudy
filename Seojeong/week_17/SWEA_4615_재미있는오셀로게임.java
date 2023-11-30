package Seojeong.week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4615_재미있는오셀로게임 {
    static final int B = 1, W = 2;
    static int black, white, N, M, board[][];
    static int di[] = {-1, -1, -1, 0, 0, 1, 1, 1}, dj[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
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
            black = 0;
            white = 0;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new int[N + 1][N + 1];
            // 정가운데 돌 배치하고 시작
            initBoard();

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());

                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                // 입력받은 돌 배치
                board[i][j] = color;

                // 상대편 돌'들'을 내 돌로 만들기
                updateBoard(i, j, color);
//                print();
            }

            // 최종 흑돌, 백돌 수 카운트
            countColor();
            sb.append("#" + t + " ").append(black + " " + white).append("\n");
        }

        System.out.println(sb);
    }

    private static void countColor() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == B) black++;
                else if (board[i][j] == W) white++;
            }
        }
    }

    private static void updateBoard(int now_i, int now_j, int color) {

        Queue<Point> queue = new LinkedList<>();

        // 내가 놓은 자리 주변 8방 상대 돌 있는지 확인
        for (int d = 0; d < 8; d++) {
            int next_i = now_i + di[d];
            int next_j = now_j + dj[d];

            if (outOfBound(next_i, next_j)) continue; // 인덱스 범위 밖 건너뛰기
            if (board[next_i][next_j] == 0) continue; // 빈칸 건너뛰기
            if (board[next_i][next_j] == color) continue; // 내 돌 건너뛰기

            // 상대편 돌인 경우 그 방향으로 내 돌이 나올때까지 가보고, 내 돌이 나오면 그 사이 상대 돌 다 내 꺼~
            // 안나오면 까비~
            while (true) {
                next_i += di[d];
                next_j += dj[d];

                if (outOfBound(next_i, next_j)) break;
                if (board[next_i][next_j] == 0) break;

                // 내 돌 만났다
                if (board[next_i][next_j] == color) {
                    int i = now_i + di[d];
                    int j = now_j + dj[d];

                    while (true) {
                        if (i == next_i && j == next_j) break;
                        queue.add(new Point(i, j)); // 바꿔야 할 위치 큐에 저장
                        i += di[d];
                        j += dj[d];
                    }
                    break;
                }

            }
        }


        // 탐색 끝나고 큐에 저장해 놓은 위치들 한번에 바꾸기
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            board[p.i][p.j] = color;
        }
    }

    private static boolean outOfBound(int i, int j) {
        return i < 1 || i > N || j < 1 || j > N;
    }

    private static void print() {
        System.out.println("==========");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 0)
                    System.out.print("_ ");
                else System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initBoard() {

        board[N / 2][N / 2] = W;
        board[N / 2][N / 2 + 1] = B;
        board[N / 2 + 1][N / 2] = B;
        board[N / 2 + 1][N / 2 + 1] = W;

    }
}
