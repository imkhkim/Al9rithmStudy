package oh3823.week_18;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_1249 {
    static char[][] input;
    static int[][] map;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, dy, dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            input = new char[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    map[i][j] = 999999;
                }

            map[0][0] = 0;

            for (int i = 0; i < N; i++)
                input[i] = br.readLine().toCharArray();


            dfs(0, 0);

            answer = map[N - 1][N - 1];

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int y, int x) {
        for (int t = 0; t < 4; t++) {
            dy = y + dir[t][0];
            dx = x + dir[t][1];

            if (dy < 0 || dx < 0 || dy >= N || dx >= N) continue;

            if (map[dy][dx] > map[y][x] + input[dy][dx] - '0') {
                map[dy][dx] = map[y][x] + input[dy][dx] - '0';
                dfs(dy, dx);
            }
        }
    }
}