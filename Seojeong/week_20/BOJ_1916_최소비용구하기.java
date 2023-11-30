package Seojeong.week_20;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기 {

    static class Info {
        int city;
        int cost;

        Info(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }


        @Override
        public String toString() {
            return "Info{" +
                    "city=" + city +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dist = new int[N + 1];

        ArrayList<Info>[] busInfo = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            busInfo[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            int departure = sc.nextInt();
            int arrival = sc.nextInt();
            int cost = sc.nextInt();

            busInfo[departure].add(new Info(arrival, cost));
        }


        int departure = sc.nextInt();
        int arrival = sc.nextInt();

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Info(departure, 0));
        dist[departure] = 0;


        while (!pq.isEmpty()) {
            Info v = pq.poll();

            if (dist[v.city] < v.cost) continue;

            for (Info info : busInfo[v.city]) {
                if (dist[v.city] + info.cost < dist[info.city]) {
                    dist[info.city] = dist[v.city] + info.cost;
                    pq.add(new Info(info.city, dist[info.city]));
                }

            }
        }
        System.out.println(dist[arrival]);

//        for (int i = 1; i <= N; i++) {
//            System.out.println(busInfo[i].toString());
//        }
    }
}
