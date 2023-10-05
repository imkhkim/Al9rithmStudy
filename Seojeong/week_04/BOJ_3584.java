package Seojeong.week_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_3584 {
    static int N, parent[];
    static List<Integer> p;

    public static void findParent(int node) {


        if (p.contains(node)) {
            System.out.println(node);
            return;
        }

        p.add(node);
        if (parent[node] == 0) {
            return;
        }
        findParent(parent[node]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            N = sc.nextInt();
            parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                parent[B] = A;
            }
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            p = new ArrayList<Integer>();
            findParent(node1);
            findParent(node2);

        }
    }

}