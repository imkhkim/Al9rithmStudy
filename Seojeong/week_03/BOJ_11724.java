package Seojeong.week_03;

import java.util.*;

public class BOJ_11724 {
    static boolean[] visited;
    static ArrayList<ArrayList> graph;

    public static void bfs(int start){

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        while(!queue.isEmpty()){
//            System.out.println(queue);
            int current = queue.poll();
            visited[current] = true;
            for (Object node: graph.get(current)) {
                if(!visited[(Integer) node]){
                    queue.offer((Integer) node);
                    visited[(Integer) node] = true;
                }
//                System.out.println(node);
            }

        }

//        System.out.println(Arrays.toString(visited));
    }

    public static boolean checkVisitAll(){
        for (int i = 1; i < visited.length; i++) {
            if(!visited[i]) return false;
        }

        return true;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList<>();
        visited= new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v= sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

//        System.out.println(graph);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
            if(checkVisitAll()) break;
//            System.out.println(graph.get(i));
        }
        System.out.println(count);
    }
}
