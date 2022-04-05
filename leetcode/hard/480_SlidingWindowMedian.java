/*
    2022-04-04
    [Leetcode][Hard] 480. Sliding Window Median
*/
import java.util.*;

class SlidingWindow {
    /*
        Heap을 통해 구현 (Priority Queue)
        maxHeap, minHeap
        https://www.youtube.com/watch?v=lXY2oiDlc1E

        Runtime: 82 ms, faster than 55.91% of Java online submissions for Sliding Window Median.
        Memory Usage: 56.3 MB, less than 23.51% of Java online submissions for Sliding Window Median.
    */
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public SlidingWindow() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // comparator
    }

    private void add(int num) {
        if ( maxHeap.isEmpty() || maxHeap.peek()>num ) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }
    private void balance() {
        if(maxHeap.size()>minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        } else if( minHeap.size()>maxHeap.size() ) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void remove(int num) {
        if ( num<=maxHeap.peek() ) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        balance();
    }

    private double findMedian() {
        if( maxHeap.size() > minHeap.size() ) return maxHeap.peek();
        if ( minHeap.size() > maxHeap.size() ) return minHeap.peek(); // 주석처리해도 상관없음. balance 시 항상 maxHeap 이 커지게 구성하고 있음.
        return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int start = 0;
        double[] result = new double[nums.length-k+1];

        for(int end=0; end<nums.length; end++) {
            add(nums[end]);
            int size = (end-start+1);
            if ( size==k ) {
                result[start] = findMedian();
                remove(nums[start]);
                start++;
            }
        }
        return result;
    }



    /*
        brute force로 풀면
        Time Limit Exceeded

        to be implemented ...
    */
    public double[] medianSlidingWindow1(int[] nums, int k) {
        double[] medArr = new double[nums.length-k+1];

        if ( nums.length==1 ) {
            medArr[0] = nums[0];
            return medArr;
        }

        for(int i=0; i<nums.length-k+1; i++) {
            int[] tmp = Arrays.copyOfRange(nums, i, i+k);

            Arrays.sort(tmp);

            double median;
            if ( k%2==0 ) {
                median = ((double)tmp[k/2]/2) + ((double)tmp[k/2-1]/2);  // (double)(변수) / 2 로 해야 됨. (double)(변수/2) 로하면 이미 소수점 round 됨.
            } else {
                median = (double)(tmp[k/2]);
            }
            // System.out.println( ((double)tmp[k/2]/2)  );
            // System.out.println( tmp[k/2-1]/2 );
            medArr[i] = median;
        }
        return medArr;
    }

    public static void main(String[] args) {
        SlidingWindow sw = new SlidingWindow();
        // int[] nums = {2147483647,2147483647};
        // int k=2;
        // double[] res = sw.medianSlidingWindow(nums, k);
        // System.out.println(Arrays.toString(res));

        int[] nums = {1, 4, 2, 3};
        int k = 4;
        double[] res = sw.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
    
}
