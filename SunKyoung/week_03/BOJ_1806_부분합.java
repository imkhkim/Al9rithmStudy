import java.io.*;
import java.util.*;

public class BOJ_1806_부분합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		// 합이 S이상이 되는 경우 길이 비교
		while(true) {

			if(sum >= S) {
				
				min = Math.min(min, end-start);
				sum -= nums[start++];
			}
			// end는 미리 다음 포인터로 가있기 때문에 N이 되었을 때가 nums[N-1]이 더해진 상황
			// end가 끝까지 간 상황에서 sum이 S보다 작더라도
			// 더이상 +nums[end] 불가능
			else if(end == N) break;
			else if(sum < S) {
				sum += nums[end++];
			}
		
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);

	}

}
