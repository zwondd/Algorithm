/*
    200922
    Leetcode Easy 
    1 TwoSum
*/

#include <iostream>
#include <vector>
using namespace std;


// Solution_1 Brute Force

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        bool found = false;
        
        for(int i=0; i<nums.size(); i++) {
            for(int j=i+1; j<nums.size(); j++) {
                if ( nums.at(i) + nums.at(j) == target ) {
                    result.push_back(i);
                    result.push_back(j);
                    found = true;
                    break;
                }
            }
            if ( found ) break;
        }
        return result; 
    }
};

// Solution_2 Two Pass Hash Table
#include <unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        /*
            2. 해쉬맵 사용
            - 루프를 돌면서 key에 요소를 저장
        */
       unordered_map<int, int> myMap;
        vector<int> ret;
        
        size_t numSize = nums.size();
        for(size_t i=0; i!=numSize; ++i) {
            int val = target-nums[i];
            if ( myMap.find(val) != myMap.end() ) {
                ret.push_back(i);
                ret.push_back( myMap[val] );
                return ret;
            } else {
                myMap[nums[i]] = i;
            }
        }
    }
};






