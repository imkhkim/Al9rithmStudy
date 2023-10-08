#include <iostream>

using namespace std;

// dp테이블에 미리 올바른 괄호 문자열의 개수를 계산
// 홀수는 정답이 0이기 때문에 계산 X
// 카탈란 수를 팩토리얼 계산이 아닌 dp 테이블로 구함
// 카탈란 수 Cn의 일반항 : (2n)! / ((n!)^2 * (n + 1))

long long dp[5001];

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    dp[0] = 1;
    dp[2] = 1;
    for (int i = 4; i <= 5000; i += 2)
    {
        for (int j = 0; j < i; j += 2)
        {
            dp[i] += dp[j] * dp[i - 2 - j];
            dp[i] %= 1000000007;
        }
    }

    int T;
    cin >> T;
    for (int tc = 1; tc <= T; ++tc)
    {
        int L;
        cin >> L;
        cout << dp[L] << '\n';
    }

    return 0;
}
