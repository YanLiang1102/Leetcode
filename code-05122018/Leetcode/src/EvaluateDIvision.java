import java.util.*;
/***
run in ellipe on my local and leetcode get different result , might be something worng in leetcode it passed on my local.
***/
/***
using bfs to search the query and use a hashmap to store the current multiplictaion of each end node, in that way next one
you juts need to fetch the previous node and multioply it i think bfs is better since it is used to find the shortest path.
***/
class Solution {
//be modeled as a directed graph and also using bfs to traverse since it will find the shortest path
    class Node
    {
        String name;
        ArrayList<Node> neigh;
        ArrayList<Double> values;
        Node(String name)
        {
            this.name=name;
            neigh=new ArrayList<Node>();
            values=new ArrayList<Double>();
        }
        
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String,Node> graph=new HashMap<String,Node>();
        int length=equations.length;
        //build the graph.
        for(int i=0;i<length;i++)
        {
            String start=equations[i][0];
            String end=equations[i][1];
            double val=values[i];
            addNodeToGraph(graph,start,end,val);
            if(val!=0)
            {
            addNodeToGraph(graph,end,start,1.0/val);    
            } 
        }  
        int querylength=queries.length;
        double[] rst=new double[querylength];
        
        for(int i=0;i<querylength;i++)
        {
            String start=queries[i][0];
            String end=queries[i][1];
            rst[i]=bfs(graph,start,end,new HashMap<String, Double>());
        }
        return rst;
        
        
    }
    
    public double bfs(HashMap<String,Node> graph, String start, String end, HashMap<String,Double> map)
    {
        HashSet<String> visited=new HashSet<String>();
        if(!graph.containsKey(start))
        {
            return -1.0;
        }
        Node curr=graph.get(start);
        Queue<Node> q=new LinkedList<Node>();
        q.add(curr);
        map.put(curr.name,1.0);
        while(!q.isEmpty())
        {
          
           curr=q.poll();
           if(visited.contains(curr.name))
           {
               continue;
           }
           
           visited.add(curr.name);                
           for(int i=0;i<curr.neigh.size();i++)
            {
                Node temp=curr.neigh.get(i);
                if(temp.name==end)
                {
                    return map.get(curr.name)*curr.values.get(i);
                }
                q.add(temp);
                map.put(temp.name,map.get(curr.name)*curr.values.get(i));
            }
           
        }
        return -1.0;
        
    }
    
    public void addNodeToGraph(HashMap<String,Node> graph, String start, String end, double val)
    {
            Node newnode;
            if(!graph.containsKey(start))
            {
               newnode =new Node(start);
            }
            else
            {
                newnode=graph.get(start);
            }
            Node endnode;
            if(!graph.containsKey(end))
            {
               endnode=new Node(end);  
            }
            else
            {
                endnode=graph.get(end);
            }
            newnode.neigh.add(endnode);
            newnode.values.add(val); 
            if(!graph.containsKey(start))
            {
            	 graph.put(start,newnode);
            }
            if(!graph.containsKey(end))
            {
            	graph.put(end, endnode);
            }
           
            
    }
    
    public static void main(String[] args)
    {
    	double[] values=new double[2];
    	values[0]=2.0;
    	values[1]=3.0;
    	//values[2]=0.2;
    	//values[1]=5.0;
    	
    	String[][] equations=new String[2][2];
    	String[] temp=new String[2];
    	String[] temp1=new String[2];
    	//String[] temp2=new String[2];
    	temp[0]="a";
    	temp[1]="b";
    	equations[0]=temp;
     	temp1[0]="b";
    	temp1[1]="c";
    	equations[1]=temp1;
//    	temp2[0]="b";
//    	temp2[1]="d";
//    	equations[2]=temp2;
    	
//    	[ ["a","b"],["b","c"] ]
//    			[2.0,3.0]
//    			[ ["a","c"],["b","c"],["a","e"],["a","a"],["x","x"] ]
    	String[][] queries=new String[5][2];
    	String[] tem1=new String[2];
    	String[] tem2=new String[2];
    	String[] tem3=new String[2];
    	String[] tem4=new String[2];
    	String[] tem5=new String[2];
    	tem1[0]="a";
    	tem1[1]="c";
    	queries[0]=tem1;
    	tem2[0]="b";
    	tem2[1]="c";
    	queries[1]=tem2;
    	tem3[0]="a";
    	tem3[1]="e";
    	queries[2]=tem3;
    	tem4[0]="a";
    	tem4[1]="a";
    	queries[3]=tem4;
    	tem5[0]="x";
    	tem5[1]="x";
    	queries[4]=tem5;
    	Solution s=new Solution();
        double[] rst=s.calcEquation(equations,values,queries);
        
        int length=rst.length;
        for(int i=0;i<length;i++)
        {
        	System.out.println(rst[i]);
        }
    	
    }
}
