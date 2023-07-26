package Seojeong._01_week;

import java.util.Scanner;
public class BOJ_15652 {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    static void DFS(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        int start = depth == 0 ? 1 : arr[depth - 1];

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            DFS(depth + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        DFS(0);
        System.out.println(sb);

    }

}
