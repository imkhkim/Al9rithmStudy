package Seojeong.week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20291 {
    static int N;
    // TreeMap 은 정렬 가능 but 최악의 경우가 n 걸림
    static Map<String, Integer> files = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            String ext = fileName.split("\\.")[1];



            // hashmap의 getordefault 쓰면 한 줄로 해결 가능
            if (files.containsKey(ext)) {
                files.put(ext, files.get(ext) + 1);
            } else files.put(ext, 1);
        }

        List<String> keyList = new ArrayList<>(files.keySet());
        keyList.sort((s1,s2) -> s1.compareTo(s2));

        for (String key : keyList) {
            System.out.println(key+ " "+ files.get(key));
        }
    }
}
