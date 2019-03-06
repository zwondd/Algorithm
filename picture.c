#include <stdio.h>

int N;//제품 수
struct st{
	int X, ID;//위치, 아이디
};
struct st A[50010];
int id[50010];
int checkIdCnt =0;

int checkId[50010]={0,};
int checked = 0;


void Input_Data(void){
	int i;
	scanf("%d", &N);
	for (i = 0; i < N; i++){
		scanf("%d %d", &A[i].X, &A[i].ID);
	}
}

void sort(void) 
{
    int i,j;
    struct st temp;

    for (i=0; i<N-1; i++) 
    {
        int minIdx = i;
        for(j=i+1; j<N; j++)
        {
            if ( A[j].X < A[minIdx].X ) 
            {
                minIdx = j;
            }
        }
        temp = A[i];
        A[i] = A[minIdx];
        A[minIdx] = temp;
    }
}

void findIdCount(void) 
{
    int i,j;
    for (i=0; i<N; i++)
    {
        if ( i==0 )
        {
            id[checkIdCnt++] = A[i].ID;
        }
        for (j=0; j<checkIdCnt; j++)
        {
            if ( id[j] == A[i].ID )
            {
                break;
            }
            if ( j==checkIdCnt-1) 
            {
                id[checkIdCnt++] = A[i].ID;
            }
        }
    }
}

int findMinLength(void)
{
    int i,j,k;
    int minX, maxX;
    int minLength = 1000000001;

    for (i=0; i<N-checkIdCnt+1; i++)
    {
        minX = A[i].X;
        for (k=0; k<checkIdCnt; k++)
        {
            if ( id[k] == A[i].ID  )
            {
                checkId[k] = 1;
                checked++;
            }
        }

        for (j=i+1; j<N; j++)
        {
            for (k=0; k<checkIdCnt; k++)
            {
                if ( id[k] == A[j].ID && checkId[k] == 0 )
                {
                    checkId[k] = 1;
                    checked++;
                    break;
                }
            }
            if ( checked == checkIdCnt )
            {
                maxX = A[j].X;
                break;
            }
        }

        if ( checked == checkIdCnt )
        {
            if ( maxX - minX < minLength )
            {
                minLength = maxX - minX;
            }
        }
        for (k=0; k<checkIdCnt; k++)
        {
            checkId[k] = 0;
        }
        checked = 0;
    }

    return minLength;
}

int main(void){
	int ans = -1;
    int i,j;
	Input_Data();		//	입력 함수
	
	//	코드를 작성하세요
    
    // sort 
    sort();

    // find different ID
    findIdCount();

    // find minimum length
    ans = findMinLength();

	printf("%d\n", ans);		//	정답 출력
	return 0;
}

