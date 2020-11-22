#include <iostream>
#include <string>

using namespace std;

#define MAX_MAP 5

int board[MAX_MAP][MAX_MAP];
int used[MAX_MAP][MAX_MAP]={0,};

int dx[8] = {-1, -1, -1, 1, 1, 1, 0, 0};
int dy[8] = {0, 0, 0, 0, 0, 0, 1, -1};

bool inRange(int y, int x) {

};

bool hasWord(int y,int x, const string& word) {

    if ( !inRange(y,x) ) return false;
    if ( board[y][x] != word[0] ) return false;

    if ( word.size() == 1 ) return true;

    for(int direction=0; direction<8; direction++) {
        int ny = y + dy[direction];
        int nx = x + dx[direction];

        if ( hasWord(ny, nx, word.substr(1)) ) {
            return true;
        }
    }
    return false;
};