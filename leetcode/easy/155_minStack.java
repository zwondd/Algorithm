import java.util.Stack;

// 21-07-07
// 풀이 : https://bcp0109.tistory.com/261

class MinStack {
    int min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
       min = Integer.MAX_VALUE;
       stack = new Stack<>();
    }
    
    public void push(int val) {
        if ( val<=min ) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if ( stack.pop() == min ) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */ 