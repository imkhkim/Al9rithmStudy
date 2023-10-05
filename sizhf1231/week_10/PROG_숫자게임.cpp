#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    int idxA = 0;
    for (int idxB = 0; idxB < B.size(); idxB++) {
        if (A[idxA] < B[idxB]) {
            idxA++;
            answer++;
        }
    }
    
    return answer;
} // B를 우선순위 큐에 넣고 빌 때 까지 꺼내보면서 확인하는 방법도 가능할 듯
