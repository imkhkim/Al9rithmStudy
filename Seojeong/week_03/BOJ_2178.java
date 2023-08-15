package Seojeong.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2178 {
    static int N, M;
    static int[][] maze, cnt;
    //    static boolean[][] visited;
    static int[] di = {0, 1, 0, -1}, dj = {1, 0, -1, 0};
    static Queue<Point> queue;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void bfs(int start_i, int start_j) {
        queue = new LinkedList();

        queue.offer(new Point(start_i, start_j));
//        visited[start_i][start_j] = true;
        cnt[start_i][start_j] = 1;


        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int next_i = current.x + di[d];
                int next_j = current.y + dj[d];
                if (0 <= next_i && next_i < N && 0 <= next_j && next_j < M
//                        && visited[next_i][next_j] == false
                        && cnt[next_i][next_j] == 0
                        && maze[next_i][next_j] == 1) {
                    queue.offer(new Point(next_i, next_j));
//                    visited[next_i][next_j] = true;
                    cnt[next_i][next_j] = cnt[current.x][current.y] + 1;
                }

            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;

        input = br.readLine();
        st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
//        visited = new boolean[N][M];
        cnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(line[j]));
            }
        }

        bfs(0, 0);

            System.out.println(cnt[N - 1][M - 1]);


    }
}
