package oh3823.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] d = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int v, c;
            v = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int j = M; j >= v; j--) {
                d[j] = Math.max(d[j - v] + c, d[j]);
            }
        }

        System.out.println(d[M]);
    }
}