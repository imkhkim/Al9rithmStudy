#include <string>
#include <vector>

using namespace std;

long cnt[50001]; // int면 효율성 테스트 통과 X. 왜 long이어야 하지?

long long solution(int n, vector<int> works) {
    long long answer = 0;
    
    for (int i = 0; i < works.size(); i++) {
        cnt[works[i]]++; // 남은 일의 작업량 별 개수 카운트
    }
    
    for (int i = 50000; i >= 1; i--) {
        if (n == 0) break; // 남은 시간이 없으면 종료
             
        if (cnt[i] == 0) continue;
        
        if (cnt[i] <= n) {
            n -= cnt[i];
            cnt[i - 1] += cnt[i];
            cnt[i] = 0;
        } else { // cnt[i] > n
            cnt[i - 1] += n;
            cnt[i] -= n;
            n = 0;
        }
    }
    
    for (int i = 1; i <= 50000; i++) {
        answer += cnt[i] * i * i;
    }
    
    return answer;
}
