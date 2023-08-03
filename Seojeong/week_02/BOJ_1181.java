package Seojeong.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1181 {
    static List<String> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr.add(str);
        }

        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length())  return o1.length() - o2.length();
                else return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            if (i == 0 || arr.get(i).compareTo(arr.get(i - 1)) != 0)
                sb.append(arr.get(i)).append('\n');
        }
        System.out.println(sb.toString());
    }

}
