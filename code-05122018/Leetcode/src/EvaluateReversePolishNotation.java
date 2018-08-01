/***
idea is assume the notation is valid which means it always make sense
the idea will be use a stack, when u see a number you will push , when you see
an operation, you can opo two numbers from the stack, and push the calculated result 
back to the stack.
***/
class Solution {
    public int evalRPN(String[] tokens) {
        
        if(tokens==null||tokens.length==0)
        {
            return 0;
        }
        if(tokens.length==1)
        {
            return Integer.valueOf(tokens[0]);
        }
        int rst=0;
        Stack<String> stack=new Stack<String>();
        
        int len=tokens.length;
        for(int i=0;i<len;i++)
        {
            if(!isOperator(tokens[i]))
            {
                stack.push(tokens[i]);
            }
            else
            {
              int a=Integer.valueOf(stack.pop());
              int b=Integer.valueOf(stack.pop());
              rst=calculate(tokens[i],a,b);
              stack.push(String.valueOf(rst));
            }
        }
        return rst;
    }
    
    
    public int calculate(String op, int a, int b)
    {
        if(op.equals("*"))
        {
            return a*b;
        }
        //divide should be the (second poped)/(first poped)
        else if(op.equals("/"))
        {
         return b/a;   
        }
        else if(op.equals("-"))
        {
            return b-a;
        }
        return b+a;
    }
    
    
    public boolean isOperator(String o)
    {
        if(o.equals("+")||o.equals("-")||o.equals("*")||o.equals("/"))
        {
            return true;
        }
        return false;
    }
}
