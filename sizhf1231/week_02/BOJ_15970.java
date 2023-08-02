import java.util.Arrays;
import java.util.Scanner;

class Dot implements Comparable<Dot> {
	int loc;
	int color;
	
	Dot (int l, int c) {
		this.loc = l;
		this.color = c;
	}
	
	@Override
	public int compareTo(Dot o) {
		if (this.color != o.color ) {
			return this.color - o.color; // 1. 색깔 별로 모으기 위해 색깔 기준 오름차순 정렬하고
		}
		return this.loc - o.loc; // 2. 같은 색인 경우는 위치 기준 오름차순 정렬
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Dot[] arr = new Dot[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new Dot(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int minSum = Integer.MAX_VALUE;
			if (i - 1 >= 0 && arr[i].color == arr[i - 1].color) { // 내 왼쪽이 같은 색인 경우 최소 거리 갱신
				minSum = Math.min(minSum, arr[i].loc - arr[i - 1].loc);
			}
			if (i + 1 < N && arr[i].color == arr[i + 1].color) { // 내 오른쪽이 같은 색인 경우 최소 거리 갱신
				minSum = Math.min(minSum, arr[i + 1].loc - arr[i].loc);
			}
			sum += minSum;
		}
		
		System.out.println(sum);
	} // main
}
