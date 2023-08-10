package Seojeong._01_week;

import java.util.Scanner;

public class BOJ_1182 {
    static int N, S, count;
    static int[] arr, res;
    static boolean[] isUsed;

    static void DFS(int depth) {
        if (depth == N) {
            int sum = 0;
            String tmp = "";
            for (int i = 0; i < N; i++) {
                if (isUsed[i]) {
                    tmp += arr[i] + " ";
                    sum += arr[i];
                }
            }
            if (tmp.length() > 0 && sum == S) {
                count+=1;
            }
            return;
        }

        isUsed[depth] = true;
        DFS(depth + 1);
        isUsed[depth] = false;
        DFS(depth + 1);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        res = new int[N];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0);
        System.out.println(count);
    }
}

