//not passed yet
class Solution {
    class Data
    {
       int index=0;
       int leftbound=0;
       int rightbound=0;
       public Data(int index, int leftbound, int rightbound)
       {
           this.index=index;
           this.leftbound=leftbound;
           this.rightbound=rightbound;
       }
    }
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0)
        {
            return 0;
        }
        if(heights.length==1)
        {
            return heights[0];
        }
        
        Stack<Data> stack=new Stack<Data>();
        stack.push(new Data(0,0,-1));
        int length=heights.length;
        int max=0;
        for(int i=0;i<=length;i++)
        {
            
            int index=i;
            if(!stack.isEmpty())
            {
                index=stack.peek().index;
            }
            int height=0;
            if(i==length)
            {
                //height=0;
                while(!stack.isEmpty()&&heights[stack.peek().index]>height)
                {
                    Data curr=stack.pop();
                    max=Math.max(max, (i-curr.leftbound)*heights[curr.index]);
                
                }
                continue;
            }
             height=heights[i];
            if(height>heights[index])
            {
                Data curr=new Data(i,index,-1);
                stack.push(curr);
            }
            else if(height==heights[index])
            {
                int leftbound=i;
                if(!stack.isEmpty())
                {
                    leftbound=stack.peek().leftbound;
                }
                Data curr=new Data(i,leftbound,-1);
                stack.push(curr);
            }
            else
            {
                while(!stack.isEmpty()&&heights[stack.peek().index]>height)
                {
                    Data curr=stack.pop();
                    max=Math.max(max, (i-curr.leftbound)*heights[curr.index]);
                
                }
                
                
            }
            
        }
        return max;
        
        
    }
}
