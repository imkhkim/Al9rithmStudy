package Seojeong.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10825 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer[]> students = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Integer[] scores = {Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])};
            students.put(input[0], scores);
        }

        List<String> keys = new ArrayList<>(students.keySet());
        Collections.sort(keys);

        Collections.sort(keys, (v1, v2) -> {
            return -students.get(v1)[2].compareTo(students.get(v2)[2]);
        });
        Collections.sort(keys, (v1, v2) -> {
            return students.get(v1)[1].compareTo(students.get(v2)[1]);
        });

        Collections.sort(keys, (v1, v2) -> {
            return -students.get(v1)[0].compareTo(students.get(v2)[0]);
        });


        for (String k : keys) {
            System.out.println(k);
        }
    }
}
