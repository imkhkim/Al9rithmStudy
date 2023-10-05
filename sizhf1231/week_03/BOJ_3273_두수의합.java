import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] a = new int[1000001];
	static boolean[] chk = new boolean[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			// x - a[i] : 현재 수 a[i]와 더해서 x가 되는 수
			if (x - a[i] < 1 || x - a[i] > 1000000) {
				continue;
			}

			if (chk[x - a[i]]) { // 현재 수 a[i]와 더해서 x가 되는 수가 있었으면 카운트
				cnt++;
			}
			
			chk[a[i]] = true;
		}

		System.out.println(cnt);
	}
}
