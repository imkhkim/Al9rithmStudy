// 암호 만들기
// https://www.acmicpc.net/problem/1759

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static char[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        for (int i = 0; i <= C - L; i++) {
            dfs(1, i, "" + arr[i]);
        }

    }

    public static void dfs(int lv, int now, String str) {
        if (lv == L) { // L자리 모두 선택했으면 모음과 자음의 개수 세기
            int a = getVowels(str);
            int b = L - a;
            if (a > 0 && b > 1) {
                System.out.println(str);
            }
            return;
        }

        for (int i = now + 1; i < C; i++) { // combination
            dfs(lv + 1, i, str + arr[i]);
        }
    }

    public static int getVowels(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u')
                cnt++;
        }
        return cnt;
    }
}
