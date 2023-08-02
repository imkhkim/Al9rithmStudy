import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class File implements Comparable<File>{
	String extension;
	
	File (String e) {
		this.extension = e;
	}

	@Override
	public int compareTo(File o) {
		return this.extension.compareTo(o.extension); // 확장자 이름 사전 순 정렬
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		File[] files = new File[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), "."); // 구분자 .을 기준으로 나누기
			st.nextToken(); // 파일 이름 버리기
			files[i] = new File(st.nextToken());
		}
		
		Arrays.sort(files);

		String[] ext = new String[N]; // 확장자 이름 저장 배열
		int[] exts = new int[N]; // 확장자 이름 별 개수 저장 배열
		int cntExt = 0; // 총 확장자 개수
		int cnt = 1; // 확장자 이름 별 개수
		for (int i = 0; i < N - 1; i++) {
			if (files[i].extension.equals(files[i + 1].extension)) {
				cnt++;
			} else {
				ext[cntExt] = files[i].extension;
				exts[cntExt] = cnt;
				cntExt++;
				cnt = 1;
			}
		}
		ext[cntExt] = files[N - 1].extension;
		exts[cntExt] = cnt;
		cntExt++;
		
		for (int i = 0; i < cntExt; i++) {
			System.out.println(ext[i] + " " + exts[i]);
		}
	} // main
}
