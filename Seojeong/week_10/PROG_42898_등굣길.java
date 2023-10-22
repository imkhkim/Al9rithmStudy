package Seojeong.week_10;

public class PROG_42898_등굣길 {

    public int solution(int m, int n, int[][] puddles) {

        int[][] way = new int[m + 1][n + 1];

        for (int[] puddle : puddles) {
            way[puddle[0]][puddle[1]] = -1;
        }

        way[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;

                if (way[i][j] == -1) way[i][j] = 0;
                else way[i][j] = (way[i - 1][j] + way[i][j - 1]) % 1000000007;
            }
        }

        return way[m][n];
    }
}