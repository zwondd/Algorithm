/**
 *  19.08.04
 *  willtek - A7 : 긴 자릿수 16진수의 합 
 */

#include <iostream>
#include <stack>
#include <cmath>
using namespace std;

char num1[201];
char num2[201];
char convertedHexa[10000];

int convertToDecimal(char * num) {
    stack <char> S;
    int converted=0;
    // while( num!='\0' ) {
    //     cout<<" num : "<<(*num)<<"\n";  
    //     // cout<<"while"<<"\n";
    //     if ( *num >= 'A' ) {
    //         converted += (*num) - 55;
    //     } else {
    //         converted += (*num);
    //     }
    //     (*num)++;
    // }

    int cnt = 0;
    while( num[cnt] != '\0' ) {
        S.push(num[cnt++]);
    }
    int pos = 0;
    while(!S.empty()) {
        int temp = S.top(); S.pop();
        if ( temp >= 'A' ) 
            temp-=55;
         else 
            temp-='0';
        converted+=pow(16,pos++) * temp;
    }
    // cout<<"converted to decimal : "<<converted<<"\n";
    return converted;
}

void convertToHexa(int num) {
    stack <int> S;
    while( num/16 !=0 ) {
        S.push(num%16);
        // cout<<" pushed int : "<<num%16<<"\n";
        num=num/16;
    }
    S.push(num%16);
    // cout<<" pushed int : "<<num%16<<"\n";


    int cnt=0;
    char hex;
    while(!S.empty()) {
        int temp = S.top(); S.pop();
        if ( temp > 9 )
            hex = temp + 55;
        else 
            hex = temp + '0';
        convertedHexa[cnt++] = hex;
    }
}

int sum(int num1, int num2) {
    return num1+num2;
}

void input() {
    cin>>num1;
    cin>>num2;
}

int main(void) {
    input();
    int x = convertToDecimal(num1);
    int y = convertToDecimal(num2);
    convertToHexa(sum(x,y));
    cout<<convertedHexa<<"\n";

    return 0;
}