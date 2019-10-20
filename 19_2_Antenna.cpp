/*
    191020
    LG codepro - [19년도_2차] 안테나설치
    - 조건 나열해서 식 완성하기! -> 빠트린 조건 확인
 */

#include <iostream>
using namespace std;

int arr[25];//안테나 커버리지 값을 저장할 배열
int N;//설치할 안테나의 갯수

//작성할 함수
int Antenna_Count(double p1, double p2)
{
	int i, cnt=0;
	double sum=0;
	double upper_len,len;

	len = (p2>p1) ? p2 - p1 : p1-p2;
	//cout<<" len : "<<len<<endl;
	upper_len = len;

	for(i = 0; i < N; i++)
	{
		sum += (double)arr[i];
	}


	if((upper_len > sum + 0.3) || upper_len==0 || (p1<0 && p2<0) || (p1>0&&p2>0)  )
		return -1;

	sum = 0;
	for(i = 0; i < N;i++)
	{
		if( sum+0.3 < upper_len )
		{
			
			sum +=(double)arr[i];
			//cout<<" sum : "<<(double)sum + 0.3 <<" upper_len : "<<upper_len<<endl;
			cnt++;
		} else {
			break;
		}
			
	}
	//cout<<" cnt : "<<cnt<<endl;

	return cnt;
}

int main(void)
{
	int sol;
	double point_1, point_2;

	//입력받는부분
	cin >> N;
	for (int i = 0; i < N; i++){
		cin >> arr[i];
	}

	cin >> point_1 >> point_2;

	
	//설치갯수 판단
	sol = Antenna_Count(point_1, point_2);

	if (sol == -1)
		cout << "Impossible" << endl;
	else
		cout << sol << endl;	
	
	return 0;	
}
