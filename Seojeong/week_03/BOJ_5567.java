package Seojeong.week_03;

import java.util.*;

public class BOJ_5567 {


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        List<Integer> friends = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a= sc.nextInt();
            int b= sc.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        for (Integer f: adj.get(1)) {
            if(!friends.contains(f) && f != 1) friends.add(f);

                for (Integer ff: adj.get(f)){
                    if(!friends.contains(ff)&& ff != 1) friends.add(ff);

                }
        }
        System.out.println(friends.size());

    }
}
