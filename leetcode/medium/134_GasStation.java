// 2021-08-14

import java.util.*;

class GasStation {
    // solution 
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if ( gas.length == 0 || cost.length == 0 ) {
            return -1;
        }

        int size = gas.length;
        int curSum = 0;
        int sum = 0;
        int ans = 0;

        for(int i=0; i<size; i++) {
            curSum += gas[i]-cost[i];
            if ( curSum <0 ) {
                sum += curSum;
                curSum = 0;
                ans = i+1;
            }
        }
        sum += curSum;
        return sum<0 ? -1 : ans;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        int[] res = new int[len+1];
        Arrays.fill( res, -1);
        
        
        for(int i=0; i<len; i++) {
            int start = i;
            int curGas = gas[start];
            
            int j;
            System.out.println("start : " + start );

            for( j=(start+1)%len; j!=start ; j=(j+1)% len ) {
                curGas = curGas - cost[(j+len-1)%len];
                
                if ( curGas<0 ) {
                    break;
                }
                curGas += gas[j];
            }
            if ( j==start ) {
                curGas = curGas - cost[(j+len-1)%len];
                if ( curGas<0 ) {
                    break;
                }
                res[start] = j;
            }
        }
        
        int ans=-1;
        for(int i=0; i<res.length; i++) {
            if ( res[i] != -1 ) {
                ans = res[i];
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println( g.canCompleteCircuit(gas, cost));

        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        System.out.println( g.canCompleteCircuit(gas2, cost2));
    }
    
}
