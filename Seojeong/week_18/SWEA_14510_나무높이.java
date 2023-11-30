package Seojeong.week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_14510_나무높이 {
    static int res, N, trees[], diff[], minHeight, maxHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            res = 0;
            minHeight = Integer.MAX_VALUE;
            maxHeight = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            trees = new int[N];
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
                minHeight = Math.min(minHeight, trees[i]);
            }

            diff = new int[maxHeight - minHeight + 1];

            // 가장 키가 큰 나무와 나머지 나무들의 키 차이 저장 => diff[키 차이] = 나무 개수
            for (int i = 0; i < N; i++) {
                if (maxHeight - trees[i] > 0) diff[maxHeight - trees[i]]++;
            }

            // 키 차이가 나는 나무가 있으면 물 주기
            if (diff.length > 1) res = water();

            sb.append("#" + t + " ").append(res).append("\n");

        }
        System.out.println(sb);
    }

    private static int water() {
        int day = 1;
        int diffPointer = 1;
        int gap = 0;

        while (true) {
            while (diffPointer < diff.length && diff[diffPointer] == 0) diffPointer++;
            if (diffPointer >= diff.length) return day;

            System.out.println("day: " + day);
            System.out.println(diffPointer);
            System.out.println(Arrays.toString(diff));
            // 홀수 번째 날
            if (day % 2 != 0) gap = 1;
                // 짝수 번째 날
            else gap = 2;

            if (diff[diffPointer] - 1 >= 0) {
                diff[diffPointer] -= 1;
                if (diffPointer - gap >= 0) diff[diffPointer - gap] += 1;
                if (diff[diffPointer] == 0) {
                    diffPointer -= gap;
                }
            }

            System.out.println(Arrays.toString(diff));
            day++;
        }

//        return day;

    }
}
