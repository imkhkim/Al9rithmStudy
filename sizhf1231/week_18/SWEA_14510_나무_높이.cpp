#include <iostream>
#include <algorithm>
 
using namespace std;
 
int N, maxHeight, cntSumOdd, cntSumEven, sumDiff, cntChange, ans;
int height[100];
int diff[100];
int cntOdd[100];
int cntEven[100];
 
int main(int argc, char** argv)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int test_case;
    int T;
     
    // freopen("input.txt", "r", stdin);
 
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        maxHeight = 0;
        cntSumOdd = 0;
        cntSumEven = 0;
 
        cin >> N;
 
        // 1. 최댓값 갱신하면서 나무 높이 입력 받기
        for (int i = 0; i < N; ++i)
        {
            cin >> height[i];
            maxHeight = max(maxHeight, height[i]);
        }
 
        for (int i = 0; i < N; ++i)
        {
            // 2. 최대 나무 높이와의 높이차 계산
            diff[i] = maxHeight - height[i];
 
            // 3. 최대 나무 높이와 같아지기 위해 필요한 짝수 날과 홀수 날 계산 (짝수가 최대한 많도록 계산)
            cntEven[i] = diff[i] >> 1; // 차이 / 2가 짝수 개수
            cntOdd[i] = (diff[i] & 1) ? 1 : 0; // 차이가 홀수면 홀수 개수는 1개
 
            cntSumOdd += cntOdd[i];
            cntSumEven += cntEven[i];
        }
 
        // 4. 짝수 날과 홀수 날의 개수 조정
        if (cntSumEven > cntSumOdd + 1) // 짝수 날이 홀수 날보다 2 이상 큰 경우에만 조정
        {
            sumDiff = cntSumEven - cntSumOdd;
            cntChange = sumDiff / 3; // 바꾸는 횟수는 차이 / 3
            if (sumDiff % 3 == 2) // 나머지가 2면 한 번 더 바꾸기
            {
                ++cntChange;
            }
 
            cntSumEven -= cntChange;
            cntSumOdd += cntChange << 1;
        }
 
        // 필요한 최소 날짜 계산
        ans = cntSumOdd + cntSumEven; // 홀수 날과 짝수 날의 개수가 같은 경우
        if (cntSumOdd < cntSumEven) // 짝수 날이 홀수 날보다 많은 경우 (여기까지 오면 짝수 날이 1개만 더 많은 경우만 있음)
        {
            ++ans;
        }
        else if (cntSumOdd > cntSumEven) // 홀수 날이 짝수 날보다 많은 경우 (홀수 날이 짝수 날보다 2개 이상 많은 경우만 바뀜)
        {
            ans += cntSumOdd - cntSumEven - 1;
        }
 
        cout << '#' << test_case << ' ' << ans << '\n';
    }
 
    return 0;
}
