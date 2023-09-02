package oh3823.week_01;// N-Queen
// https://www.acmicpc.net/problem/9663

import java.util.Scanner;

public class BOJ_9663 {
    static int N;
    static boolean[] col, diagL, diagR;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        col = new boolean[N];
        diagL = new boolean[N * 2 - 1];
        diagR = new boolean[N * 2 - 1];

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int lv) {
        if (lv == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (col[i] || diagL[lv - i + N - 1] || diagR[lv + i])
                continue;
            col[i] = true;
            diagL[lv - i + N - 1] = true;
            diagR[lv + i] = true;
            dfs(lv + 1);
            col[i] = false;
            diagL[lv - i + N - 1] = false;
            diagR[lv + i] = false;
        }
    }

}
