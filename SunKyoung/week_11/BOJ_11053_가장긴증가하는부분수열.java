import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 수열 A의 크기
		int[] arr = new int[N];
		int[] len = new int[N]; // 해당 인덱스에서 끝나는 최장 부분 수열 길이
		
		// 수열 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			len[i] = 1; // 자기자신만 있는 길이로 세팅
			
			for(int j=0; j<i; j++) {
				// arr[i] 보다 작은 애가 앞에 있다면 len[j]+1 한 길이와 원래 길이 중에 더 큰걸로 변경
				if(arr[j] < arr[i]) {
					len[i] = Math.max(len[i], len[j]+1);
				}
			}
		}
		
		Arrays.sort(len);
		
		System.out.println(len[N-1]);
	}

}
