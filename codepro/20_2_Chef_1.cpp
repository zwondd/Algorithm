/*
    201021
    LG codepro - [20년도_2차] chef

    1h30m
    Pass Rate : 3/10 (7개 Timeout)
 */

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <iterator>
using namespace std;

int N;//손님 수
int P[10000 + 10];//음식 값
int T[10000 + 10];//예약 희망 시간

vector<pair<int,int>> sortedTime;

int visited[10000 + 10]; 
int maxCost=-1;
int maxTime;

void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++){
		cin >> P[i];
		cin >> T[i];
	}
}

void getMaxCost(int t, int k, int cost) {
    // cout<<"t : "<<t<<" k : " <<k << endl;
	if ( k>=N ) {
		maxCost = (maxCost<cost)? cost:maxCost;
        cout<<" maxCost : "<<maxCost<<endl;
		return;
	}
	
	for(int i=k; i<N; i++) {
        // cout<<" sortedTime[i].first : "<<sortedTime[i].first<<" sortedTime[i].second : " <<sortedTime[i].second<<endl;

        if ( visited[t] == 0 && sortedTime[i].first>=t ) {
            visited[t] = 1;
            cout<<" visited : "<<sortedTime[i].second << "  time : "<<sortedTime[i].first<< " cost : " << cost+P[sortedTime[i].second] <<endl;
            getMaxCost(t+1, i+1, cost+P[sortedTime[i].second]);
            visited[t] = 0;
        } else if ( visited[t] == 0 && sortedTime[i].first<t ) {
            getMaxCost(t+1, i+1, cost);
        } else if ( visited[t] == 1  ) {
            getMaxCost(t+1, i, cost);
        }
	}
}


int comp(const void* p1, const void* p2) {
	return ((pair<int,int>*)p1)->first > ((pair<int,int>*)p2)->first;
}


void getMaxTime() {
    // cout<<" get Max Time "<<endl;
	for(int i=0; i<N; i++) {
		sortedTime.push_back( make_pair(T[i], i) );
	}
    for(vector<pair<int,int>>::iterator it=sortedTime.begin(); it!=sortedTime.end(); it++ ) {
		// cout<<"i : "<< it->second <<" Time : "<< it->first << endl;
	}

	qsort(&sortedTime[0], N, sizeof(pair<int,int>), comp);
    // cout<<" sorted "<<endl;
	
	for(vector<pair<int,int>>::iterator it=sortedTime.begin(); it!=sortedTime.end(); it++ ) {
		// cout<<"i : "<< it->second <<" Time : "<< it->first << endl;
	}

    maxTime = sortedTime[N-1].first;
    // cout<< " [MAX TIME] "<< maxTime<<endl<<endl;
}

int main(){
	int ans = -1;

	InputData();			//	입력 함수
	
	getMaxTime();

	getMaxCost(1,0,0);

    // cout<<" [MAX COST] " <<maxCost<<endl;
	ans = maxCost;
	cout << ans << endl;	//	정답 출력
	return 0;
}
