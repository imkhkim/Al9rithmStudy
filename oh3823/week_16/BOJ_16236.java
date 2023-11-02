package oh3823.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_16236 {
    static int N;
    static int[][] arr = new int[20][20];
    static int si, sj, size = 2, cnt;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    si = i;
                    sj = j;
                    arr[i][j] = 0;
                }
            }
        }

        int answer = 0;
        while (true) {
            List<Pos> eatable = bfs();
            if (eatable.isEmpty())
                break;

            Pos fish = eatable.get(0);
            arr[fish.i][fish.j] = 0;

            cnt++;
            if (cnt == size) {
                cnt = 0;
                size++;
            }
            answer += fish.lv;
            si = fish.i;
            sj = fish.j;
        }

        System.out.println(answer);

    }

    static List<Pos> bfs() {
        Queue<Pos> Q = new LinkedList<>();
        List<Pos> eatable = new LinkedList<>();
        boolean[][] v = new boolean[20][20];
        Q.add(new Pos(si, sj, 0));
        v[si][sj] = true;

        while (!Q.isEmpty()) {
            Pos now = Q.poll();

            int di, dj;
            for (int t = 0; t < 4; t++) {
                di = now.i + dir[t][0];
                dj = now.j + dir[t][1];
                if (di < 0 || dj < 0 || di >= N || dj >= N || v[di][dj] || size < arr[di][dj]) continue;
                v[di][dj] = true;
                Pos d = new Pos(di, dj, now.lv + 1);

                if (size > arr[di][dj] && arr[di][dj] > 0) {
                    eatable.add(d);
                }
                Q.add(d);
            }
        }

        eatable.sort((a, b) -> a.lv == b.lv ? (a.i == b.i ? a.j - b.j : a.i - b.i) : a.lv - b.lv);
        return eatable;
    }

    static class Pos {
        int i, j, lv;

        public Pos(int i, int j, int lv) {
            this.i = i;
            this.j = j;
            this.lv = lv;
        }
    }
}