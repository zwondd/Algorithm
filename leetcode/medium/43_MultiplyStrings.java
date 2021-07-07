// 21-07-07
// 풀이 : https://real-012.tistory.com/192

class Multiply {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];

        for(int i=num1.length()-1; i>=0; i--) {
            for(int j=num2.length()-1; j>=0; j--) {
                int n1 = Integer.valueOf(num1.charAt(i)-'0');
                int n2 = Integer.valueOf(num2.charAt(i)-'0');

                result[i+j+1] += n1*n2;
            }
        }
        for(int i=result.length-1; i>=0; i--) {
            result[i-1] += result[i]/10;
            result[i] = result[i]%10;
        }

        boolean check = false;
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<result.length; i++) {
            if( result[i] !=0 && !check ) {
                check = true;
            }

            if ( check ) {
                sb.append(result[i]);
            }
        }
        if ( sb.toString().length() ==0 ) return "0";

        return sb.toString();
        
    }
}