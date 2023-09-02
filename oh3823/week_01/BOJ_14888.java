package oh3823.week_01;// 연산자 끼워넣기
// https://www.acmicpc.net/problem/14888

import java.util.Scanner;

public class BOJ_14888 {
    static int N;
    static int[] A;
    static int[] op;
    static boolean[] used;

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        used = new boolean[N - 1];
        op = new int[N - 1];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int index = 0;
        for (int i = 0; i < 4; i++) {
            int o = sc.nextInt();
            for (int j = 0; j < o; j++, index++)
                op[index] = i;
        }

        dfs(1, A[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int lv, int num) {
        if (lv == N) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;

            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (used[i])
                continue;
            int res = 0;
            switch (op[i]) {
                case 0:
                    res = num + A[lv];
                    break;
                case 1:
                    res = num - A[lv];
                    break;
                case 2:
                    res = num * A[lv];
                    break;
                case 3:
                    res = num / A[lv];
                    break;
            }

            used[i] = true;
            dfs(lv + 1, res);
            used[i] = false;
        }

    }
}
