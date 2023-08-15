package oh3823.week_02;// 파일 정리
// https://www.acmicpc.net/problem/20291

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] name = new String[N];
        for (int i = 0; i < N; i++) {
            name[i] = sc.next();
            name[i] = name[i].substring(name[i].indexOf('.') + 1);
        }

        Arrays.sort(name);

        int count = 1;
        for (int i = 0; i < N; i++) {
            if (i == N - 1 || !name[i].equals(name[i + 1])) {
                System.out.println(name[i] + " " + count);
                count = 1;
                continue;
            }
            count++;
        }

    }
}