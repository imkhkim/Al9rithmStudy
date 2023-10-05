#include <iostream>

using namespace std;

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    for (int tc = 1; tc <= T; ++tc)
    {
        string s;
        cin >> s;

        int front = 0;
        int rear = s.length() - 1;
        bool isPal = true;
        bool removed = false;
        bool retry = false;
        bool done = false;
        int saveFront;
        int saveRear;

        while (front < rear)
        {
            if (s[front] != s[rear]) // 다른 경우 검사
            {
                if (retry) // 돌아가서 다른걸 지워봐야 하는 경우
                {
                    if (done)
                    {
                        isPal = false;
                        break;
                    }

                    done = true;
                    front = saveFront;
                    rear = saveRear;
                    continue;
                }

                if (removed == true) // 다른데 이미 한 문자를 지운적이 있으면
                {
                    isPal = false;
                    break;
                }

                if (s[front + 1] == s[rear] && s[front] == s[rear - 1]) // 앞에서 지워도 되고 뒤에서 지워도 되는 경우 둘 다 확인
                {
                    retry = true;
                    removed = true;
                    saveFront = front;
                    saveRear = rear - 1;
                    ++front; // 앞에꺼 먼저 지워보기
                }
                else if (s[front + 1] == s[rear]) // 앞에서 하나 지워야 하는 경우
                {
                    removed = true;
                    ++front;
                }
                else if (s[front] == s[rear - 1]) // 뒤에서 하나 지워야 하는 경우
                {
                    removed = true;
                    --rear;
                }
                else // 앞이나 뒤에서 지워도 회문이 될 수 없는 경우
                {
                    isPal = false;
                    break;
                }
            }

            ++front;
            --rear;
        }

        if (isPal)
        {
            if (!removed) // 그 자체로 회문
                cout << "0\n";
            else // 유사회문
                cout << "1\n";
        }
        else // 그 외
        {
            cout << "2\n";
        }
    }
}
