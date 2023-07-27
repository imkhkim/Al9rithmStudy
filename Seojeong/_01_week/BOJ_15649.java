package Seojeong._01_week;

import java.util.Scanner;

public class BOJ_15649 {
    public static int N,M;
    public static int[] arr;
    public static boolean[] isUsed;
    public static StringBuilder sb = new StringBuilder();

    static void DFS(int depth){
        if (depth == M){
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!isUsed[i]){
                isUsed[i] = true;
                arr[depth]=i+1;
                DFS(depth+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        isUsed = new boolean[N];

        DFS(0);
        System.out.println(sb);
    }
}

