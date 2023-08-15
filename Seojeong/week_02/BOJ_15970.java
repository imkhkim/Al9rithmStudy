package Seojeong.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_15970 {
    static Map<Integer, Integer> dots = new HashMap<>();
    static Map<Integer, Set<Integer>> colors = new HashMap<>();
    static List<Integer> keys;
    static int N;

    static int distance(int x) {

        int p_color = dots.get(x);

        List<Integer> color_arr = new ArrayList<>(colors.get(p_color));
        Collections.sort(color_arr);

        int color_idx = color_arr.indexOf(x);

        int left = color_idx - 1;
        int right = color_idx + 1;

        if (left < 0) {
            return color_arr.get(right) - x;
        }
        if (right >= color_arr.size()) {
            return x - color_arr.get(left);
        }
        int abs_r = Math.abs(color_arr.get(right) - x);
        int abs_l = Math.abs(x - color_arr.get(left));
        return Math.min(abs_l, abs_r);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);

            int x = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            dots.put(x, color);

            if (colors.get(color) == null)
                colors.put(color, new TreeSet<>());
            colors.get(color).add(x);

        }

        for (Integer key : dots.keySet()) {
            sum += distance(key);
        }

        System.out.println(sum);
    }
}