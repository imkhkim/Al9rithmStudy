package oh3823.week_04;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14267 {
    static int N, M;
    static int[] parentOf;
    static int[] praised;
    static boolean[] updated;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parentOf = new int[N + 1];
        praised = new int[N + 1];
        updated = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            parentOf[i] = Integer.parseInt(st.nextToken());
        }

        int index, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            index = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            praised[index] += w;
        }

        for (int i = 1; i <= N; i++) {
            bw.write(getPraise(i) + " ");
        }
        bw.close();
    }

    static int getPraise(int i) {
        if (i <= 0)
            return 0;
        if (updated[i])
            return praised[i];

        praised[i] += getPraise(parentOf[i]);
        updated[i] = true;

        return praised[i];
    }
}