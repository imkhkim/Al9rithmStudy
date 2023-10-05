package Seojeong.week_04;

import java.util.Scanner;


public class BOJ_14267 {
    static int n, m, boss[], count[];

    public static void compliment(int idx, int w) {

        if (idx < 0) {
            return;
        }

        count[idx] += w;

        for (int i = 1; i <= n; i++) {
            if (boss[i] == idx) {
                compliment(i, w);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        boss = new int[n + 1];
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boss[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int idx = sc.nextInt();
            int w = sc.nextInt();
            compliment(idx, w);
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(count[i] + " ");
        }

    }
}