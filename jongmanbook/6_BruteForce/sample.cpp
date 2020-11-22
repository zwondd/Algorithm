#include <iostream>
#include <vector>

using namespace std;

// pick m out of n number

void printPicked (vector<int>& picked) {

    for(auto it=picked.begin(); it!=picked.end(); it++) {
        cout<<*it<<" ";
    }
    cout<<endl;
};

void pick(int n, vector<int>& picked, int toPick){
    if ( toPick == 0 ) {
        printPicked(picked);
        return;
    }

    int smallest = picked.empty() ? 1: picked.back()+1;

    for(int next=smallest; next<=n; next++) {
        picked.push_back(next);
        pick(n, picked, toPick-1);
        picked.pop_back();
    }
};

int main(void) {

    vector<int> picked;
    pick(6, picked, 4);


    return 0;
}

