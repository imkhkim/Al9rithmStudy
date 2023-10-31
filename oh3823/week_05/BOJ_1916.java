package oh3823.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ_1916 {
    static int N, M;
    static int start, dest;
    static int[][] arr;
    static int[] dist;
    final static int INF = 100000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++)
            Arrays.fill(arr[i], INF);
        Arrays.fill(dist, INF);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        int a, b, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(arr[a][b], cost);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        dist[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair next = pq.poll();
            for (int j = 1; j <= N; j++) {
                int newCost = dist[next.node] + arr[next.node][j];
                if (dist[j] > newCost) {
                    dist[j] = newCost;
                    pq.add(new Pair(j, newCost));
                }
            }
        }

        System.out.println(dist[dest]);

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