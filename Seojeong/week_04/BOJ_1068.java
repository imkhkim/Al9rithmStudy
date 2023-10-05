package Seojeong.week_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1068 {


    static int N, arr[], child[], remove_idx, count;
    static boolean check;
    static List<Integer> leaf, result;

    public static boolean isLeaf(int idx) {

        if (idx == remove_idx) {
            return false;
        }
        if (idx == -1) {
            return true;
        }

        return isLeaf(arr[idx]);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        leaf = new ArrayList<>();
        result = new ArrayList<>();

        arr = new int[N];
        child = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        remove_idx = sc.nextInt();
        arr[remove_idx] = -2;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 0)
                child[arr[i]]++;
        }

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(child));

        for (int i = 0; i < N; i++) {
            if (child[i] == 0 && isLeaf(i)) {
                count++;
//				System.out.println(i + " " + child[i]);
            }
        }

        System.out.println(count);

    }
}