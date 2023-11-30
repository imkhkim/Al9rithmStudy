package oh3823.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ_2933 {
    static int R, C, N;
    static char[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        int r, c;
        st = new StringTokenizer(br.readLine(), " ");
        for (int round = 0; round < N; round++) {
            r = Integer.parseInt(st.nextToken());
            r = R - r;
            c = -1;
            ArrayList<ArrayList<Pos>> clusters = new ArrayList<>(); // 파괴 후 파괴지점 4방의 클러스터 목록

            if ((round & 1) == 0) { // 짝수면 ->
                for (int j = 0; j < C; j++) {
                    if (map[r][j] == 'x') {
                        map[r][j] = '.';
                        c = j;
                        break;
                    }
                }
            } else { // 홀수면 <-
                for (int j = C - 1; j >= 0; j--) {
                    if (map[r][j] == 'x') {
                        map[r][j] = '.';
                        c = j;
                        break;
                    }
                }
            }

            if (c == -1) continue;

            int di, dj;
            boolean[][] v = new boolean[R][C];

            for (int t = 0; t < 4; t++) {
                di = r + dir[t][0];
                dj = c + dir[t][1];
                if (di < 0 || dj < 0 || di >= R || dj >= C || map[di][dj] == '.' || v[di][dj]) continue;
                ArrayList<Pos> cluster = getClusterList(di, dj, v);
                clusters.add(cluster);
            }

            if (clusters.size() > 1) { // 분리됨
                for (ArrayList<Pos> cluster : clusters) {
                    int[] floor = new int[C]; // 클러스터 각 열의 바닥 높이를 저장
                    Arrays.fill(floor, -1);

                    for (Pos mineral : cluster)
                        floor[mineral.j] = Math.max(floor[mineral.j], mineral.i);

                    boolean fall = true;
                    for (int i = 0; i < floor.length; i++) {
                        if (floor[i] == -1) continue;

                        // 바닥이거나 아래에 클러스터가 있으면 이 클러스터는 떨어지지 않으므로 다음 클러스터 확인
                        if (floor[i] + 1 == R || map[floor[i] + 1][i] == 'x') {
                            fall = false;
                            break;
                        }
                    }

                    if (!fall) continue; // 떨어지지 않는 클러스터이므로 다음 클러스터 확인

                    // 떨어지는 클러스터를 처리 후 클러스터 탐색 중지

                    // floor[c]에는 c열에서 바닥(혹은 다른 클러스터)까지의 거리를 계산

                    int falls = R; // 떨어질 칸의 수
                    for (int j = 0; j < C; j++) {
                        int count = 0;
                        if (floor[j] == -1) continue;

                        for (int i = floor[j] + 1; i < R; i++) {
                            if (map[i][j] == 'x') break;
                            count++;
                        }
                        falls = Math.min(falls, count);
                    }

                    fallCluster(cluster, falls);
                    break;
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                sb.append(map[i][j]);
            sb.append("\n");
        }


        System.out.println(sb);
    }

    private static void fallCluster(ArrayList<Pos> cluster, int falls) {
        cluster.sort((p1, p2) -> p1.i == p2.i ? p1.j - p2.j : p2.i - p1.i);
        for (Pos mineral : cluster) {
            map[mineral.i][mineral.j] = '.';
            map[mineral.i + falls][mineral.j] = 'x';
        }
    }

    static ArrayList<Pos> getClusterList(int si, int sj, boolean[][] v) {
        ArrayList<Pos> minerals = new ArrayList<>();

        Queue<Pos> Q = new LinkedList<>();
        v[si][sj] = true;
        Q.add(new Pos(si, sj));

        int di, dj;
        while (!Q.isEmpty()) {
            Pos now = Q.poll();
            minerals.add(now);
            for (int t = 0; t < 4; t++) {
                di = now.i + dir[t][0];
                dj = now.j + dir[t][1];
                if (di < 0 || dj < 0 || di >= R || dj >= C || map[di][dj] == '.' || v[di][dj]) continue;
                v[di][dj] = true;
                Q.add(new Pos(di, dj));
            }
        }
        return minerals;
    }

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}