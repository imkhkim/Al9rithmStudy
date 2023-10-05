import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int connectedNode, dist;
		Node(int connectedNode, int dist) {
			this.connectedNode = connectedNode;
			this.dist = dist;
		}

	} // Node
	
	static class D  implements Comparable<D>{
		int distV, v;
		D (int distV, int v) {
			this.distV = distV;
			this.v = v;
		}
		
		@Override
		public int compareTo(D o) {
			return this.distV - o.distV;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] vec = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			vec[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			vec[u].add(new Node(v, w));
		}
		
		int[] dist = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<D> PQ = new PriorityQueue<>();
		
	    dist[K] = 0; // 시작점으로의 거리는 0
	    PQ.add(new D(0, K)); // 시작점만 PQ에 넣고 시작
	    while(!PQ.isEmpty()) { // PQ가 비면 종료
	        int curNode;
	        
	        do{
	        	curNode = PQ.poll().v;
	        } while(!PQ.isEmpty() && visited[curNode]); // curNode가 방문한 정점이면 무시

	        if(visited[curNode]) break; // 더 이상 방문할 수 있는 정점이 없으면 종료
	        
	        visited[curNode] = true;
	        for (int i = 0; i < vec[curNode].size(); i++) {
	        	int nxt = vec[curNode].get(i).connectedNode;
	        	int d = vec[curNode].get(i).dist;
	        	
	        	if (dist[nxt] > dist[curNode] + d) {
	        		dist[nxt] = dist[curNode] + d;
	        		PQ.add(new D(dist[nxt], nxt));
	        	}
	        }
	    } // while
		
	    for(int i = 1; i <= V; i++) {
	    	if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
	        else sb.append(dist[i]).append("\n");
	    }
	    
	    System.out.println(sb);
	} // main
} // class
