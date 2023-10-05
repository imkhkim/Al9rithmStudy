#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    
    priority_queue<int> maxPQ, minPQ;
    int cnt = 0; // 이중 우선순위 큐에 들어있는 숫자 개수
    
    for (int i = 0; i < operations.size(); i++) {
        string oper = operations[i];
        if (oper[0] == 'I') {
            int num = stoi(oper.substr(2, oper.size() - 1)); // I 16인 경우 16을 정수로 변환해서 반환
            maxPQ.push(num);
            minPQ.push(-num); // 넣을 때 -를 붙여서 넣고, 꺼낼 때 다시 -를 붙여서 꺼내면 minHeap으로 사용 가능
            cnt++; // 삽입 후 숫자 개수 증가
        } else if (oper[0] == 'D') {
            if (cnt == 0) { // 빈 큐에 데이터를 삭제하라는 연산이 주어진 경우
                continue; // 해당 연산 무시
            }
            
            if (oper[2] == '-') { // 최솟값 삭제
                minPQ.pop();
            } else { // 최댓값 삭제
                maxPQ.pop();
            }
            cnt--; // 삭제 후 숫자 개수 감소
            
            // 입력 > ["I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"]
            // 출력 > [6, 5]
            // 삭제 연산을 한 쪽 우선순위 큐에서만 진행하므로, 
            // 숫자 개수가 0으로 감소했을 때 모든 큐를 비워줘야 한다.
            if (cnt == 0) {
                // while(!maxPQ.empty()) maxPQ.pop();
                // while(!minPQ.empty()) minPQ.pop();
                maxPQ = priority_queue<int>();
                minPQ = priority_queue<int>();
            }
        }
    }
    
    if (cnt == 0) {
        answer.push_back(0);
        answer.push_back(0);
    } else {
        answer.push_back(maxPQ.top());
        answer.push_back(-minPQ.top());
    }
    
    return answer;
}
