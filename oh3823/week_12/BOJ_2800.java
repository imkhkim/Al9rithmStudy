package oh3823.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

class BOJ_2800 {

    static ArrayList<Pair> pairs = new ArrayList<>();
    static LinkedList<Integer> index = new LinkedList<>();
    static char[] str;

    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().toCharArray();

        Stack<Integer> S = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') S.push(i);
            else if (str[i] == ')')
                pairs.add(new Pair(S.pop(), i));
        }

        dfs(0);

        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            if (i > 0 && result.get(i).equals(result.get(i - 1))) continue;
            System.out.println(result.get(i));
        }


    }

    static void dfs(int lv) {
        if (lv == pairs.size()) {
            if (index.isEmpty()) return;

            char[] copied = str.clone();

            for (int t : index) {
                copied[pairs.get(t).opener] = ' ';
                copied[pairs.get(t).closer] = ' ';
            }

            StringBuilder sb = new StringBuilder();
            for (char c : copied) {
                if (c == ' ') continue;
                sb.append(c);
            }

            result.add(sb.toString());
            return;
        }


        index.addLast(lv);
        dfs(lv + 1);
        index.removeLast();

        dfs(lv + 1);
    }


    static class Pair {
        int opener, closer;

        public Pair(int opener, int closer) {
            this.opener = opener;
            this.closer = closer;
        }
    }
}