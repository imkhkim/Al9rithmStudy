#include <string>
#include <vector>
#include <queue>

using namespace std;

struct WORD {
    string word;
    int step;
};

string beginWord, targetWord;
vector<string> wordList;

bool isValid(string w1, string w2) {
    int cntDiff = 0;
    
    for (int i = 0; i < w1.length(); i++) {
        if (w1[i] != w2[i]) cntDiff++;
        if (cntDiff >= 2) return false;
    }
    
    return true;
}

int bfs() {
    queue<WORD> Q;
    Q.push({beginWord, 0});
    
    while (!Q.empty()) {
        WORD cur = Q.front(); Q.pop();
        
        for (int i = 0; i < wordList.size(); i++) {
            
            // 2 개 이상 다르면 continue
            if (!isValid(cur.word, wordList[i])) continue;
            
            // 찾았으면 최소 단계 return
            if (wordList[i] == targetWord) return (cur.step + 1);
            
            Q.push({wordList[i], cur.step + 1});
        }
    }
    
    return 0;
}


int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    
    // target이 words 안에 없는 경우 예외처리
    for (int i = 0; i < words.size(); i++) {
        if (target == words[i]) {
            break;
        }
        
        if (i == words.size() - 1) {
            return 0;
        }
    }
    
    for (int i = 0; i < words.size(); i++) {
        wordList.push_back(words[i]);
    }
    
    beginWord = begin;
    targetWord = target;
    
    answer = bfs();
    
    return answer;
}
