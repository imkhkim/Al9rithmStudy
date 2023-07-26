// N과 M (4)
// https://www.acmicpc.net/problem/15652

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] path;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[M];
        dfs(0, 1);
        bw.flush();
    }

    public static void dfs(int lv, int now) throws IOException {
        if (lv == M) {
            for (int i = 0; i < M; i++)
                bw.write(path[i] + " ");
            bw.write("\n");
            return;
        }

        for (int i = now; i <= N; i++) {
            path[lv] = i;
            dfs(lv + 1, i);
        }
    }
}
