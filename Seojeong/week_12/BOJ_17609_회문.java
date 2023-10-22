package Seojeong.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609_회문 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] arr = br.readLine().toCharArray();

            int result = checkPalindrome(arr);
//			System.out.println(result);
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    private static int checkPalindrome(char[] arr) {

        int result = 0;
        int left = 0, right = arr.length - 1;
        boolean done = false;

        while (left <= right) {
            if (done) break;
            if (arr[left] == arr[right]) { // 회문인지 확인
                left++;
                right--;
            } else { // 유사회문인지 확인
                // left를 삭제했을때
                int l = left + 1;
                int r = right;
                while (l <= r) {
                    if (arr[l] == arr[r]) {
                        l++;
                        r--;
                        result = 1;

                    } else {
                        result = 2;
                        break;
                    }
                }

                // left 삭제했는데 유사회문 아니면 right를 삭제해보기
                if (result == 2) {
                    l = left;
                    r = right - 1;
                    while (l <= r) {
                        if (arr[l] == arr[r]) {
                            l++;
                            r--;
                            result = 1;
                        } else {
                            result = 2;
                            break;
                        }
                    }
                }
                done = true;

            }

        }

        return result;
    }

}