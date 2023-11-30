#include <iostream>
#include <cstring>
 
#define B 1 // black
#define W 2 // white
 
using namespace std;
 
int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
 
int board[9][9];
int N, M;
 
bool dfs(int x, int y, int color, int dir)
{
    int nx = x + dx[dir];
    int ny = y + dy[dir];
 
    if (nx < 1 || nx > N || ny < 1 || ny > N || board[nx][ny] == 0)
        return false;
 
    if (board[nx][ny] == color)
    {
        board[x][y] = color;
        return true;
    }
 
    if (dfs(nx, ny, color, dir))
    {
        board[x][y] = color;
        return true;
    }
    else
    {
        return false;
    }
}
 
int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
 
    int test_case;
    int T;
 
    // freopen("input.txt", "r", stdin);
 
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        cin >> N >> M;
        memset(board, 0, sizeof(board));
        board[N / 2][N / 2] = W;
        board[N / 2 + 1][N / 2 + 1] = W;
        board[N / 2][N / 2 + 1] = B;
        board[N / 2 + 1][N / 2] = B;
 
        for (int i = 1; i <= M; ++i)
        {
            int x, y, color;
            cin >> x >> y >> color;
            board[y][x] = color;
 
            for (int dir = 0; dir < 8; ++dir)
            {
                dfs(y, x, color, dir);
            }
        }
 
        int cntB = 0, cntW = 0;
        for (int i = 1; i <= N; ++i)
        {
            for (int j = 1; j <= N; ++j)
            {
                if (board[i][j] == B)
                    ++cntB;
                else if (board[i][j] == W)
                    ++cntW;
            }
        }
 
        cout << '#' << test_case << ' ' << cntB << ' ' << cntW << '\n';
    }
 
    return 0;
}
