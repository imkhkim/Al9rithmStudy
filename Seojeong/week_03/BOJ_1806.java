package Seojeong.week_03;

import java.util.Scanner;

public class BOJ_1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 1;
        int sum = num[0];
        int diff = 0;

        while (true) {
            if (i>=j)
                break;
          if(j==N){
              if (sum >= S) {
                  diff = j - i;
                  sum -= num[i++];
                  if (min > diff) {
                      min = diff;
                  }
                  continue;
              }
              else break;
          }

            if (sum < S) {
                sum += num[j++];
            } else if (sum >= S) {
                diff = j - i;
                sum -= num[i++];
                if (min > diff) {
                    min = diff;
                }
            }
        }

        System.out.println(min==Integer.MAX_VALUE ? 0 : min);

    }
}
