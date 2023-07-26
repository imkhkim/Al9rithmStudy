package Seojeong._01_week;

import java.util.Scanner;

public class BOJ_15651 {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    static void DFS(int depth){
        if (depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N ; i++) {
            arr[depth] = i;
            DFS(depth+1);
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
