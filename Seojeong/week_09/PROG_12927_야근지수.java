package Seojeong.week_09;

import java.util.Collections;
import java.util.PriorityQueue;

public class PROG_12927_야근지수 {

    public long solution(int n, int[] works) {
        long answer = 0;
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
            total += works[i];
        }

        if (total < n) return 0;
        for (int i = 0; i < n; i++) {
            int w = pq.poll();
            pq.add(w - 1);
        }

        for (int i = 0; i < works.length; i++) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}