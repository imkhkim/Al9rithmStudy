package oh3823.week_08;

class PRG_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] D = new int[triangle.length][];
        D[0] = new int[1];
        D[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length - 1; i++) {
            D[i + 1] = new int[i + 2];
            for (int j = 0; j <= i; j++) {
                if (D[i][j] + triangle[i + 1][j] > D[i + 1][j]) {
                    D[i + 1][j] = D[i][j] + triangle[i + 1][j];
                }
                if (D[i][j] + triangle[i + 1][j + 1] > D[i + 1][j + 1]) {
                    D[i + 1][j + 1] = D[i][j] + triangle[i + 1][j + 1];
                }
            }
        }

        int N = triangle.length;
        for (int i = 0; i < D[N - 1].length; i++) {
            answer = Math.max(D[N - 1][i], answer);
        }

        return answer;
    }
}