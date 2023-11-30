#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string s;
int idx[200]; // idx[x] : s의 인덱스x에 있는 괄호의 번호
vector<int> vec; // 닫아야 하는 괄호 번호 (스택으로 구현해도 됨)
int tmpNum, isEnd, cnt;
bool selected[10];
string res[1025];

void subset(int num)
{
	if (num == isEnd)
	{
		string tmp;
		for (int i = 0; i < s.length(); ++i) // 문자열을 하나씩 확인
		{
			if (s[i] == '(' || s[i] == ')') // 괄호인 경우에
			{
				if (!selected[idx[i]]) // 지금 보고있는 괄호가 뽑히지 않았으면 추가
				{
					tmp.push_back(s[i]);
				}
			}
			else // 괄호가 아니면 그냥 추가
			{
				tmp.push_back(s[i]);
			}
		}

		res[cnt++] = tmp;
		
		return;
	}

	selected[num] = true;
	subset(num + 1);
	selected[num] = false;
	subset(num + 1);
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> s;

	// 괄호에 번호 붙이기
	for (int i = 0; i < s.length(); ++i)
	{
		if (s[i] == '(')
		{
			idx[i] = tmpNum; // tmpNum : 붙여야 하는 괄호 번호
			vec.push_back(tmpNum);
			++tmpNum;

			isEnd = max(isEnd, tmpNum);
		}
		else if (s[i] == ')')
		{
			idx[i] = vec.back();
			vec.pop_back();
		}
	}

	subset(0);
	
	sort(res, res + cnt);

	for (int i = 1; i < cnt; ++i)
	{
		if (res[i] != res[i + 1])
		{
			cout << res[i] << '\n';
		}
	}

	return 0;
}
