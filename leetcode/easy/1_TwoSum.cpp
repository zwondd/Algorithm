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
/*
    to-be continued
*/




