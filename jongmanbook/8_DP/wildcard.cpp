#include <iostream>
#include <string>

using namespace std;

bool match(const string& w, const string& s) {
    int pos=0;
    while( pos<s.size() && pos<w.size() && (w[pos] == '?' || w[pos] == s[pos] )  ) {
        ++pos;
    }

    if ( pos == w.size() ) {
        return pos==s.size();
    }

    if ( w[pos] == '*' ) {
        for(int skip=0; pos+skip<=s.size(); ++skip) {
            if ( match(w.substr(pos+1), s.substr(pos+skip))) {
                return true;
            }
        }
    }
    return false;
};

// apply memoization
int cache[101][101];

string W, S;
// -1 : not calculated
// 1 : matched
// 0 : not matched
bool matchMemoized(int w, int s) {
    int& ret = cache[w][s];
    if ( ret!=-1 ) 
        return ret;

    while(s<S.size() && w<W.size() && (W[w] == '?' || W[w] == S[s]) ) {
        ++s;
        ++w;
    }

    if ( w==W.size() )
        return ret = (s==S.size());

    if ( W[w] == '*' ) {
        for(int skip=0; s+skip<=S.size(); ++skip ) {
            if ( matchMemoized(w+1, s+skip) ) {
                return ret=1;
            }
        }
    }

    return ret=0;
}

// enhanced recursive function
bool matchMemoized2(int w, int s) {
    int& ret = cache[w][s];
    if ( ret!=-1 ) 
        return ret;

    while(s<S.size() && w<W.size() && (W[w] == '?' || W[w] == S[s]) ) {
        return ret=matchMemoized2(w+1, s+1); // changed
    }

    if ( w==W.size() )
        return ret = (s==S.size());

    if ( W[w] == '*' ) {
        // for(int skip=0; s+skip<=S.size(); ++skip ) {
        //     if ( matchMemoized(w+1, s+skip) ) {
        //         return ret=1;
        //     }
        // }

        // changed
        if ( matchMemoized2(w+1, s) || (s<S.size() && matchMemoized2(w, s+1) ) ) {  // or 문 두번 째 조건은 wildcard가 마지막까지 *일 경우
            return ret=1;
        }
    }
    return ret=0;
}


int main(void) {
    int tc=0, n=0;
    string wildcard;

    cin>>tc;

    for(int j=0; j<tc; j++) {
        cin>>wildcard;
        cin>>n;

        for(int i=0; i<n; i++) {
            string word;
            cin>>word;
            if ( match( wildcard, word ) == true ) {
                cout<<word;
            }
        }
    }    
    
}