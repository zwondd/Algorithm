/*
   2021-04-11
   LG codepro - [19년도_5차] Chef
    2/12 : success
 */
package codepro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

class Chef {
    static int N;
    static List<Customer> list = new ArrayList<>();

    class Customer {
        int id;
        int cost;
        int time;
    }

    public class ListComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            return Integer.compare(c1.time, c2.time);
        }
    }

    public int solve(List<Customer> list) {
        int sumP=0;

        Collections.sort(list, new ListComparator());
        // for(int i=0; i<list.size(); i++) {
        //     System.out.println("i : " + list.get(i).time + " " + list.get(i).cost + " " + list.get(i).id);
        // }
        

        int cur=N-1;
        for(int i=N; i>=1; i--) {
            int tempMaxP=0;
            while( cur>=0 && list.get(cur).time>=i ) {
                // System.out.println("i : " + i + "  list.get(cur).cost " + list.get(cur).cost);
                tempMaxP = (tempMaxP<list.get(cur).cost) ? list.get(cur).cost:tempMaxP;
                cur--;
            }
            // System.out.println("i : " + i + " P : " + tempMaxP);
            sumP+=tempMaxP;
        }

        return sumP;
    }


    public static void main(String[] args) throws Exception {
        Chef chef=new Chef();
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        for(int i=1; i<=N; i++) {
            Customer c=chef.new Customer();
            c.id=i;
            c.cost=sc.nextInt();
            c.time=sc.nextInt();
            list.add(c);
        }
        System.out.println(chef.solve(list));
        sc.close();
    }
    
}
