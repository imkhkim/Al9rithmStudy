import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] relation;
	static boolean[] isChecked;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		relation = new boolean[n + 1][n + 1];
		isChecked = new boolean[n + 1];
		
		Queue<Integer> Q = new ArrayDeque<>();
		int cnt = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a][b] = relation[b][a] = true;
			
			if (a == 1) { // b가 상근이의 친구이면
				cnt++;
				isChecked[b] = true; // 카운트 했다고 표시
				Q.add(b); // 큐에 추가
			}
		}

		while (!Q.isEmpty()) {
			int friend1 = Q.poll(); // 상근이의 친구
			
			for (int friend2 = 2; friend2 <= n; friend2++) {
				if (relation[friend1][friend2]) { // 친구의 친구이면
					
					if (isChecked[friend2]) continue; // 카운트 했었으면 continue
					
					cnt++; // 친구의 친구이므로 카운트
					isChecked[friend2] = true; // 카운트 했다고 표시
				} // if
			} // \for
		} // while
		
		System.out.println(cnt);
	} // main
}
