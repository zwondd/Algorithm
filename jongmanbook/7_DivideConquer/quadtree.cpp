#include <iostream>
#include <string>

using namespace std;

string reverse(string::iterator& it) {
    char head = *it;
    ++it;
    if ( head=='b' || head=='w' ) {
        return string(1, head);
    }
    string upperLeft = reverse(it);
    string upperRight = reverse(it);
    string lowerLeft = reverse(it);
    string lowerRight = reverse(it);

    return string("x") + lowerLeft + lowerRight + upperLeft + upperRight;
}

int main(void) {
    int tc;
    cin>>tc;
    while(tc--) {
        string quadtree;
        cin>>quadtree;

        string::iterator qit = quadtree.begin();
        cout<< reverse(qit) <<endl;
    }

    return 0;
}