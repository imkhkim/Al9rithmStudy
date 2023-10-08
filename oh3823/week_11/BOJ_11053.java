package oh3823.week_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    static int N;
    static int[] arr;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        D = new int[N];

        int len = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int l = bs(0, len, arr[i]);

            if (len < l + 1) len = l + 1;
            D[l] = arr[i];
        }

        System.out.println(len);
    }

    static int bs(int start, int end, int target) {
        int left = start, right = end;

        while (left < right) {
            int mid = (left + right) >> 1;

            // 답을 항상 범위에 포함하기
            // D[mid] > target 왼쪽 범위, D[mid]가 target 이상이므로 target이 D[mid] 자리에 들어갈 수 있다.
            // D[mid] <= target 오른쪽 범위, mid를 범위에서 제외(D[mid]가 target이하이므로 target이 D[mid]를 대체할 수 없다.)

            // left = mid = right인 경우에 D[mid]가 target 미만이라면? 들어갈 수 없으므로 그 오른쪽 자리를 반환
            if (D[mid] < target) {
                left = mid + 1;
            }
            // left = mid = right인 경우에 D[mid]가 target 이상이라면? 그 자리에 들어가면 되므로 left or mid를 반환
            else {
                right = mid;
            }
        }

        return left;
    }

}