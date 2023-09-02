import java.util.*;
import java.io.*;

public class BOJ_1325_효율적인해킹 {
	static ArrayList<Integer>[] arrayList;
	static boolean[] visited;
	static int[] visitedCheck;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //정점의 개수 - 컴퓨터 번호
		int M = Integer.parseInt(st.nextToken()); //간선의 개수 - 신뢰하는 관계
		arrayList = new ArrayList[N+1];
		visitedCheck = new int[N+1];
		for(int i=1; i<=N; i++) {
			arrayList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arrayList[a].add(b);
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			dfs(i);
		}
		
		int max = 0;
		// 가장 많이 방문한 노드의 방문 개수
		for(int i=1; i<=N; i++) {
			max = Math.max(max, visitedCheck[i]);
		}
		
		// 가장 많은 컴퓨터를 해킹할 수 있는 번호들 출력 - 오름차순
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(max == visitedCheck[i])
				sb.append(i+" ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int now) {
		visited[now] = true;
		
		for(int n: arrayList[now]) {
			if(!visited[n]) {
				visitedCheck[n]++;
				dfs(n);
			}
		}
	}
}
