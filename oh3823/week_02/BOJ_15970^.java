// 화살표 그리기
// https://www.acmicpc.net/problem/15970

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        T[] arr = new T[N];
        for (int i = 0; i < N; i++) {
            int location = sc.nextInt(), color = sc.nextInt();
            arr[i] = new T(location, color);
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int length = Integer.MAX_VALUE;
            if (i > 0 && arr[i - 1].color == arr[i].color) {
                length = Math.min(arr[i].location - arr[i - 1].location, length);
            }
            if (i < N - 1 && arr[i].color == arr[i + 1].color) {
                length = Math.min(arr[i + 1].location - arr[i].location, length);
            }
            answer += length;
        }

        System.out.println(answer);
    }

}

class T implements Comparable<T> {
    int location, color;

    public T(int location, int color) {
        this.location = location;
        this.color = color;
    }

    @Override
    public int compareTo(T o) {
        if (color == o.color) {
            return location - o.location;
        }
        return color - o.color;
    }
}