// 카드
// https://www.acmicpc.net/problem/11652

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        int maxCounts = 0, count = 1;
        long number = 0;
        for (int i = 0; i < N; i++) {
            if (i == N - 1 || arr[i] != arr[i + 1]) {
                if (maxCounts < count) {
                    maxCounts = count;
                    number = arr[i];
                }
                count = 0;
            }

            count++;
        }

        System.out.println(number);
    }
}