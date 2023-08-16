import java.util.*;
import java.io.*;

public class BOJ_1253_좋다 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] nums = new int[N];
		
		// 수 입력받아 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int count = 0; //좋다 개수
		for(int i=0; i<N; i++) {
			int num = nums[i]; // 좋다인지 판별할 수
			int start = 0;
			int end = nums.length-1;
			
		
			while(start<end) { // 다른 두 수의 합이므로 start가 end가 되기 전까지
				int sum = nums[start]+nums[end]; // 두 수의 합
				
				if(sum<num) {
					start++;
				}
				else if(sum>num) {
					end--;
				}
				else { // 좋다(GOOD)
					// 좋다를 조합하는 수의 자기자신은 포함x
					if(i==start) start++;
					else if(i==end) end--;
					else {
						count++;
						break;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
