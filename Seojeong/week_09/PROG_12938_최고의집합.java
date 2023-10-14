package Seojeong.week_09;

public class PROG_12938_최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int mid = s / n;
        int diff = s - n * mid;

        if (mid <= 0) return new int[]{-1};

        for (int i = n - 1; i >= 0; i--) {
            if (diff > 0) answer[i] = mid + 1;
            else answer[i] = mid;
            diff--;
        }

        return answer;
    }
}