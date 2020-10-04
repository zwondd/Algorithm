/*
    201004
    Leetcode Easy 
    14_LongestCommonPrefix
*/
#include <string>
#include <algorithm> 
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
      
        int minLen=987654321;
        bool search=true;
        string retStr="";

        // Runtime Error -> strs 벡터 사이즈에 대한 언급 없었으므로, 0일때도 체크해줘야함.
        if ( strs.size()==0 ) 
            return retStr;
        
        for(int i=0; i<strs.size(); i++) {
            minLen = min( minLen, (int)strs[i].size() );
        }
        
        for(int i=0; i<minLen; i++) {
            // 2차원 배열로 접근시 memory usage 는 1MB 늘었지만 runtime 4ms 감소됨
            // char currentChar = strs.front()[i];
            char currentChar = strs[0][i];

            for( int j=0; j<strs.size(); j++ ) {
                // 임시변수 선언하지 않고 바로 vector 의 string원소에 접근시 memory, runtime 모두 감소됨.
                // string temp = strs[j];
                if ( strs[j][i] != currentChar ) {
                    search=false;
                    break;
                }
            }
            
            if (!search) 
                break;
            
            retStr += currentChar;
        }
      
        return retStr;
    }
};

//   string first=strs.back();
//         strs.pop_back();
//         int idx=0;
//         string retStr="";
//         bool search=true;
                
//         while(search) {
//             vector<string>::iterator it;
//             for( it=strs.begin(); it!=strs.end(); it++) {
//                 if ( first[idx] == '\0'  || it->at(idx)=='\0' || it->at(idx)!=first[idx] ) {
//                     search=false;
//                     break;
//                 }
//             }
            
//             if (search) {
//                 retStr += it->at(idx);
//                 idx++;
//             }

//         }