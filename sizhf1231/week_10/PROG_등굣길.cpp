#include <string>
#include <vector>
#include <cstring>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    // dp 테이블 세팅
    int dp[n + 1][m + 1];
    memset(dp, 0, sizeof(dp));
    dp[1][1] = 1;
    
    // 웅덩이는 -1로 표시
    for (int i = 0; i < puddles.size(); i++) {
        dp[puddles[i][1]][puddles[i][0]] = -1;
    }
    
    // dp 테이블 계산
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (dp[i][j] == -1) continue;
            else if (dp[i][j - 1] == -1 && dp[i - 1][j] == -1) continue; // 왼쪽, 위쪽 다 웅덩이인 경우 
            else if (dp[i][j - 1] == -1) dp[i][j] += dp[i - 1][j]; // 왼쪽만 웅덩이인 경우
            else if (dp[i - 1][j] == -1) dp[i][j] += dp[i][j - 1]; // 위쪽만 웅덩이인 경우
            else dp[i][j] += (dp[i - 1][j] + dp[i][j - 1]) % 1000000007; // 왼쪽, 위쪽 다 웅덩이가 없는 경우
        }
    }
    
    return dp[n][m];
}
