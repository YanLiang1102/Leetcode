/***
i implemented this in leetcode as a practise problem.
***/
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack=new Stack<Integer>();
        minstack=new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty())
        {
            minstack.push(x);
        }
        else
        {
        //be careful here, needs to push when it is <= , otherwise you push 2, 2, 
        //if you don't push twice into minstack, when the first 2 pop from the stack, the min is not correct.
            if(x<=minstack.peek())
            {
                minstack.push(x);
            }
        }
    }
    
    public void pop() {
        //int curr=0;
        if(!stack.isEmpty())
        {
            int curr=stack.pop();
            if(!minstack.isEmpty()&&curr==minstack.peek())
            {
                minstack.pop();
            }
        }
            
            
    }
    
    public int top() {
        if(!stack.isEmpty())
        {
            return stack.peek();
        }
        return 0;
    }
    
    public int getMin() {
        if(!minstack.isEmpty())
        {
            return minstack.peek();
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
