import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		int count = 0; // 쌍의 개수
		
		// 수열 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// x
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(nums);
		
		int start = 0;
		int end = nums.length-1;
		int sum = 0;
		while(start < end) {
			sum = nums[start] + nums[end];
			
			if(sum < x) {
				start++;
			}
			else if(sum > x) {
				end--;
			}
			else {
				count++;
				end--;
			}
		}
		
		System.out.println(count);

	}
}
