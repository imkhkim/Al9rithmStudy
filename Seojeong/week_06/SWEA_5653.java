package Seojeong.week_06;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5653 {
    static int N, M, K, grid[][];
    static int[] di = {-1, 0, 0, 1}, dj = {0, -1, 1, 0};

    static class Point {
        int i, j;

        public Point(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            Queue<Point> queue = new ArrayDeque<>();
            grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();

                    if (grid[i][j] > 0)
                        queue.offer(new Point(i, j));
                }

            }

        }
    }
}
