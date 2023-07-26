package Seojeong._01_week;
import java.io.IOException;
import java.util.Scanner;

public class BOJ_14888 {

    static int N, total = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] isUsed;
    static char[] oprt = { '+', '-', '*', '/' }, oprt_res, res;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int depth) {
        if (depth == N - 1) {
            int idx = 0;
            total = arr[0];
            for (int i = 0; i < N - 1; i++) {
                switch (res[i]) {
                    case '+':
                        total = total + arr[++idx];
                        break;
                    case '-':
                        total = total - arr[++idx];
                        break;
                    case '*':
                        total = total * arr[++idx];
                        break;
                    case '/':
                        if (arr[++idx] != 0) {
                            total = total / arr[idx];
                        }
                        break;
                }
            }

            if (max < total) {
                max = total;
            }
            if (min > total) {
                min = total;
            }
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                res[depth] = oprt_res[i];
                DFS(depth + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        oprt_res = new char[N - 1];
        res = new char[N - 1];
        isUsed = new boolean[N - 1];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                oprt_res[idx++] = oprt[i];
            }
        }

        DFS(0);

        System.out.println(max);
        System.out.println(min);
    }

}