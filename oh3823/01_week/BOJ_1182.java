import java.util.Scanner;

public class Main {
    static int[] arr;
    static int answer;
    static int N, S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dfs(i, arr[i]);
        }

        System.out.println(answer);
    }

    public static void dfs(int now, int sum) {
        // 이후에 음수가 나올 수도 있기 때문에 가지치기 X
        if (sum == S)
            answer++;

        for (int j = now + 1; j < N; j++) { // combination
            dfs(j, sum + arr[j]);
        }
    }
}