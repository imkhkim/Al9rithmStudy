package oh3823.week_01;// N과 M (9)
// https://www.acmicpc.net/problem/15663

import java.util.*;

class BOJ_15663 {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        selected = new boolean[N];

        answer = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int last = 0;
        for (int i = 0; i < N; i++) {
            if (i > 0 && arr[i] == last) continue;
            // 같은 level에서 d선택했던 것을 또 선택하면 중복된 수열을 생성한다.
            answer[0] = arr[i];
            selected[i] = true;
            dfs(1, i);
            answer[0] = 0;
            selected[i] = false;
            last = arr[i];
        }
    }

    public static void dfs(int lv, int now) {
        if (lv == M) {
            print();
            return;
        }
        int last = 0;
        for (int i = 0; i < N; i++) { // permutation
            if (i > 0 && arr[i] == last) continue;
            /* 같은 level에서 선택했던 것을 또 선택하면 똑같은 수열을 생성한다.
                ex. 1 3 3 5 중에서 3개를 고르는 테스트케이스에서 1을 제일 먼저 선택한 경우

                lv0               1
                lv1         1   3   3   5

                lv1에서 왼쪽 3을 선택하여 수열 생성을 마치고 돌아와서 오른쪽 3을 선택한다면?
            */
            if (selected[i]) continue;
            // 이전 level에서 선택했던 것을 또 선택할 수 없다.

            answer[lv] = arr[i];
            selected[i] = true;
            dfs(lv + 1, i);
            answer[lv] = 0;
            selected[i] = false;
            last = arr[i];
        }
    }

    public static void print() {
        for (int i = 0; i < M; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}