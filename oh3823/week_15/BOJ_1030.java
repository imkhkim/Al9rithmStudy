package oh3823.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_1030 {
    static int S, N, K, R1, R2, C1, C2;

    static int M;

    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        S = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        M = (int) Math.pow(N, S);

        StringBuilder sb = new StringBuilder();
        for (r = R1; r <= R2; r++) {
            for (c = C1; c <= C2; c++) {
                sb.append(f(0, 0, M, M));
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    /*
     * m: 현재 정사각형의 한 변의 길이
     * k: 검은색으로 칠해질 정사각형의 한 변의 길이
     * [mr1, mr2): 검은색으로 칠해질 정사각형 행의 범위
     * [mc1, mc2): 검은색으로 칠해질 정사각형 열의 범위
     * frac: N*N개로 나누어질 정사각형의 한 변의 길이
     * [_r, _r + frac): N*N개로 나누어질 정사각형 중 현재 좌표(r, c)가 속해있는 정사각형 행의 범위
     * [_c, _c + frac): N*N개로 나누어질 정사각형 중 현재 좌표(r, c)가 속해있는 정사각형 열의 범위
     * 위 2개의 범위는 더 작은 범위의 정사각형의 행, 열의 범위가 된다.
     */
    static char f(int r1, int c1, int r2, int c2) {
        int m = (r2 - r1), k = (m / N) * K;
        int mr1 = r1 + ((m - k) >> 1), mr2 = r1 + ((m + k) >> 1);
        int mc1 = c1 + ((m - k) >> 1), mc2 = c1 + ((m + k) >> 1);

        if (m == 1) return '0';
        int frac = m / N, _r = r - r % frac, _c = c - c % frac;
        return mr1 <= r && r < mr2 && mc1 <= c && c < mc2 ? '1' : f(_r, _c, _r + frac, _c + frac);
    }
}