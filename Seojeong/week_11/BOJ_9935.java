package Seojeong.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);

            if (str[i] == boom[boom.length - 1]) {
                int idx = sb.length() - 1;
                boolean find = true;
                for (int j = boom.length - 1; j >= 0; j--) {
                    if (idx < 0 || sb.charAt(idx--) != boom[j]) {
                        find = false;
                        break;
                    }
                }

                if (find) {
                    sb.delete(sb.length() - boom.length, sb.length());
                }

            }

        }

        if (sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
