#include <iostream>

using namespace std;

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long dp[101][101];

    dp[0][0] = 0;
    for (int i = 1; i <= 100; ++i)
    {
        dp[0][i] = dp[i][0] = 1;
    }
    for (int i = 1; i <= 100; ++i)
    {
        for (int j = 1; j <= 100; ++j)
        {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            if (dp[i][j] > 1000000000)
            {
                dp[i][j] = 1000000000;
            }
        }
    }

    int N, M, K;
    cin >> N >> M >> K;

    if (dp[N][M] < K)
    {
        cout << -1;
        return 0;
    }

    string ans;

    while (true)
    {
        if (N == 0)
        {
            for (int i = 0; i < M; ++i)
                ans += 'z';
            break;
        }
        else if (M == 0)
        {
            for (int i = 0; i < N; ++i)
                ans += 'a';
            break;
        }

        if (K <= dp[N - 1][M])
        {
            ans += 'a';
            --N;
        }
        else // K > dp[N - 1][M]
        {
            ans += 'z';
            K -= dp[N - 1][M];
            --M;
        }
    }

    cout << ans;

    return 0;
}
