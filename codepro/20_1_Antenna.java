package codepro;

import java.util.Scanner;
import java.util.Stack;

class Antenna {
    int[] h;
    Scanner sc;
    Stack<Integer> st=new Stack<Integer>();
    int res=0;

    public void solve() {
        // if ( h.length==1 ) {
        //     System.out.println(0);
        //     return;
        // }

        // int i=0;
        // for(i=1; i<h.length; i++) {
        //     System.out.println("h["+i+"] " + h[i]);
        //     res++;
        //     if ( h[i]<h[i-1] ) {
        //         st.add(h[i]);
        //     } else {
        //         while( !st.isEmpty() && st.peek()<h[i] ) {
        //             System.out.println("====  " + st.peek() );
        //             res++;
        //             st.pop();
        //         }
        //         st.add(h[i]);
        //     }
        // }
        // System.out.println(res);

        for(int i=0; i<h.length; i++) {
            while( !st.isEmpty() && st.peek()<h[i] ) {
                res++;
                st.pop();
            }

            if ( !st.isEmpty() ) {
                res++;
                if ( st.peek() == h[i] ) 
                    st.pop();
            }
            st.push(h[i]);
        }
        System.out.println(res);
    };

    public static void main(String[] args) {
        Antenna an=new Antenna();
        an.sc = new Scanner(System.in);
        int n= an.sc.nextInt();
        an.h = new int[n];
        for(int i=0; i<n; i++) {
            an.h[i]=an.sc.nextInt();
        }
        an.solve();
    }
}
