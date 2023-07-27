package Seojeong._01_week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_15663 {
    static int N, M;
    static int[] num, arr, cnt;
    static boolean[] isUsed;
    static Set<String> set = new HashSet<>();

    static void DFS(int depth) {
        if (depth == M) {
            String tmp = "";
            for (int i = 0; i < M; i++) {
                tmp += arr[i]+" ";
            }
            set.add(tmp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = num[i];
                DFS(depth + 1);
                isUsed[i] = false;
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        num = new int[N];
        arr = new int[M];
        cnt = new int[11];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        DFS(0);
        Object[] set_arr = set.toArray();
        Arrays.sort(set_arr);
        for (Object s : set_arr) {
            System.out.println(s);
        }

    }
}
