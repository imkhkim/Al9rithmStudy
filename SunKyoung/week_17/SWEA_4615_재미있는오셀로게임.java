import java.util.*;
import java.io.*;

public class Solution {
	static int N,M;
	static int[][] board;
	static int cnt1, cnt2;
	static int[] di = {-1,1,0,0,-1,-1,1,1}; //상하좌우 위왼 위오 아래왼 아래위
	static int[] dj = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			cnt1 = 0;
			cnt2 = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 보드 NxN 크기
			M = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수
			
			board = new int[N][N]; // 1:흑돌, 2:백돌
			// 초기 세팅
			board[N/2-1][N/2-1] =2;
			board[N/2-1][N/2] = 1;
			board[N/2][N/2-1] = 1;
			board[N/2][N/2] =2;
			
			// 돌 놓기
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				board[x-1][y-1] = color;
				
				check(x-1,y-1); // 색 변경할 돌있는지 체크
			}
			
			count();
			sb.append("#"+tc+" "+cnt1+" "+cnt2).append("\n");
			
		} //테스트케이스 종료
		//print();
		System.out.println(sb);

	}
	
	// 각 돌의 개수 세기
	static void count() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j]==1) cnt1++;
				else if(board[i][j]==2) cnt2++;
			}
		}
	}
	
	// 색 변경이 필요하면 변경해주기
	static void check(int starti, int startj) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.add(new Point(starti, startj));
		visited[starti][startj] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int d=0; d<8; d++) {
				int nexti = now.i+di[d];
				int nextj = now.j+dj[d];
								
				// 보드 내에 있다면
				boolean flag = false; // 1221이런식으로 나왔는지 체크할 변수 , 1222와 구분되어야 함
				while(nexti>=0 && nexti<N && nextj>=0 && nextj<N) {
					// 빈 곳이라면 탐색 중지
					if(board[nexti][nextj]==0) break;
					
					// 같은 색 돌나오면 탐색 중지. 같은 돌사이에 다른돌이 있을 때 뒤집어야 함
					if(board[nexti][nextj]==board[starti][startj]) {
						flag = true;
						break;
					}
					nexti += di[d];
					nextj += dj[d]; 
				}
				
				//System.out.println("뒤집기 시작전");
				//System.out.println("nexti: "+nexti+" nextj: "+nextj);
				// 뒤집기 진행
				while(flag) {
					// 좌표가 그대로라면 뒤집을 돌 없음
					if(starti==nexti && startj==nextj) break;
					
					// 돌 색 변경, 1221일 때, 맨 뒤에서부터 시작돌과 같은 색으로 만들기 진행
					board[nexti][nextj] = board[starti][startj]; 
					nexti -= di[d];
					nextj -= dj[d];
					//System.out.println("nexti: "+nexti+" nextj: "+nextj);

				}
				
			}
		}
	}
	
	static class Point{
		int i, j;
		
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
