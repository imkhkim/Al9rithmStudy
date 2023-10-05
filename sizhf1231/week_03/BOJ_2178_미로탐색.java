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
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static char[][] map;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Queue<Pos> Q = new ArrayDeque<Pos>();
		Q.add(new Pos(0, 0));
		dist[0][0] = 1;
		
		while (!Q.isEmpty()) {
			Pos cur = Q.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) break;
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
				if (dist[nx][ny] > 0 || map[nx][ny] == '0') continue;
				
				Q.add(new Pos(nx, ny));
				dist[nx][ny] = dist[cur.x][cur.y] + 1;
				
				if (nx == N - 1 && ny == M - 1) break;
			}
		}
		
		System.out.println(dist[N - 1][M - 1]);
	} // main
} // class
