import java.util.Scanner;

public class Main {
	
	static int N, rootNode, cnt;
	static int[] parent;
	static boolean[] isVisited;
	
	static void erase(int node) {
		parent[node] = -2;
		for (int i = 0; i < N; i++) {
			if (parent[i] == node) {
				erase(i); // 부모가 지우는 노드이면 자식도 모두 지움
			}
		}
	} // erase
	
	static void leaf(int node) {
		if (parent[node] == -2) return; // 지운 노드면 리턴
		
		isVisited[node] = true; // 방문 표시
		
		boolean isLeaf = true;
		for (int i = 0; i < N; i++) {
			if (parent[i] == node && !isVisited[i]) { // 내가 i의 부모면
				isLeaf = false; // 나는 리프 노드가 아님.
				leaf(i); // 자식이 리프 노드인지 확인
			}
		}
		
		if (isLeaf) {
			cnt++;
		}
	} // leaf
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parent = new int[N];
		isVisited = new boolean[N];
		
		
		for (int i = 0; i < N; i++) {
			parent[i] = sc.nextInt();
			if (parent[i] == -1) { // 루트 노드 따로 저장
				rootNode = i;
			}
		}
		
		erase(sc.nextInt()); // 지우기

		leaf(rootNode); // 루트 노드부터 탐색
		
		System.out.println(cnt);
		
	} // main
} // class
