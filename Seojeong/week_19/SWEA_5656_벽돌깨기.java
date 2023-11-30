package Seojeong.week_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
    static int res, N, W, H, map[][], copy[][], permRes[], top[];
    static int di[] = {1, 0, -1, 0}, dj[] = {0, 1, 0, -1};
    static boolean stop;

    static class Block {
        int h, w, power;

        public Block(int h, int w, int power) {
            this.h = h;
            this.w = w;
            this.power = power;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "h=" + h +
                    ", w=" + w +
                    ", power=" + power +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            res = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 맵 정보
            map = new int[H][W];
            copy = new int[H][W];
            top = new int[W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 중복 순열 뽑기
            permRes = new int[N];
            stop = false;
            perm(0);

            sb.append("#" + t + " ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int lv) {

        if (stop) return;
        if (lv == N) {
//            System.out.println(Arrays.toString(permRes));

            // 원본 배열 복사
            copy();

            int cnt = 0;
            // 뽑은 중복 순열 결과로 벽돌깨보기 bfs
            for (int i = 0; i < N; i++) {
                int h = findTop(permRes[i]);
                int w = permRes[i];
                breakOut(h, w);
                // 빈칸 제거 + 빈칸 카운트 동시에 되나?
                cnt = removeSpace();
            }
            // 최소 벽돌개수 업데이트 (res)
            res = Math.min(res, cnt);

            if (res == 0) stop = true;
            return;
        }

        for (int i = 0; i < W; i++) {
            permRes[lv] = i;
            perm(lv + 1);
        }
    }

    private static int findTop(int w) {
        int h = 0;
        for (int i = 0; i < H; i++) {
            if (copy[i][w] != 0) {
                h = i;
                break;
            }
        }
        return h;
    }

    private static int removeSpace() {
        int cnt = 0;

        for (int w = 0; w < W; w++) {
            Stack<Integer> stack = new Stack<>();
            for (int h = 0; h < H; h++) {
                if (copy[h][w] != 0) {
                    cnt++;
                    stack.push(copy[h][w]);
                    copy[h][w] = 0;
                }
            }

            int h = H - 1;
            while (!stack.isEmpty()) {
                copy[h--][w] = stack.pop();
            }
        }

//        print();
//        System.out.println(cnt);
        return cnt;
    }

    private static void breakOut(int startH, int startW) {

        Queue<Block> queue = new LinkedList<>();

        queue.add(new Block(startH, startW, copy[startH][startW]));

        while (!queue.isEmpty()) {
            Block now = queue.poll();
            copy[now.h][now.w] = 0;
//            System.out.println(now);

            for (int d = 0; d < 4; d++) {
                int nextH = now.h;
                int nextW = now.w;

                int nnextH = nextH;
                int nnextW = nextW;
                for (int p = 0; p < now.power - 1; p++) {
                    nnextH += di[d];
                    nnextW += dj[d];
                    if (outOfBound(nnextH, nnextW)) continue;

                    if (copy[nnextH][nnextW] > 1) {
                        queue.add(new Block(nnextH, nnextW, copy[nnextH][nnextW]));
                    } else copy[nnextH][nnextW] = 0;
                }
            }

        }

//        print();


    }

    private static boolean outOfBound(int h, int w) {
        return w < 0 || w > W - 1 || h < 0 || h > H - 1;
    }

    private static void copy() {

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    private static void print() {
        System.out.println("==================");
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copy[i][j] == 0)
                    System.out.print("_ ");
                else
                    System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
