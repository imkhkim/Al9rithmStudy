import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pos {
		int x, y;
		Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // Pos
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pos> Q = new ArrayDeque<Pos>();
	
	static void dfs(int x, int y) {
		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) continue;
			if (visited[nx][ny] || map[nx][ny] == 0) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	} // bfs
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0 || visited[i][j]) continue;
					cnt++;
					visited[i][j] = true;
					dfs(i, j);
				}
			}
			
			sb.append(cnt).append("\n");
		} // tc
		
		System.out.println(sb);
	} // main
} // class
