package oh3823.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA_14510 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int answer;

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            arr = new int[N];

            int max = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max < arr[i]) max = arr[i];
            }

            answer = N * max;

            int amount = 0; // 나무에게 주어야 할 물의 양

            int once = 0, twice = 0;
            for (int i = 0; i < N; i++) {
                amount = max - arr[i];
                twice += amount >> 1;
                once += amount % 2;
            }

            do {
                answer = Math.min(answer, Math.max(twice << 1, Math.max((once << 1) - 1, 0)));
                --twice;
                once += 2;
            } while (twice > 0);

            System.out.println("#" + tc + " " + answer);
        }

    }
}