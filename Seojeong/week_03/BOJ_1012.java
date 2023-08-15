package Seojeong.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {

    static int N, M, K;
    static int[] di={0,1,0,-1}, dj={1,0,-1,0};
    static int[][] ground;
    static boolean[][] visited;


    public static void bfs(int start_i, int start_j){

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start_i);
        queue.offer(start_j);

        while(!queue.isEmpty()){
            int now_i = queue.poll();
            int now_j = queue.poll();

            visited[now_i][now_j] = true;
//            System.out.println(now_i+" "+now_j);
            for (int d = 0; d < 4; d++) {
                int next_i = now_i + di[d];
                int next_j = now_j + dj[d];

                if (next_i < 0 || next_i >= M || next_j < 0 || next_j >= N) continue;
                if (visited[next_i][next_j]) continue;
                if(ground[next_i][next_j] ==0) continue;

                queue.offer(next_i);
                queue.offer(next_j);

                visited[next_i][next_j] = true;
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input = br.readLine();
            st = new StringTokenizer(input);

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            ground = new int[M][N];
            visited = new boolean[M][N];

            for (int k = 0; k < K; k++) {
                input = br.readLine();
                st = new StringTokenizer(input);

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                ground[X][Y] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && ground[i][j] == 1){
//                        System.out.println("====");
                        cnt++;
                        bfs(i,j);
                    }
                }
            }

            System.out.println(cnt);

            // print
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(ground[i][j]+" ");
//                }
//                System.out.println();
//            }


        }
    }
}
