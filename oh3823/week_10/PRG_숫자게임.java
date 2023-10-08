package oh3823.week_10;

import java.util.Arrays;

class PRG_숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int a = 0, b = 0;
        while (a < len && b < len) {
            if (A[a] < B[b]) {
                answer++;
                a++;
                b++;
            } else b++;
        }
        return answer;
    }
}