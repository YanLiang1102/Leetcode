import java.io.*;
import java.util.*;
import java.util.LinkedList;
	
public class CourseDependency {

	public static boolean canFinish(int coursenum, int[][] prereq)
	{
		int[] total=new int[coursenum];
		LinkedList<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<coursenum;i++)
		{
			for(int j=0;j<coursenum;j++)
			{
				if(prereq[i][j]==1)
				{
					total[i]++;
				}
			}
			if(total[i]==0)
			{
				//these are the nodes does not have any dependency
				q.offer(i);
			}
		}	
		int totalCount=0;
		while(!q.isEmpty())
		{
			Integer cur=q.poll();
			System.out.println(cur);
			totalCount++;
			for(int i=0;i<coursenum;i++)
			{
				if(prereq[i][cur]==1)
				{
					total[i]--;
					if(total[i]==0)
					{
						q.add(i);
					}
				}
				
			}
			
		}
		
		return totalCount==coursenum;
	}
	
	public static void main(String[] args)
	{
		int[][] prereq=new int[4][4];
		//this means that 1 has 0 as prerequsite.
		prereq[1][0]=1;
		prereq[2][1]=1;
		prereq[3][1]=1;
		prereq[2][3]=1;
		
		if(canFinish(4,prereq))
		{
			System.out.println("hey I can finish this!");
		}
		else
		{
			System.out.println("hey there is a cycle somewhere!");
		}
	}
    
	
}
