#include <iostream>
#include <queue>

#define p first
#define d second

using namespace std;

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    priority_queue<pair<int, int>> PQ;
    int n, d, p, ans = 0;
    int visited[10001];
    for (int i = 0; i <= 10000; ++i)
    {
        visited[i] = 0;
    }

    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        cin >> p >> d;
        PQ.push({p, d});
    }

    while (!PQ.empty())
    {
        int idx = PQ.top().d;
        if (visited[idx])
        {
            while(visited[--idx]);
        }

        if (idx != 0)
        {
            visited[idx] = 1;
            ans += PQ.top().p;
        }

        PQ.pop();
    }

    cout << ans;

    return 0;
}
