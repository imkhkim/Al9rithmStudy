package Seojeong._01_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class BOJ_15663 {

    static int N,M;
    static int[] arr, res;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int depth) {

        if(depth == M){
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

//        1 7 9 9
        int last = 0;
        for (int i = 0; i < N; i++) {
            if(last == arr[i]) continue;
            if(!isUsed[i]){
                isUsed[i] = true;
                res[depth] = arr[i];
                last = arr[i];
                DFS(depth+1);
                isUsed[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        arr = new int[N];
        res = new int[M];
        isUsed = new boolean[N];

        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(arr);
        DFS(0);
        System.out.println(sb);
     }
}