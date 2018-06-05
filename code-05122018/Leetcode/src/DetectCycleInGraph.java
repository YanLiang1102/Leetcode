import java.util.*;

/*
 * using adjacency list for graph
 */
class Graph
{
	public int v;
	public ArrayList<ArrayList<Integer>> adj;
	Graph(int v)
	{
		this.v=v;
		adj=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
}

public class DetectCycleInGraph {
	
	/*
	 * idea: keep a stack for teh dfs, and check if the visited node is still in the "during recursive" stack, if so, there is a cycle.
	 * also need to keep an array of visited in that way we don't do duplicat work.
	 */
	public static boolean isCyclic(int vertex, boolean[] visited, Stack<Integer> s,Graph g)
	{
		if(visited[vertex])
		{
			return false;
		}
		visited[vertex]=true;
	    s.push(vertex);
	    ArrayList<Integer> neighbors=g.adj.get(vertex);
	    for(int i:neighbors)
	    {
	       if(s.contains(i))
	       {
	    	   return true;
	       }
	       s.push(i);
	       visited[i]=true;
	       if(isCyclic(i,visited,s,g))
	       {
	    	   return true;
	       }
	       visited[i]=false;
	       s.pop();
	    }
	    return false;
	}
	
	public static void main(String[] args)
	{
		Graph g=new Graph(6);
		g.adj.get(0).add(1);
		g.adj.get(2).add(0);
		g.adj.get(1).add(2);
		g.adj.get(2).add(3);
		g.adj.get(3).add(4);
		g.adj.get(3).add(5);
		//g.adj.get(5).add(0);
		boolean[] visited=new boolean[g.v];
		Stack<Integer> stack=new Stack<Integer>();
		boolean result=false;
		for(int i=0;i<g.v;i++)
		{
			if(isCyclic(i,visited,stack,g))
			{
				result=true;
			}
		}
		
		if(result)
		{
			System.out.println("there is a cycle");
		}
		else
		{
			System.out.println("there is no cycle");
		}
		
	}
	
}
