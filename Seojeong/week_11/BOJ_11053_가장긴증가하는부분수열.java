package Seojeong.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {


    public static int lowerBound(int[] res, int left, int right, int k) {

        while (left < right) {
            int mid = (left + right) / 2;

            if (res[mid] < k)
                left = mid + 1;
            else
                right = mid;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] res = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        res[0] = A[0];
        int len = 0;
        for (int i = 0; i < N; i++) {
            if (res[len] >= A[i]) {
                int low = lowerBound(res, 0, len, A[i]);
                res[low] = A[i];
            } else {
                res[++len] = A[i];
            }

        }

        System.out.println(len + 1);
    }

}