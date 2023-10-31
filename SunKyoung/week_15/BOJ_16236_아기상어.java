import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static Point sharkStart; // 물고기 탐색 전 시작 위치
	static int[] di = {-1,0,1,0}; // 상좌하우
	static int[] dj = {0,-1,0,1};
	static int sharkSize; // 아기상어 크기
	static int time; // 아기상어가 물고기 먹으러 다닌 시간
	static int eat; // 아기상어가 물고기를 먹은 횟수
	static Queue<Point> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		sharkSize = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==9) { // 아기상어 현재위치
					sharkStart = new Point(i,j,0);
					sharkSize = 2;
					map[i][j] = 0;
				}
			}
		}
		
		eat = 0;
		pq = new PriorityQueue<>((o1, o2) -> {
			// 걸리는 시간이 같다면
			if(o1.time == o2.time) {
				if(o1.i == o2.i) { // 행이 같으면 왼쪽이 먼저
					return o1.j - o2.j;
				}
				else { // 위에 있는거 먼저
					return o1.i - o2.i;
				}
			}
			// 시간이 짧은 거 먼저
			else {
				return o1.time - o2.time;
			}
		});
		while(true) {
			
			// 먹을 수 있는 물고기 확인
			bfs(sharkStart);
			
			if(pq.isEmpty()) { // 먹을 수 있는 상어가 없다면
				break;
			}
			
			// pq에 들어있는 애 중에 가장 먼저 꺼내는 애가 다음에 먹을 물고기
			sharkStart = pq.poll();
			map[sharkStart.i][sharkStart.j] = 0;
			pq.clear(); // 다음에 갈 애 찾았으니 비워주기
			
			eat++;
			
			if(eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
			//System.out.println("time: "+time);
			time += sharkStart.time;
		}
		
		System.out.println(time);
	}
	
	// BFS 돌면서 먹을 수 있는 상어 위치 다 pq에 넣기
	static void bfs(Point start) {
		//System.out.println(start.i+" "+start.j);
		boolean[][] visited = new boolean[n][n];
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start.i, start.j, 0));
		visited[start.i][start.j] = true;
		
		// 맵 돌면서 먹을 수 있는 애들은 pq에 넣고 유지
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nexti = now.i+di[d];
				int nextj = now.j+dj[d];
				
				// 맵 내에 있고 방문하지 않은 곳이라면
				if(nexti>=0 && nexti<n && nextj>=0 && nextj<n
						&& !visited[nexti][nextj] && map[nexti][nextj]<=sharkSize) {
					
					// 그러다가 아기상어 크기보다 작은 애라면 pq에 넣어주기
					if(map[nexti][nextj]<sharkSize && map[nexti][nextj]!=0) {
						//System.out.println("먹이발견: "+map[nexti][nextj]+" "+sharkSize);
						pq.add(new Point(nexti, nextj, now.time+1));
					}
					
					queue.add(new Point(nexti, nextj, now.time+1));
					visited[nexti][nextj] = true;
				}
			}
		}
		
		
	}
	
	static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static class Point{
		int i,j,time;

		public Point(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
	}
}
