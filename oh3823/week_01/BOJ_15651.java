package oh3823.week_01;// N과 M (3)
// https://www.acmicpc.net/problem/15651

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15651 {
    static int N, M;
    static int[] path = new int[7];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);
        bw.flush();
    }

    public static void dfs(int lv) throws IOException {
        if (lv == M) {
            for (int i = 0; i < M; i++)
                bw.write(path[i] + " ");
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            path[lv] = i;
            dfs(lv + 1);
        }
    }
}
