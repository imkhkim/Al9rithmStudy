package Seojeong.week_08;


public class PROG_43105_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dist = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dist[i] = new int[triangle[i].length];
        }

        dist[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= triangle[i - 1].length; j++) {
                if (j == 0) dist[i][j] = dist[i - 1][j] + triangle[i][j];
                else if (j >= triangle[i - 1].length) dist[i][j] = dist[i - 1][j - 1] + triangle[i][j];
                else {
                    dist[i][j] = Math.max(dist[i - 1][j - 1] + triangle[i][j], dist[i - 1][j] + triangle[i][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dist[dist.length - 1].length; i++) {
            max = Math.max(max, dist[dist.length - 1][i]);
        }
        return max;
    }

}