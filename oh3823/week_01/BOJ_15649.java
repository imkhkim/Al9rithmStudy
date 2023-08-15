package oh3823.week_01;// N과 M (1)
// https://www.acmicpc.net/problem/15649

import java.util.Scanner;

public class BOJ_15649 {
    static int N, M;

    static int[] path;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        path = new int[M];
        used = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            path[0] = i;
            used[i] = true;
            dfs(1);
            used[i] = false;
            path[0] = 0;
        }
    }

    static void dfs(int lv) {
        if (lv == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i])
                continue;
            used[i] = true;
            path[lv] = i;
            dfs(lv + 1);
            used[i] = false;
            path[lv] = 0;
        }
    }
}
