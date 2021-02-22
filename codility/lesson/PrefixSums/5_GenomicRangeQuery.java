/**
 * 21-02-21
 * 5_PrefixSums_GenomicRangeQuery
 */ 
package codility.lesson.PrefixSums;

class GenomicRangeQuery {

    /**
     * Other Solution 1  (100%) O(N + M)
     * https://siyoon210.tistory.com/123
     */

    public int[] solution(String S, int[] P, int[] Q) {
        int[] A=new int[S.length()+1];
        int[] C=new int[S.length()+1];
        int[] G=new int[S.length()+1];

        char[] chars=S.toCharArray();
        for(int i=0; i<chars.length; i++) {
            switch(chars[i]) {
                case 'A':
                    A[i+1]++;
                    break;
                case 'C':
                    C[i+1]++;
                    break;
                case 'G':
                    G[i+1]++;
                    break;
                default:
                    break;
            }

            A[i+1] +=A[i];
            C[i+1] +=C[i];
            G[i+1] +=G[i];
        }

        int[] answer = new int[P.length];
        
        for(int i=0; i<answer.length; i++) {
            int start=P[i];
            int end=Q[i];

            if ( start==end ) {
                char c=S.charAt(start);

                switch(c) {
                    case 'A':
                        answer[i]=1;
                        break;
                    case 'C':
                        answer[i]=2;
                        break;
                    case 'G':
                        answer[i]=3;
                        break;
                    case 'T':
                        answer[i]=4;
                        break;
                }
            } else if ( A[start]!=A[end+1] ) {
                answer[i]=1;
            } else if ( C[start]!=C[end+1] ) {
                answer[i]=2;
            } else if ( G[start]!=G[end+1] ) {
                answer[i]=3;
            } else {
                answer[i]=4;
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        String S="CAGCCTA";
        int[] P={2,5,0};
        int[] Q={4,5,6};

        GenomicRangeQuery solution = new GenomicRangeQuery();
        int[] sol1=solution.solution(S, P, Q);
        for(int i:sol1) {
            System.out.print(i+"\t");
        }
    }
}
