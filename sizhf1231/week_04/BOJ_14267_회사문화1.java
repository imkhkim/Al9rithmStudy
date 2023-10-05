import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static ArrayList<Integer>[] vec;
	static int[] compliment;
	static int[] ans;
	
	static void dfs(int curNode, int val) {
		if (vec[curNode].isEmpty()) {
			return;
		}
		
		for (int i = 0; i < vec[curNode].size(); i++) {
			int child = vec[curNode].get(i);
			ans[child] += val + compliment[child];
			dfs(child, val + compliment[child]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		vec = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			vec[i] = new ArrayList<Integer>();
		}
		compliment = new int[n + 1];
		ans = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		st.nextToken(); // 1번(사장)의 상사 -1 버리기
		for (int i = 2; i <= n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			vec[parent].add(i);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			compliment[node] += val;
		}
		
		dfs(1, 0);
		
		for (int i = 1; i <= n; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	} // main
} // class
