//#856 I did not generate the idea by myself I read the c++ explantion on the leetcode discussion
  //   but similar problems later could solve like this, record the depth,if it is '(' depth++ else --
  //   and also only when it is first time '()' add the result to the final result.
  //  I think this problem is like if you did it before, u will know how to do.
class Solution {
    public int scoreOfParentheses(String S) {
        if(S==null||S.length()==0)
        {
            return 0;
        }
        char[] arr=S.toCharArray();
        
        int len=arr.length;
        
        int depth=0;
        int res=0;
        for(int i=0;i<len;i++)
        {
            if(arr[i]=='(')
            {
                depth++;
            }
            else
            {
                depth--;
                if(i>0&&arr[i-1]=='(')
                {
                   res+=1<<depth;
                }
            }
        }
        return res;
    }
}
