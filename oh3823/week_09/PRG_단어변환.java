package oh3823.week_09;

import java.util.LinkedList;
import java.util.Queue;

class PRG_단어변환 {
    static int len;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        len = begin.length();

        Queue<T> Q = new LinkedList<>();
        Q.add(new T(0, begin));

        while (!Q.isEmpty()) {
            T now = Q.poll();
            if (now.str.equals(target)) return now.lv;
            if (now.lv > len) return 0;
            for (int i = 0; i < words.length; i++) {
                int diff = 0;
                for (int x = 0; x < len; x++) {
                    if (now.str.charAt(x) != words[i].charAt(x)) diff++;
                }
                if (diff == 1) {
                    Q.add(new T(now.lv + 1, words[i]));
                }
            }
        }

        return answer;
    }


    static class T {
        int lv;
        String str;

        T(int lv, String str) {
            this.lv = lv;
            this.str = str;
        }
    }
}