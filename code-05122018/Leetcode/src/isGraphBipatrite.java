/***
the trick for this problem is need to consider if the graph is connected or not, if not connected, you need to do 
the helper on all the connected component.
***/
class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph==null||graph.length==0)
        {
            return true;
        }
        int size=graph.length;
        int[] colored =new int[size];
        
        //you need to do this to check if multiple strongly connected graph exist in the graph
        for(int i=0;i<size;i++)
        {
            if(colored[i]==0)
            {
               if(!helper(graph,i,colored))
               {
                   return false;
               }
            }
        }
        return true;
    }
    
    //thsi si good enough for a connected graph to check if it is bipartrite or not, 
    public boolean helper(int[][] graph, int source, int[] colored)
    {

                
        Queue<Integer> q=new LinkedList<Integer>();
        colored[source]=1;
        q.add(source);
        while(!q.isEmpty())
        {
            int curr=q.poll();
            //opposite color of current
            int mark=0;
            if(colored[curr]==1)
            {
              mark=2;
            }
            else{
                mark=1;
            }
            
            int[] neighs=graph[curr];
            for(int j=0;j<neighs.length;j++)
            {
                int currcolor=colored[neighs[j]];
                if(currcolor==colored[curr])
                {
                    return false;
                }
               // colored[neighs[j]]=mark;
                if(currcolor==0)
                {
                 q.add(neighs[j]);   
                }
                colored[neighs[j]]=mark;
            }
        }
        return true;
    }
    
    
}
