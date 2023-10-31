package oh3823.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_2109 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.p == b.p ? a.d - b.d : b.p - a.p);

        /*
         * 마감 날짜 기준으로 오름차순을 한다면, 마감이 더 늦고 이익이 더 큰 강연을 놓칠 수도 있다.
         * 예를 들면 다음과 같다.
         *
         * 이익   마감
         * 100    2
         * 50     2
         * 30     1
         *
         * 마감 날짜 순으로 오름차순을 하고, 강연이 가능한 날짜면 이익을 얻는다고 하면,
         * 1일에 이익이 30인 강연을 하고, 2일에 이익이 100인 강연을 하게 된다.
         * 총 이익은 130이 되어 정답 150과 다르게 나온다.
         *
         * 따라서 답은 이익이 큰 강연을 먼저 선택해야하고, 이익 기준으로 내림차순 정렬을 하면 된다.
         */

        int p, d;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            p = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            pq.add(new Pair(p, d));
        }

        int answer = 0;
        boolean[] arr = new boolean[10001];

        while (!pq.isEmpty()) {
            Pair now = pq.poll();

            int day;
            for (day = now.d; day > 0; day--) {
                if (!arr[day]) {
                    arr[day] = true;
                    answer += now.p;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static class Pair {
        int p, d; //  p: 가격, d: 마감

        public Pair(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}