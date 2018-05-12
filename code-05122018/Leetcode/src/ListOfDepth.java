//problem  Give a binary tree, design an algorithm which create a linked list of all the nodes
//at each depth (e.g. if you have a tree with depth D, you will  have D linked list)
import java.io.*;
import java.util.*;
import java.util.LinkedList;
public class ListOfDepth {
    int V;
    LinkedList<Integer> adj[];
    
    ListOfDepth(int v){
    	V=v;
    	adj=new LinkedList[v];
    	for(int i=0;i<v;i++)
    	{
    		adj[i]=new LinkedList<Integer>();
    	}
    	
    }
    private void addEdge(int w, int v)
    {
    	adj[w].add(v);
    }
    private ArrayList<LinkedList<Integer>> generatelist(int s)
    {
       ArrayList<LinkedList<Integer>> rst=new ArrayList<LinkedList<Integer>>();
       
       LinkedList<Integer> q=new LinkedList<Integer>();
       LinkedList<Integer> levelq=new LinkedList<Integer>();
       
       q.add(s);
       rst.add(new LinkedList<Integer>(Arrays.asList(s)));
       Iterator<Integer> i;
       while(!q.isEmpty())
       {
    	   int c=q.poll();
    	   i=adj[c].listIterator();
    	   while(i.hasNext())
    	   {
    		   int n=i.next();
    		   levelq.push(n);
    	   }
    	   
    	   if(q.isEmpty())
    	   {
    		   q=levelq;
    		   rst.add(new LinkedList(levelq));
    		   levelq=new LinkedList<Integer>();
    	   }
       }
      return rst;       
    }
    
    public static void main(String[] args) {
    	ListOfDepth g = new ListOfDepth(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
	    
        ArrayList<LinkedList<Integer>> rst=g.generatelist(0);
        
        for(int i=0;i<rst.size()-1;i++)
        {
            LinkedList<Integer> temp=rst.get(i);
            Iterator<Integer> iter=temp.listIterator();
            while(iter.hasNext())
            {
            	int n=iter.next();
            	System.out.print(n+",");
            }
            System.out.println("next line");
        }
    }
}
