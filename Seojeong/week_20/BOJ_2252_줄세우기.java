package Seojeong.week_20;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252_줄세우기 {
    static int N, M;
    static Queue<Integer> queue;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        queue = new ArrayDeque<>();
        int[] degree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adj[A].add(B);
            degree[B]++;
        }


        while (true) {
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    degree[i] = -1;
                    queue.offer(i);
                    break;
                }
            }

            if (queue.isEmpty()) break;

            int v = queue.poll();
            for (Integer vertex : adj[v]) {
                degree[vertex] -= 1;
            }
            System.out.print(v + " ");
        }


    }
}