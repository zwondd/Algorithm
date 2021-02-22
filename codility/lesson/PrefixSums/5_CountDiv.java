/**
 * 21-02-21
 * 5_PrefixSums_CountDiv
 */ 
package codility.lesson.PrefixSums;

class CountDiv {
    public static void main(String[] args) {
        CountDiv s=new CountDiv();
        System.out.println(s.solution(6, 11, 2));
    }

    public int solution(int A, int B, int K) {
        // write your code in Java SE 11

        return (B/K + (A%K==0?1:0)) - (A/K);
    }
}
