class Solution {
    public boolean isValid(String s) {
        String left="{([";
        String right="}])";
        
        Stack<Character> stack=new Stack<Character>();
        
        int length=s.length();
        for(int i=0;i<length;i++)
        {
            char curr=s.charAt(i);
            if(left.indexOf(curr)>=0)
            {
                stack.push(curr);
            }
            if(right.indexOf(curr)>=0)
            {
                //this check is easy to be missed!
                if(stack.isEmpty())
                {
                    return false;
                }
                char pop=stack.pop();
                if(curr=='}'&&pop!='{')
                {
                    return false;
                }
                else if(curr==']'&& pop!='[')
                {
                    return false;
                }
                else if(curr==')' && pop!='(')
                {
                    return false;
                }
            }
            
        }
        if(stack.isEmpty())
        {
            return true;
        }
        return false;
    
}
}
