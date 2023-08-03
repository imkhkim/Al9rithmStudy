import java.util.Arrays;
import java.util.Scanner;

class Word implements Comparable<Word> {
	String s;
	
	Word (String s) {
		this.s = s;
	}
	
	@Override
	public int compareTo(Word o) {
		if (this.s.length() != o.s.length()) { // 1. 길이가 짧은 것부터
			return this.s.length() - o.s.length();
		}
		return this.s.compareTo(o.s); // 2. 길이가 같으면 사전 순으로
	}	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Word[] words = new Word[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = new Word(sc.next());
		}
		
		Arrays.sort(words);
		
		for (int i = 0; i < N - 1; i++) { // 중복된 단어 제거
			for (int j = i + 1; j < N; j++) {
				if (words[i].s.equals(words[j].s)) {
					words[j].s = "";
				}
			}
		}
		
		for (Word w : words) {
			if (w.s.equals("")) continue;
			System.out.println(w.s);
		}
	}
}
