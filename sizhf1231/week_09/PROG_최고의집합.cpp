#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    
    if (n > s)
    {
        answer.push_back(-1);
    } 
    else {
        while (n >= 1) {
            answer.push_back(s / n);
            s -= (s / n);
            n--;
        }
    }
    
    return answer;
}
