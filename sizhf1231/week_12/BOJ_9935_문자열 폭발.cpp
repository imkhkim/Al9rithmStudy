#include <iostream>
#include <cstring>

using namespace std;

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string a, b;
    cin >> a >> b;
    int aLen = a.length();
    int bLen = b.length();
    string tmp = "";
    for (int i = 0; i < b.length() - 1; ++i)
    {
        tmp += a[i];
    }

    for (int i = b.length() - 1; i < a.length(); ++i)
    {
        tmp += a[i];

        for (int j = 0; j < bLen; ++j)
        {
            if (tmp[tmp.length() - bLen + j] != b[j]) // 폭발 문자열이 아닌 경우
            {
                break;
            }
            else if (j == bLen - 1) // 폭발 문자열인 경우
            {
                tmp.erase(tmp.end() - bLen, tmp.end());
            }
        }
    }

    if (!tmp.empty()) cout << tmp;
    else cout << "FRULA";

    return 0;
}
