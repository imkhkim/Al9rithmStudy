#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int p[201];
int answer;

int find(int n){
    if(p[n] < 0) return n;
    return p[n] = find(p[n]);;
}

void merge(int a, int b){
    a = find(a);
    b = find(b);
    if(a == b) return;
    p[b] = a;
    answer--;
}

int solution(int n, vector<vector<int>> computers) {
    fill(p, p + n, -1);
    answer = n;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1) {
                merge(i, j);
            }
        }
    }
    
    return answer;
}
