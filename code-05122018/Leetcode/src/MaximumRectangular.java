//passed, but I believe this can be simplified
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
                //when it is strickly bigger, then the left bound will be itself
                Data curr=new Data(i,i,-1);
                stack.push(curr);
            }
            else if(height==heights[index])
            {
                int leftbound=i;
                if(!stack.isEmpty())
                {
                    leftbound=stack.peek().leftbound;
                }
                //if it is equal the leftboudn has to be the leftboudn of the peek if stack is not empty
                Data curr=new Data(i,leftbound,-1);
                stack.push(curr);
            }
            else
            {
                int lastindex=i;
                while(!stack.isEmpty()&&heights[stack.peek().index]>height)
                {
                    Data curr=stack.pop();
                    max=Math.max(max, (i-curr.leftbound)*heights[curr.index]);
                    //here has to be the curr.leftbound, not curr.index,since in this situation
                    //3,6,5,7,4,8,1, the max will be 20, when u look at 4, if you use the index, it will return 2 for the leftbound instead of 1, since 6
                    //already poped out, but if you return the leftbound it will be 1.
                    lastindex=curr.leftbound;
                }
            
                stack.push(new Data(i,lastindex,-1));
                
            }
            
        }
        return max;
        
        
    }
}
