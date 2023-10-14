package oh3823.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final char[] str = br.readLine().toCharArray();
        final char[] bomb = br.readLine().toCharArray();
        final int len = bomb.length;

        StringBuilder S = new StringBuilder();


        for (int i = 0; i < str.length; i++) {
            S.append(str[i]);
            if (S.length() >= len && S.substring(S.length() - len).equals(String.valueOf(bomb))) {
                S.delete(S.length() - len, S.length());
            }
        }

        if (S.length() == 0) System.out.println("FRULA");
        else System.out.println(S);

    }
}