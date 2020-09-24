/*
    200924
    Leetcode Easy 
    13_RomanToInteger
*/
#include <unordered_map>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        unordered_map<int,int> symbol;
        symbol['I']=1;
        symbol['V']=5;
        symbol['X']=10;
        symbol['L']=50;
        symbol['C']=100;
        symbol['D']=500;
        symbol['M']=1000;


        // symbol.insert('I', 1);
        // symbol.insert('V', 5);
        // symbol.insert('X', 10);
        // symbol.insert('L', 50);
        // symbol.insert('C', 100);
        // symbol.insert('D', 500);
        // symbol.insert('M', 1000);

        char* p = &s[0];
        int prev = symbol[*p];
        p++;
        int val = prev;
        
        while( *p!='\0' ) {
           if ( prev < symbol[*p] ) {
               val=val+symbol[*p]-prev*2;
           } else {
               val+= symbol[*p];
           }
           prev=symbol[*p]; 
           p++; 
        }
        return val;
        
    }
};