import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] stair;
	static int[][] dp;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stair = new int[N + 1];
		dp = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		if (N == 1) {
			System.out.println(stair[1]);
			return;
		}
		
		dp[1][1] = stair[1];
		dp[1][2] = 0;
		dp[2][1] = stair[2];
		dp[2][2] = stair[1] + stair[2];
		for (int i = 3; i <= N; i++) {
			dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stair[i];
			dp[i][2] = dp[i - 1][1] + stair[i];
		}
		
		System.out.println(Math.max(dp[N][1], dp[N][2]));
	} // main
} // class
