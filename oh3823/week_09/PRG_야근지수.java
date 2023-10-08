package oh3823.week_09;

import java.util.PriorityQueue;

class PRG_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < works.length; i++) pq.add(-works[i]);

        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            int j = -pq.poll();
            if (j > 1) pq.add(-(j - 1));
        }

        while (!pq.isEmpty()) {
            long j = -pq.poll();
            answer += j * j;
        }
        return answer;
    }
}