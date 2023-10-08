package oh3823.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] D1 = new int[N + 1];
        int[] D2 = new int[N + 1];

        D1[1] = D2[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            D1[i] = D2[i - 1] + arr[i];
            D2[i] = Math.max(D2[i - 2], D1[i - 2]) + arr[i];
        }

        System.out.println(Math.max(D1[N], D2[N]));

    }
}