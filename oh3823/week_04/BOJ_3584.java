package oh3823.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

class BOJ_3584 {
    static int T, N, A, B;
    static int[] parentOf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        int a, b, answer;
        for (int tc = 1; tc <= T; tc++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            parentOf = new int[N + 1];
            parentOf[0] = -1;
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                parentOf[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            ArrayList<Integer> aParent = new ArrayList<>();
            ArrayList<Integer> bParent = new ArrayList<>();

            while (A != 0) {
                aParent.add(A);
                A = parentOf[A];
            }
            while (B != 0) {
                bParent.add(B);
                B = parentOf[B];
            }

            Collections.reverse(aParent);
            Collections.reverse(bParent);

            for (int i = 0; i < aParent.size() && i < bParent.size(); i++) {
                if (!Objects.equals(aParent.get(i), bParent.get(i))) break;
                answer = aParent.get(i);
            }

            System.out.println(answer);
        }
    }
}