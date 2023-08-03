// N과 M (2)
// https://www.acmicpc.net/problem/15650

import java.util.Scanner;

public class Main {
    static int N, M;

    static int[] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        path = new int[M];

        for (int i = 1; i <= N; i++) {
            path[0] = i;
            dfs(1, i);
            path[0] = 0;
        }

    }

    private static void dfs(int lv, int now) {

        if (lv == M) {
            print();
            return;
        }

        for (int i = now + 1; i <= N; i++) {
            path[lv] = i;
            dfs(lv + 1, i);
            path[lv] = 0;
        }
    }

    private static void print() {
        for (int i = 0; i < M; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();

    }
}
