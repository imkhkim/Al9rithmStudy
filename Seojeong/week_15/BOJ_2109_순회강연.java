package Seojeong.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {

    static class Request {
        int p, d;

        public Request(int p, int d) {
            super();
            this.p = p;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Request [p=" + p + ", d=" + d + "]";
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Request> pay = new PriorityQueue<>(new Comparator<Request>() {
            @Override
            public int compare(Request o1, Request o2) {
                return o2.p - o1.p;
            }
        });

        int maxDay = 0;
        int money = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pay.add(new Request(p, d));
            maxDay = Math.max(maxDay, d);
        }

        boolean[] schedule = new boolean[maxDay + 1];
        while (!pay.isEmpty()) {
            Request r = pay.poll();
            for (int i = r.d; i >= 1; i--) {
                if (!schedule[i]) {
                    schedule[i] = true;
                    money += r.p;
                    break;
                }
            }

        }

        System.out.println(money);
    }
}