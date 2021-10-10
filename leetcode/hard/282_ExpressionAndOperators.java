/*
    2021-10-10
     [Leetcode][Hard] 282. Expression Add Operators
*/

import java.util.*;

class ExpressionAndOperators {
    /*
        Runtime: 115 ms
        Memory Usage: 40 MB
        참고 ) https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/282-expression-add-operators.html
    */
    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        process("", 0, 0, num, target, result);
        return result;
    }

    private void process(String cur, long sum, long addToSum, String num, int target, List<String> result ) {
        if ( num.length()==0 && target==sum ) {
            result.add(cur);
            return;
        }
        for(int i=1; i<=num.length(); i++) {  // 놓친 부분 - Sting 을 substring 으로 나누기. (처음에 모두다 split 후 연산하려고 했음.)
            String first = num.substring(0, i);
            String second = num.substring(i);

            if ( first.charAt(0) == '0' && first.length()>1 ) {
                return;
            } 
            long firstLong = Long.parseLong(first);
            if ( cur.equals("") ) {
                process(first, firstLong, firstLong, second, target, result);
            } else {
                process(cur+"+"+ first, sum+firstLong, firstLong, second, target, result);
                process(cur+"-"+ first, sum-firstLong, -firstLong, second, target, result);
                process(cur+"*"+ first,  (sum - addToSum) + addToSum * firstLong, addToSum * firstLong, second, target, result);
            }
        }

    }

    public static void main(String[] args) {
        ExpressionAndOperators eo = new ExpressionAndOperators();
        String num = "105";
        int target = 5;
        List<String> result = eo.addOperators(num, target);
        for(String str : result) {
            System.out.println(str);
        }
    }
}

/*
    leetcode solution
*/
class ExpressionAndOperators2 {

    public ArrayList<String> answer;
    public String digits;
    public long target;
  
    public void recurse(
        int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
      String nums = this.digits;
  
      // Done processing all the digits in num
      if (index == nums.length()) {
  
        // If the final value == target expected AND
        // no operand is left unprocessed
        if (value == this.target && currentOperand == 0) {
          StringBuilder sb = new StringBuilder();
          ops.subList(1, ops.size()).forEach(v -> sb.append(v));
          this.answer.add(sb.toString());
        }
        return;
      }
  
      // Extending the current operand by one digit
      currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
      String current_val_rep = Long.toString(currentOperand);
      int length = nums.length();
  
      // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
      // valid operand. Hence this check
      if (currentOperand > 0) {
  
        // NO OP recursion
        recurse(index + 1, previousOperand, currentOperand, value, ops);
      }
  
      // ADDITION
      ops.add("+");
      ops.add(current_val_rep);
      recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);
  
      if (ops.size() > 0) {
  
        // SUBTRACTION
        ops.add("-");
        ops.add(current_val_rep);
        recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);
  
        // MULTIPLICATION
        ops.add("*");
        ops.add(current_val_rep);
        recurse(
            index + 1,
            currentOperand * previousOperand,
            0,
            value - previousOperand + (currentOperand * previousOperand),
            ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);
      }
    }
  
    public List<String> addOperators(String num, int target) {
  
      if (num.length() == 0) {
        return new ArrayList<String>();
      }
  
      this.target = target;
      this.digits = num;
      this.answer = new ArrayList<String>();
      this.recurse(0, 0, 0, 0, new ArrayList<String>());
      return this.answer;
    }
  }
