package Seojeong.week_03;

import java.io.*;
import java.util.*;

public class BOJ_1325 {
    static int N, M, count[];
    static boolean[] visited;
    static ArrayList<ArrayList> graph;

    public static void bfs(int start) {

        Queue<Integer> queue = new LinkedList();

        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for (Object node : graph.get(current)) {
                if (!visited[(Integer) node]) {
                    queue.offer((Integer) node);
                    visited[(Integer) node] = true;
                }
            }

        }

        for (int i = 0; i < visited.length; i++) {
            if(visited[i]) count[start]++;
        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  = new StringBuilder();
        StringTokenizer st;
        String input;

        input = br.readLine();
        st = new StringTokenizer(input);

        graph = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList());
        }


        for (int i = 0; i < M; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(B).add(A);
        }


        count = new int[N+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
            max = Integer.max(max, count[i]);
        }

        for (int i = 1; i <= N; i++) {
            if(count[i]==max) sb.append(i).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();



    }
}
