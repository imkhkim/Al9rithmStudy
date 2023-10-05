package Seojeong.week_09;

public class PROG_43163_단어변환 {
    static int min;
    static boolean[] visited;

    public static int countDiffLetters(String begin, String str) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != str.charAt(i)) count++;
        }

        return count;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && countDiffLetters(begin, words[i]) == 1) {
                visited[i] = true;
                // System.out.println(words[i]);
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }


    }

    public int solution(String begin, String target, String[] words) {


        min = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}