package Seojeong.week_03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10816 {

    static int[] cards;
    static int N, M;
    static StringBuilder sb = new StringBuilder();


    public static int findLowerK(int card) {

        int L = 0;
        int R = N - 1;
        int mid;

        while (L <= R) {
            mid = (L + R) / 2;

            if (cards[mid] >= card)
                R = mid - 1;
            else
                L = mid + 1;
        }
        return R;

    }

    public static int findUpperK(int card) {

        int L = 0;
        int R = N - 1;
        int mid;

        while (L <= R) {
            mid = (L + R) / 2;

            if (cards[mid] <= card)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return R;

    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(input[i]);
            int low = findLowerK(card);
            int high = findUpperK(card);
            sb.append(high - low + " ");
        }

        System.out.println(sb);

    }
}

/*
 * 10 -10 -10 2 3 3 6 7 10 10 10
 *
 *
 * 8 10 9 -5 2 3 4 5 -10
 */
