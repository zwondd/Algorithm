#include <iostream>
#include <cstring>
using namespace std;

int N;							//	모델명의 개수
char str[10010][21];	//	모델명 저장
int vote[10010];  
int nextt[10010];  

void printMax(int num) {
	cout<<str[num]<<" "<<num+1<<" ";
	for(int i=nextt[num]; i!=0; i=nextt[i] ) {
		cout<<i+1<<" ";
	}
	cout<<endl;
}

void Solve() {
	int unique=1;

	for(int i=0; i<N-1; i++) {
		// cout<<" str : " <<str[i]<<endl;
		if ( str[i][0] == 0 ) continue;
		
		int prev = i;
		int cnt = 1;
		
		for(int j=i+1; j<N; j++) {
			// cout<<" j str : "<<str[j]<<" "<<endl;
				if ( str[j][0] == 0 ) continue;
				
				if ( strcmp(str[i], str[j])==0 ) {
						// cout<<" same! " <<endl;
						cnt++;
						nextt[prev] = j;
						prev = j;
						str[j][0] = 0;
						unique=0;
				}
		}
		// str[i][0] = 0;
		vote[i]=cnt;
	}
	
	
	int max, maxi;
	int total=0;
	
	if( unique ) 
		cout<<"unique"<<endl;
	else {
		while(true) {
			max = 1;
			maxi = 0;
			for(int i=0; i<N; i++) {
				if ( vote[i] == -1 ) continue;
				if ( max < vote[i] ) {
					max = vote[i];
					maxi = i;
				}
			}
			// cout<< " max : "<<max <<" maxi : "<<maxi<<endl;
			printMax(maxi);
			total+=max;
			vote[maxi]=-1;
			// cout<<"vote[maxi] : "<<vote[maxi]<<" max: "<<max<<endl;
			
			if ( max== 1 )	break;
			if ( total>= N/2 ) break;
		}
	}
}

void InputData(){
	cin >> N;
	for(int i=0 ; i<N ; i++){
		cin >> str[i];
	}
}

int main(){
	InputData();		//	입력 함수
	Solve();				//	문제 풀이

	return 0;
}
