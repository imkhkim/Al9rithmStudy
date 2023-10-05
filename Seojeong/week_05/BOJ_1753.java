package Seojeong.week_05;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1753 {

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            super();
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [to=" + to + ", weight=" + weight + "]";
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt(); // start

        List<Edge>[] edges = new ArrayList[V + 1];
        int[] dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Edge(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (dist[e.to] < e.weight)
                continue;

            for (Edge edge : edges[e.to]) {
                if (dist[e.to] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[e.to] + edge.weight;
                    pq.add(new Edge(edge.to, dist[edge.to]));
                }
            }

        }
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }

    }
}