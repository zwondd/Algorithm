/*
    2021-10-18
    [Leetcode][Medium] 18. 4Sum
*/
import java.util.*;

class FourSum {

    /*
        Solution 
        참조) https://www.programcreek.com/2013/02/leetcode-4sum-java/
        https://smlee729.wordpress.com/2018/03/14/algorithm-%EB%AC%B8%EC%A0%9C-4sum/
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
     
        if(nums==null|| nums.length<4)
            return result;
     
        Arrays.sort(nums);
     
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
     
                        k++;
                        l--;
     
                        while(k<l &&nums[l]==nums[l+1] ){
                            l--;
                        }
     
                        while(k<l &&nums[k]==nums[k-1]){
                            k++;
                        }
                    }
     
     
                }
            }
        }
     
        return result;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        List<List<Integer>> uniqueSum = new LinkedList<List<Integer>>();
        if ( nums==null || nums.length<4 ) {
            return uniqueSum;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; i++) {
            if ( i!=0 && nums[i]==nums[i-1] ) {
                continue;
            }
            for(int j=i+1; j<nums.length-2; j++) {
                if ( j!=i+1 && nums[j]==nums[j-1] ) {
                    continue;
                }
                int k=j+1;
                int l=nums.length-1;

                while(k<l) {
                    int tmpSum = nums[i]+nums[j]+nums[k]+nums[l];
                    if (  tmpSum < target ) {
                        k++;
                    } else if ( tmpSum > target ) {
                        l--;
                    } else {
                        List<Integer> t = new LinkedList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        uniqueSum.add(t);

                        k++;
                        l--;
                        while( k<l && nums[l]==nums[l+1] ) {
                            l--;
                        }
                        while( k<l && nums[k]==nums[k-1] ) {
                            k++;
                        }
                    }

                    
                }
            }
        }
        return uniqueSum;
    }




    /*
        My Solution
        wrong - 중복 리스트 추가됨.
    */
    List<List<Integer>> uniqueQuad = new ArrayList<>();
    boolean[] visit;

    
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        Arrays.fill( visit, false);
        // checkSum(new ArrayList<>(),0,0, nums, target);
        for(int i=0; i<nums.length; i++)
            checkSum2(new ArrayList<>(), i, nums, target);
        return uniqueQuad;
    }

    private void printList(List<Integer> list) {
        for(int j=0; j<list.size(); j++) {
            System.out.print(list.get(j) + " ");
        }
        System.out.println();
    }

    private int getSum(List<Integer> list) {
        int sum=0;
        for(int i=0; i<list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }

    private void checkSum2(List<Integer> list, int idx, int[] nums, int target) {
        
        visit[idx] = true;
        list.add(nums[idx]);

        if ( list.size() >= 4 ) {
            if ( getSum(list) == target ) {
                uniqueQuad.add(new ArrayList<>(list));  // deep copy로 복사해야함.
            }
            return;
        }

        for(int i=idx+1; i<nums.length; i++) {
            if ( visit[i] == false ) {
                checkSum2(list, i, nums, target);
                visit[i] = false;
                if ( list.size() >0 ) {
                    list.remove(list.size()-1);
                }
            }
        }
    }
 
    /*
    private void checkSum(List<Integer> list, int sum, int idx, int[] nums, int target) {
       

        visit[idx] = true;
        sum+=nums[idx];
        list.add(nums[idx]);

        System.out.println("=================== num : " + nums[idx] + " sum : " + sum);
        printList(list);

        if ( list.size() >= 4 ) {
            System.out.println("=== list.size() >= 4  : " + sum );
            printList(list);

            int tmpsum=0;
            for(int i=0; i<list.size(); i++) {
                tmpsum+=list.get(i);
            }
            System.out.println("tmpsum : " + tmpsum);
            // if ( sum == target ) {
            if ( tmpsum == target ) {
                // printList(list);

                uniqueQuad.add(list);

                System.out.println("-------------" );
                for(int i=0; i<uniqueQuad.size(); i++) {
                    printList(uniqueQuad.get(i));
                }
                System.out.println("-------------" );
            }
            
            return;
        }

        for(int i=idx+1; i<nums.length; i++) {
            if ( visit[i] == false ) {
                checkSum(list, sum, i, nums, target);
                visit[i] = false;
                if ( list.size() >0 ) {
                    list.remove(list.size()-1);
                }
            }
        }
        visit[idx]=false;
        if ( list.size() >0 ) {
            list.remove(list.size()-1);
        }
    }
    */

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        // int[] nums = {1,0,-1,0,-2,2};
        // int target = 0;

        int[] nums = {2,2,2,2,2};
        int target = 8;      
        
        List<List<Integer>> result =  fs.fourSum(nums, target);
        for(int i=0; i<result.size(); i++) {
            fs.printList(result.get(i));
        }
    }
}
