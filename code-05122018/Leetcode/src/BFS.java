import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class BFS {
  int V;
  LinkedList<Integer> adj[];
  
  BFS(int v)
  {
	  V=v;
	  adj=new LinkedList[V];
	  for(int i=0;i<v;i++)
	  {
		  adj[i]=new LinkedList();
	  }
  }
  
  private void addEdge(int w, int v)
  {
	  adj[w].add(v);
  }
  
  //need to print the bfs traverse order stuff, s is the node that we start traverse
  private void printTraversal(int s) {
	  LinkedList<Integer> queue=new LinkedList<Integer>();
	  boolean[] visited=new boolean[V];
	  
	  queue.add(s);
	  visited[s]=true;
	  Iterator<Integer> i;
	  while(!queue.isEmpty())
	  {
		  int c=queue.poll();
		  System.out.println(c+",");
		  i=adj[c].listIterator();
		  while(i.hasNext())
		  {
			  int n=i.next();
			  if(visited[n])
			  {
				  continue;
			  }
			  queue.add(n);
			  visited[n]=true;
		  }		  
	  }
	  
  }
  
	 public static void main(String[] args) {
		 // Create a graph given in the above diagram
	        BFS g = new BFS(5);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	        g.addEdge(0, 4);
	        g.printTraversal(0);
	        
	 }
}
