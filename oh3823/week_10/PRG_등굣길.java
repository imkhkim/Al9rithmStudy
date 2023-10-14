package oh3823.week_10;

class PRG_등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        int answer = 0;
        int[][] arr = new int[m + 1][n + 1];

        for (int i = 0; i < puddles.length; i++) {
            arr[puddles[i][0]][puddles[i][1]] = -1;
        }

        arr[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == -1) continue;
                if (arr[i - 1][j] != -1) arr[i][j] = (arr[i][j] + arr[i - 1][j]) % MOD;
                if (arr[i][j - 1] != -1) arr[i][j] = (arr[i][j] + arr[i][j - 1]) % MOD;
            }
        }

        return arr[m][n];
    }
}