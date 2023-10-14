package Seojeong.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ_2800_괄호제거 {
    static String origin;
    static LinkedList<Pair> pairs, selected;

    static List<String> result;

    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        origin = br.readLine();

        Stack<Integer> stack = new Stack<>();
        pairs = new LinkedList<>();
        result = new LinkedList<>();
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == '(') {
                stack.push(i);
            }
            if (origin.charAt(i) == ')') {
                int start = stack.pop();
                int end = i;

                pairs.add(new Pair(start, end));
            }
        }

        selected = new LinkedList<>();
        subset(0);

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            if (i > 0 && result.get(i).equals(result.get(i - 1))) continue;
            System.out.println(result.get(i));
        }


    }

    private static void subset(int idx) {

        if (idx == pairs.size()) {
            if (selected.isEmpty()) return;
            char[] arr = origin.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (Pair pair : selected) {
                arr[pair.start] = ' ';
                arr[pair.end] = ' ';
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != ' ') sb.append(arr[i]);
            }

            result.add(sb.toString());
            return;
        }

        selected.add(pairs.get(idx));
        subset(idx + 1);
        selected.removeLast();
        subset(idx + 1);

    }
}
