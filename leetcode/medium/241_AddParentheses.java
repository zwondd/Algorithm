// 2021-08-04

import java.util.*;

// 마이너스 부호가 숫자 앞에 있을 경우 재고려해야함.
// ex ) [ 5 , - , 2 , * , 3 , *, 5] 
//      [ 5 , - , 6 , *, 5]  => (o)
//      [ 5 , -6 , *, 5]     => (x)  - 현재 이렇게 구현되어 있음

class AddParentheses {
    List<Integer> list = new ArrayList<>();

    public int operate ( int idx, List<String> l ) {
        int first = l.get(idx).charAt(0)-'0';
        int second = l.get(idx+2).charAt(0)-'0';
        String operand = l.get(idx+1);
        int operated;

        if ( operand.charAt(0) == '*' ) {
            operated = first*second;
        } else if ( operand.charAt(0) == '+' ) {
            operated = first + second;
        } else {
            operated = first - second;
        }
        return operated;
    }

    public void dfs( List<String> strList ) {
        System.out.println( "dfs : " + strList.toString());
        if ( strList.size() == 3 ) {
            int cal = operate( 0, strList );
            list.add( cal );
            System.out.println( " finish : " + cal );
            return;
        }

        List<String> tmp = new ArrayList<>();
        for( int i=0; i<strList.size()-3; i+=2 ) {
            System.out.println( i );
            tmp.clear();
            for( int j=0; j<i; j++) {
                tmp.add( strList.get(j) );
            }
            
            int cal = operate( i, strList );
            tmp.add( Integer.toString(cal) );

            for( int k=i+3; k<strList.size(); k++ ) {
                tmp.add( strList.get(k) );
            }

            dfs( tmp );
        }
    }

    public List<Integer> diffWaysToCompute(String expression) {
        String[] arr = expression.split("");
        List<String> arrAsList = Arrays.asList(arr);
        dfs(arrAsList);
        return list;
    }

    public static void main(String[] args) {
        AddParentheses add = new AddParentheses();

        String str = "2*3-4*5"; 
        List<Integer> result =  add.diffWaysToCompute( str );
        System.out.println("================");
        for( int ans : result ) {
            System.out.println( ans );
        }
        System.out.println();

    }
} 