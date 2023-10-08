package oh3823.week_10;

import java.util.Arrays;

class PRG_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (int[] r1, int[] r2) -> {
            return r1[0] == r2[0] ? r2[1] - r1[1] : r1[0] - r2[0];
        });

        int out;

        for (int t = 0; t < routes.length; answer++) {
            out = routes[t][1];
            for (; t < routes.length && routes[t][0] <= out; t++) {
                out = Math.min(out, routes[t][1]);
            }
        }


        return answer;
    }
}