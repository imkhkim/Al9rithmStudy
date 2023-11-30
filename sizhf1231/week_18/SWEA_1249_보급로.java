import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
 
class Solution {
    static class Pos {
        int x, y;
 
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // Pos
 
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
 
    static int N;
    static int[][] map, fuel;
 
    static void bfs() {
        Queue<Pos> Q = new ArrayDeque<>();
        fuel[0][0] = map[0][0];
        Q.add(new Pos(0, 0));
 
        while (!Q.isEmpty()) {
            Pos cur = Q.poll();
 
            for (int dir = 0; dir < 4; ++dir) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1)
                    continue;
 
                int nextFuel = fuel[cur.x][cur.y] + map[nx][ny];
 
                if (nextFuel >= fuel[nx][ny])
                    continue;
 
                Q.add(new Pos(nx, ny));
                fuel[nx][ny] = nextFuel;
            }
        }
    }
 
    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            fuel = new int[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    fuel[i][j] = Integer.MAX_VALUE;
                }
            }
 
            for (int i = 0; i < N; ++i) {
                String input = br.readLine();
                for (int j = 0; j < N; ++j) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }
 
            bfs();
 
            sb.append("#").append(test_case).append(" ").append(fuel[N - 1][N - 1]).append("\n");
        } // for test_case
 
        System.out.println(sb);
    } // main
} // class
