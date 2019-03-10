#include <stdio.h>

int N;//제품 수
struct st{
	int X, ID;//위치, 아이디
};
struct st A[50010];
struct st temp[50010]={0,};

int check_nid[50010];
int max_id_cnt=0;

int check[50010];

void Input_Data(void){
	int i;
	scanf("%d", &N);
	for (i = 0; i < N; i++){
		scanf("%d %d", &A[i].X, &A[i].ID);
	}
}

void sort(int s, int e) 
{
    int i,j,m;
    int k;
    k=s;
    m = (s+e)/2;
    i = s;
    j = m+1;

    if ( s >= e )
    {
        return; 
    }
    sort(s,m);
    sort(j,e);

    while ( i<=m && j<=e )
    {
        if ( A[i].X < A[j].X )
        {
            temp[k++] = A[i++];
        }
        else 
        {
            temp[k++] = A[j++];
        }
    }
    while ( i<=m )
    {
        temp[k++]= A[i++];
    }
    while ( j<=e )
    {
        temp[k++] = A[j++];
    }
    for (i=s; i<=e; i++)
    {
        A[i] = temp[i];
    }
}

void makeNewId()
{
    int i,j;
    int nid;

    for (i=0; i<N; i++)
    {
        nid = A[i].ID % 50000;

        for ( j=0; j<50010; j++)
        {
            if ( check_nid[nid] == 0 )
            {
                max_id_cnt++;
                check_nid[nid] = A[i].ID;
                A[i].ID = nid;
                break;
            }
            else if ( check_nid[nid] == A[i].ID )
            {
                A[i].ID = nid;
                break;
            }
            nid = (nid+1) % 50000;
        }
    }
    printf("max_id_cnt : %d \n",max_id_cnt);
}

int solve(void)
{
    int i, j, id_cnt;
    int minLength;
    i=j=id_cnt=0;
    minLength = 1<<30;

    for(;;)
    {
        printf("[i] : %d / id - %d, X - %d \n", i, A[i].ID, A[i].X);
        while ( (i<N) && max_id_cnt > id_cnt )
        {
            if ( check[A[i].ID]++ == 0 )
                id_cnt++;
            i++;
        }

        if ( max_id_cnt != id_cnt )
            break;
        while ( check[A[j].ID] > 1 )
        {
            check[A[j].ID]--;
            j++;
        }
        minLength = ( minLength < A[i-1].X - A[j].X ) ? minLength : A[i-1].X - A[j].X;
        id_cnt--;
        check[A[j].ID] = 0;
        j++;
    }
    return minLength;
}



int main(void){
	int ans = -1;
    int i,j;
	Input_Data();		//	입력 함수

    sort(0,N-1);
    makeNewId();
    ans = solve();

	printf("%d\n", ans);		//	정답 출력
	return 0;
}

