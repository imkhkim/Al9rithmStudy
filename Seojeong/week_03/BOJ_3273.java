package Seojeong.week_03;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(a);

        int i = 0;
        int j = n - 1;
        int cnt = 0;
        while (i < j) {
            if (a[i] + a[j] == x) {
                cnt++;
                i++;
            } else if (a[i] + a[j] < x) {
                i++;
            } else if (a[i] + a[j] > x) {
                j--;
            }
        }
        System.out.println(cnt);
    }
}
