package oh3823.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_1753 {
    static int V, E, K;
    static ArrayList<Pair>[] arr;
    static int[] dist;
    final static int INF = 100000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++)
            arr[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        dist[K] = 0;

        for (int i = 0; i < E; i++) {
            int a, b, cost;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            arr[a].add(new Pair(b, cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(K, 0));

        while (!pq.isEmpty()) {
            Pair next = pq.poll();

            arr[next.node].forEach((pair) -> {
                if (dist[pair.node] > dist[next.node] + pair.cost) {
                    dist[pair.node] = dist[next.node] + pair.cost;
                    pq.add(new Pair(pair.node, dist[pair.node]));
                }
            });
        }

        for (int i = 1; i <= V; i++)
            System.out.println(dist[i] != INF ? dist[i] : "INF");

    }

    static class Pair implements Comparable<Pair> {
        int node, cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p) {
            return cost - p.cost;
        }


    }
}