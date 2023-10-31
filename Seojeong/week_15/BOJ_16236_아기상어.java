package Seojeong.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ_16236_아기상어 {
    static int N, map[][];
    static int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};
    static Fish babyShark;
    static PriorityQueue<Fish> smallFish;

    static class Fish {
        int i, j, size, dist;

        public Fish(int i, int j, int size, int dist) {
            super();
            this.i = i;
            this.j = j;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Fish [i=" + i + ", j=" + j + ", size=" + size + ", dist=" + dist + "]";
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        smallFish = new PriorityQueue<>(new Comparator<Fish>() {

            @Override
            public int compare(Fish o1, Fish o2) {
                // 위, 왼쪽 우선.....
                // i,j도 비교하고,, 거리도 비교...
                int d1 = o1.dist;
                int d2 = o2.dist;

                if (d1 < d2) {
                    return d1 - d2;
                } else if (d1 > d2) {
                    return d1 - d2;
                } else {
                    if (o1.i < o2.i) {
                        return o1.i - o2.i;
                    } else if (o1.i > o2.i) {
                        return o1.i - o2.i;
                    } else {
                        if (o1.j < o2.j) {
                            return o1.j - o2.j;
                        } else {
                            return o1.j - o2.j;
                        }
                    }

                }
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    babyShark = new Fish(i, j, 2, 0);
                }
            }
        }
        System.out.println(move());

    }

    private static int move() {
        int count = 0;
        int sec = 0;

        while (true) {
            // 상어보다ㄴ 작은 물고기들 다 뽑아놓고.. 그 중에 가장 가까운애 가고

            findSmallFish();

            if (smallFish.isEmpty())
                break;
            Fish fish = smallFish.poll();
            map[fish.i][fish.j] = 0;

            sec += fish.dist;
            count++;

            if (count == babyShark.size) {
                count = 0;
                babyShark.size += 1;
            }
            babyShark.i = fish.i;
            babyShark.j = fish.j;

        }

        return sec;
    }

    private static void findSmallFish() {

        smallFish.clear();

        Queue<Fish> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(babyShark);
        map[babyShark.i][babyShark.j] = 0;
        visited[babyShark.i][babyShark.j] = true;

        while (!queue.isEmpty()) {
            Fish now = queue.poll();

            for (int d = 0; d < 4; d++) {
                Fish next = new Fish(now.i + di[d], now.j + dj[d], 0, now.dist + 1);

                if (outOfBound(next))
                    continue;
                if (visited[next.i][next.j])
                    continue;

                next.size = map[next.i][next.j];
                if (next.size > babyShark.size)
                    continue;

                visited[next.i][next.j] = true;
                queue.add(next);
                if (next.size != 0 && next.size < babyShark.size)
                    smallFish.add(next);
            }
        }

    }

    private static boolean outOfBound(Fish next) {
        return next.i < 0 || next.i > N - 1 || next.j < 0 || next.j > N - 1;
    }

}