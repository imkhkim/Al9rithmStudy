import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parent;
	static int[] depth;
	static boolean[] isRoot;
	static List<Integer>[] vec;

	static void init(int curNode, int height, int parentNode) {
		depth[curNode] = height;
		parent[curNode] = parentNode;
		for(int childNode : vec[curNode]) {
			if (childNode == parentNode) continue;
			init(childNode, height + 1, curNode);
		}
	} // init
	
	static int LCA(int u, int v) {
		int depthU = depth[u];
		int depthV = depth[v];
		
		if (depthU < depthV) { // 무조건 u가 더 깊은 노드
			int tmp = depthU;
			depthU = depthV;
			depthV = tmp;
			
			tmp = u;
			u = v;
			v = tmp;
		}
		
		while (depthU > depthV) { // u의 깊이가 v와 같을 때 까지 올린다.
			u = parent[u];
			depthU--;
		}
		
		while (u != v) { // 깊이가 같으므로 두 노드가 다르면 같아질 때 까지 동시에 올린다.
			u = parent[u];
			v = parent[v];
		}
		
		return u;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			depth = new int[N + 1];
			isRoot = new boolean[N + 1];
			Arrays.fill(isRoot, true); // 일단 다 루트라고 가정
			vec = new ArrayList[N + 1];
			for(int i = 1; i <= N; i++) {
				vec[i] = new ArrayList<>();
			}
						
			for(int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				vec[A].add(B);
				isRoot[B] = false; // 부모가 있으면 루트가 아니다.
			}
			
			// 루트 노드 찾기
			int rootNode = 0;
			for(int i = 1; i <= N; i++) {
				if (isRoot[i]) {
					rootNode = i;
					break;
				}
			}
			
			init(rootNode, 0, 0); // 루트의높이:0, 루트의부모:0
			
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
						
			System.out.println(LCA(u, v));
		} // tc
	} // main
} // class
