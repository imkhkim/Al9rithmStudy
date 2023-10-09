#include <iostream>

using namespace std;

long long fact[21]; // 팩토리얼 미리 계산해둔 배열
int num[21];

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, op;
    cin >> N >> op;

    fact[0] = 1;
    for (int i = 1; i <= N; ++i)
    {
        fact[i] = i * fact[i - 1];
    }

    for (int i = 1; i <= N; ++i)
    {
        num[i] = i;
    }

    if (op == 1)
    {
        long long k;
        cin >> k;
        long long tmp;
        int cnt;
        int idx = 0; // 정답 인덱스
        int ans[21]; // 선택된 숫자 배열

        while (idx < N)
        {
            tmp = fact[N - 1 - idx];
            cnt = 1; // fact[N - 1 - idx]를 몇 번 더했는지 확인

            while (k > tmp)
            {
                tmp += fact[N - 1 - idx];
                ++cnt;
            }

            // 아직 선택하지 않은 수 중 cnt번째 수를 확정
            int chk = 0;
            for (int i = 1; i <= N; ++i)
            {
                if (num[i] == -1)
                    continue;
                ++chk;
                if (chk == cnt)
                {
                    ans[idx++] = num[i];
                    num[i] = -1;
                    break;
                }
            }

            k -= fact[N - idx] * (cnt - 1);
        }
        
        for (int i = 0; i < idx; ++i)
        {
            cout << ans[i] << ' ';
        }
    } // op == 1
    else if (op == 2)
    {
        int tmp[21];
        for (int i = 1; i <= N; ++i)
        {
            cin >> tmp[i];
        }

        int idx = 0;
        long long ans = 1;

        int chk;
        for (int i = 1; i <= N; ++i)
        {
            chk = 0;
            for (int j = 1; j <= N; ++j)
            {
                if (num[j] == -1)
                    continue;

                ++chk;
                if (tmp[i] == num[j])
                {
                    ans += (chk - 1) * fact[N - (++idx)];
                    num[tmp[i]] = -1;
                    break;
                }
            }
        }

        cout << ans;
    } // op == 2

    return 0;
}
