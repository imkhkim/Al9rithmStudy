package Seojeong.week_10;

import java.util.Arrays;
import java.util.Comparator;

public class PROG_42884_단속카메라 {

    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int cctv_end = routes[0][1];
        answer++;

        for (int i = 1; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];

            if (cctv_end < start) {
                answer++;
                cctv_end = end;
                continue;
            }


            if (cctv_end > end) cctv_end = end;

        }

        return answer;
    }
}