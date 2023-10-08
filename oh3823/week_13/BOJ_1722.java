package oh3823.week_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class BOJ_1722 {
    static long[] F = new long[21];
    static int N;
    static long K;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F[0] = 1;
        for (int i = 1; i < 21; i++)
            F[i] = F[i - 1] * i;

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        res = new int[N];
        LinkedList<Integer> numbers = new LinkedList<>(); // 1 ~ N이 담겨있는 표본 배열
        for (int i = 1; i <= N; i++) numbers.add(i);

        // 1. k를 입력받고, k번째 순열 출력
        if (p == 1) {
            K = Long.parseLong(st.nextToken());

            long k = K;
            int n = N;

            for (int i = 0; i < N; i++, n--) {
                int order = (int) ((k - 1) / F[n - 1]);
                res[i] = numbers.remove(order);
                k -= F[n - 1] * order;
            }

            for (int i = 0; i < N; i++)
                System.out.print(res[i] + " ");
        }

        // 2. 순열을 입력받고, 몇 번째 순열인지 출력
        else if (p == 2) {
            for (int i = 0; i < N; i++)
                res[i] = Integer.parseInt(st.nextToken());

            for (int i = 0, n = N; i < N; i++, n--) {
                int order = numbers.indexOf(res[i]);
                numbers.remove(order);
                K += order * F[n - 1];
            }

            System.out.println(K + 1);

        }

    }
}