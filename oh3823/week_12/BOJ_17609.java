package oh3823.week_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            char[] str = br.readLine().toCharArray();

            int i = 0, j = str.length - 1;

            while (i < j) {
                if (str[i] != str[j]) break;
                ++i;
                --j;
            }

            if (i >= j) {
                System.out.println(0);
                continue;
            }

            // 시도 1
            int _i = i + 1, _j = j;
            while (_i < _j) {
                if (str[_i] != str[_j]) break;
                ++_i;
                --_j;
            }
            if (_i >= _j) {
                System.out.println(1);
                continue;
            }

            _i = i;
            _j = j - 1;
            while (_i < _j) {
                if (str[_i] != str[_j]) break;
                ++_i;
                --_j;
            }
            if (_i >= _j) {
                System.out.println(1);
                continue;
            }

            System.out.println(2);
        }

    }
}