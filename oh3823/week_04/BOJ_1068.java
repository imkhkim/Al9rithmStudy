package oh3823.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static int N, E;
    static int[] parentOf;
    static int[] ref;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        parentOf = new int[N];
        ref = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            parentOf[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        parentOf[E] = -2;
        for (int i = 0; i < N; i++) {
            if (parentOf[i] < 0)
                continue;
            ref[parentOf[i]]++;
        }

        int answer = 0;
//		 ref[i]가 0인거 찾고 findParent가 true인거 세기

        for (int i = 0; i < N; i++) {
            if (ref[i] == 0 && findParent(i))
                answer++;
        }
        System.out.println(answer);
    }

    static boolean findParent(int node) {
        if (node == E)
            return false;
        if (node == -1)
            return true;

        return findParent(parentOf[node]);

    }
}