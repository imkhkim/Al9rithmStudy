package oh3823.week_09;

class PRG_최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int a = s / n;
        if (a == 0)
            return new int[]{-1};
        int len = s % n;
        for (int i = 0; i < n; i++) answer[i] = a;
        for (int i = 0; i < len; i++) ++answer[n - 1 - i];
        return answer;
    }
}