/*
    2021-09-28
    [Programmers][Sort][Lv2] 가장 큰 수
*/
class Sort_Biggest {
    /*
        1. 더 큰값 계산 로직
        2. quickSort 혹은 다른 sort 방법으로 정렬
        3. 해당 배열의 int 값들 String으로 append


        주의할 부분 
        1. int 형 범위 항상 기억하기 (	–2,147,483,648 ~ 2,147,483,647 ) 10자리 넘어가면 error.
        2. 자릿수 계산하는 방법 . 
            - int -> String 변환하여 length 계산 -> int 변환
            - Math.log10 함수 사용 (단 0일 땐 result is negative infinity)
    */
    public String solution(int[] numbers) {
        quickSort(numbers, 0, numbers.length-1);
        for(int i: numbers) System.out.print(i + " ");
        return converToString(numbers);
    }
    
    private String converToString(int[] nums) {
        int maxN = nums[0];
        // int digit = (int)(Math.log10(maxN)+1);

        /*
            수정한 부분 ) 10자리수가 넘어가면 int 형에 연산 불가. String 으로 append 하여 계산해줘야함.
        */
        // for(int i=1; i<nums.length; i++) {
        //     if ( nums[i] == 0 ) {
        //         maxN*=10;
        //     } else {
        //         maxN+= (int)(Math.pow(10, digit))*nums[i];
        //     }
        //     System.out.println("maxN : " + maxN);

        //     digit = (int)(Math.log10(maxN)+1);
        // } 
        // return String.valueOf(maxN);

        String str = "";
        if ( nums[nums.length-1] == 0 ) return "0";
        for(int i=nums.length-1; i>=0; i--) {
            str += String.valueOf(nums[i]);
        }
        return str;
    }

    private boolean bBigger(int a, int b) {
        // System.out.println("=======================");
        // System.out.println("a : " + a + " b : " + b);
        int aBigger = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int bBigger = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        /*
            수정한 부분) 값이 0 일 경우 Math.log10 으로 자릿수 계산 불가.
        */
        // int aBigger = (int)(Math.pow(10, (int)(Math.log10(b)+1)))*a + b;
        // int bBigger = (int)(Math.pow(10, (int)(Math.log10(a)+1)))*b + a;

        // System.out.println("aBigger : " + aBigger + " bBigger : " + bBigger);

        if ( aBigger < bBigger ) return true;
        else return false;
    }

    private int partition ( int[] nums, int left, int right) {
        int pivot = nums[left];
        while( left<=right) {
            while( bBigger(nums[left], pivot) ) left++;
            while( bBigger(pivot, nums[right]) ) right--;
            if ( left<=right ) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++; right--;
            }
        }
        return left;
    }

    private void quickSort(int[] nums, int left, int right) {
        int index = partition(nums, left, right);
        if ( left < index-1 ) {
            quickSort(nums, left, index-1);
        }
        if ( index < right ) {
            quickSort(nums, index, right);
        }
    }

    public static void main(String[] args) {
        Sort_Biggest sb = new Sort_Biggest();
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
