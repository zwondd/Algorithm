/*
    191020
    LG codepro - [19년도_2차] 재고관리 (30점)
    - 미완성
 */
#include <iostream>
using namespace std;

int N;//제품 수
int M;//제품 종류 수
int ID[100000 + 10];//제품 ID
int id_cnt[100000 + 10 ]={0,};


void InputData(){
	int i;
	cin >> N >> M;
	for(i = 1; i <= N; i++){
		cin >> ID[i];
	}
}
int main(){
	int ans = 0;
	int flag=1, min=1, min_maxIdx=0;

	InputData();//입력 함수
	
	//	코드를 작성하세요
	for(int i=1; i<=N; i++) {
		id_cnt[ID[i]]++;
	}
	min_maxIdx=N;
	
	while( min<M ) {
		// cout<<"flag : "<<flag;
		for( int i=min_maxIdx; i>=1; i-- ) {
			if ( ID[i] == min ) {
				min_maxIdx = i;
				break;
			}
		}
		// cout<<"  min_mxIdx : "<<min_maxIdx<<" min : "<<min;
		for( int j=0; j<id_cnt[min]; j++ ) {
			if ( ID[flag+j] != min ) {
				int temp = ID[flag+j];
				ID[flag+j] = min;
				ID[min_maxIdx] = temp;
				ans+=2;
				id_cnt[min]--;
				flag++;
				min_maxIdx--;
				break;
			}
		}
	//cout<<" id_cnt[min] : "<<id_cnt[min]<<" flag : "<<flag<<"  min_mxIdx : "<<min_maxIdx<<endl;
		// if ( id_cnt[min] == 0 ) {
		// 	min++;		
		// 	min_maxIdx = N;
		// }
		if( id_cnt[min] == 1 ) {
			min++;
			min_maxIdx=N;
		}
			
		//cout<<" ans : "<<ans<<" id_cnt[min] : "<<id_cnt[min]<<" flag : "<<flag<<endl;
		
		
	}
	

	cout << ans << endl;
	return 0;
}