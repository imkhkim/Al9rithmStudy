package oh3823.week_17;

import java.util.*;

class UserSolution {
    private int N, M;
    private TreeSet[] set;
    private HashSet<String> selected;
    private List<Integer> players;

    public void init(int N, int M, char[][] mWords) {

        this.N = N; // 플레이어의 수
        this.M = M; // 단어의 개수

        this.players = new ArrayList<>(N + 1);

        for (int i = 0; i < N; i++)
            this.players.add(i + 1);

        this.selected = new HashSet<>(); // 선택된 단어 등록

        this.set = null;

        this.set = new TreeSet[26];

        for (int i = 0; i < 26; i++)
            this.set[i] = new TreeSet<String>();

        String word;
        for (int i = 0; i < M; i++) {
            if (mWords[i][0] == '\0') break;
            word = String.valueOf(mWords[i]).trim();
            this.set[word.charAt(0) - 'a'].add(word);
        }

        /*
         * 1. 시작으로 주어지는 단어 리스트를 모두 Map에 등록
         * Map은 시작 글자의 개수만큼. 예를 들어 map[a] 라고 하면 a로 시작하는 단어를 저장한 map이 된다.
         */

    }

    public int playRound(int mID, char mCh) {
        // mID: 시작 플레이어
        // mCh: 플레이어가 선택해야할 시작 문자

        int index = players.indexOf(mID);
        Iterator<Integer> it = players.listIterator(index);

        int player = it.next();
        char last = mCh;

        List<String> sel = new ArrayList<>(); // 이 라운드에서 선택된 단어들을 뒤집어서 저장할 리스트

        while (true) {
            if (set[last - 'a'].isEmpty()) {
                it.remove(); // 탈락
                for (String rword : sel) {
                    if (!selected.contains(rword)) // 선택된 적이 없는 단어만 투입
                        set[rword.charAt(0) - 'a'].add(rword);
                }

                break;
            }

            String word = (String) set[last - 'a'].pollFirst();
            selected.add(word);
            sel.add(new StringBuilder(word).reverse().toString());

            if (!it.hasNext())
                it = players.listIterator();

            player = it.next();

            last = word.charAt(word.length() - 1);
        }

        return player;
    }

}
