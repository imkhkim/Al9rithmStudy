package Seojeong.week_08;

import java.util.LinkedList;
import java.util.Queue;

public class PROG_43162_네트워크 {
    static boolean[] visited;

    public static void bfs(int[][] computers, int start_i) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start_i);
        visited[start_i] = true;

        while (!queue.isEmpty()) {
            int now_i = queue.poll();

            for (int j = 0; j < computers.length; j++) {
                if (now_i == j) continue;
                if (!visited[j] && computers[now_i][j] == 1) {
                    queue.add(j);
                    visited[j] = true;
                }
            }


        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i] && computers[i][j] == 1) {
                    bfs(computers, i);
                    answer++;
                }
            }
        }

        return answer;

    }
}