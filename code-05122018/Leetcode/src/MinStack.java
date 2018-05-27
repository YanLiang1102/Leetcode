import java.util.*;


//stack element structure
class StackElement{
	int val;
	int min;
	StackElement(int val, int min)
	{
		this.val=val;
		this.min=min;
	}
}
//you don't need each node to store the min , you can use a stack to store the min when it pop, check with the min stack
public class MinStack {
	/** initialize your data structure here. */
	Stack<StackElement> stack;
	int min;
    public MinStack() {
    	min=Integer.MAX_VALUE;
        stack=new Stack<StackElement>();
    }
    
    public void push(int x) {
    	min=Math.min(min,x);
    	StackElement ele=new StackElement(x,min);
    	stack.push(ele);
    }
    
    public void pop() {
        if(!stack.isEmpty())
        {
        	stack.pop();
        }
    }
    //don't need to pop the top
    public int top() {
    	if(stack.isEmpty())
    	{
    		return Integer.MAX_VALUE;
    	}
    	else
    	{
    		return stack.peek().val;
    	}
    }
    
    public int getMin() {
    	if(stack.isEmpty())
    	{
    		return Integer.MAX_VALUE;
    	}
    	else
    	{
    		return stack.peek().min;
    	}
    }
    
    public static void main(String[] args)
    {
    	MinStack mstack=new MinStack();
    	mstack.push(9);
    	mstack.push(10);
    	mstack.push(1);
    	mstack.push(-1);
    	
    	int min=mstack.getMin();
    	System.out.println("expected -1, actual:"+min);
    	mstack.pop();
    	min=mstack.getMin();
    	System.out.println("expected 1, actual:"+min);
    	mstack.pop();
    	min=mstack.getMin();
    	System.out.println("expected 9, actual:"+min);
    	int current=mstack.top();
    	System.out.println("expected 10, actual:"+current);
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
