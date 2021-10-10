/*
    2021-10-10
    [Programmers][Sort][Lv2] 가장 큰 수
*/

import java.util.*;

class Sort_Biggest2 {
    /*
        다른풀이
    */
    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b)-> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as+bs), Integer.parseInt(bs+as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if ( answer.charAt(0) == '0' ) return "0";
        else return answer;
    }

    public String solution2(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String ans = "";
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }
   

    public static void main(String[] args) {
        Sort_Biggest2 sb = new Sort_Biggest2();
        // int[] numbers = {3, 30, 34, 5, 9};
        String ans = "";
        int[] numbers = {6, 10, 2};
        ans = sb.solution(numbers);
        System.out.println(ans);

        int[] numbers2 = {1, 23, 45};
        ans = sb.solution(numbers2);
        System.out.println(ans);

        int[] numbers3 = {300, 2 , 10, 6, 0, 0};
        ans = sb.solution(numbers3);
        System.out.println(ans);

        int[] numbers4 = {23, 232, 21, 212};
        ans = sb.solution(numbers4);
        System.out.println(ans);

        int[] numbers5 = {0,0};
        ans = sb.solution(numbers5);
        System.out.println(ans);
    }
    
}
