#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(vector<int> a, vector<int> b) {
    return a[1] < b[1];
}

int solution(vector<vector<int>> routes) {
    sort(routes.begin(), routes.end(), compare); // 진출 지점을 기존으로 오름차순 정렬
    
    int answer = 1; // 카메라 하나는 무조건 설치
    int lastCamera = routes[0][1]; // 최초 차량의 진출 지점에 첫 번째 카메라 설치
    
    for (int i = 1; i < routes.size(); i++) {
        if (routes[i][0] <= lastCamera) continue;
        
        // 마지막 카메라 설치 지점보다 i번째 차량의 진입 지점이 뒤에 있음
        lastCamera = routes[i][1]; // 마지막 카메라 설치 지점을 i번째 차량의 진출 지점으로 교체
        answer++;
    }
    
    return answer;
}
