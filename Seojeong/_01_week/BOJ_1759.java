package Seojeong._01_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1759 {
    static int L, C, v_count, c_count;
    static boolean[] isUsed;
    static char[] arr, chars;

    static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    static void password(int depth, int start) {
        if (depth == L) {
            String tmp = "";
            v_count = 0;
            c_count = 0;
            for (int i = 0; i < L; i++) {
                if (isVowel(arr[i])) {
                    v_count++;
                } else {
                    c_count++;
                }
                tmp += arr[i];
            }
            if (tmp.length() > 0 && v_count >= 1 && c_count >= 2)
                System.out.println(tmp);
            return;
        }

        for (int i = start; i < C; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = chars[i];
                password(depth + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = new char[L];
        isUsed = new boolean[C];
        chars = br.readLine().replace(" ", "").toCharArray();

        Arrays.sort(chars);
        password(0, 0);

    }
}
