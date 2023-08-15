package oh3823.week_02;// 단어 정렬
// https://www.acmicpc.net/problem/1181

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<Otring> S = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            S.add(new Otring(sc.next()));
        }

        S.forEach(e -> System.out.println(e));

    }

}

class Otring implements Comparable<Otring> {
    String s;

    public Otring(String s) {
        this.s = s;
    }

    public int length() {
        return s.length();
    }

    @Override
    public int compareTo(Otring o) {
        if (s.length() == o.length()) {
            return s.compareTo(o.s);
        }
        return s.length() - o.length();
    }

    @Override
    public String toString() {
        return s;
    }

}