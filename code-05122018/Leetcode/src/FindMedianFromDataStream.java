import java.util.*;

public class FindMedianFromDataStream {

	//need two priority queue in this class
	Queue<Integer> higher;
    Queue<Integer> lower;
	public FindMedianFromDataStream()
	{
		higher=new PriorityQueue<Integer>();
		lower=new PriorityQueue<Integer>(Collections.reverseOrder());		
	}
	/*
	 * the size(higher)>=size(lower)
	 */
	public void addNumber(int num)
	{
        if(higher.size()==0)
        {
        	higher.add(num);
        	return;
        }
		if(higher.size()<=lower.size())
		{
			int top=higher.peek();
			if(num>=top)
			{
				higher.add(num);
			}
			else
			{
				lower.add(num);
				//need to make sure it is balanced somehow
				higher.add(lower.poll());
			}
		}
		//if higher already bigger than lower, then need to pop oen from higher add to lower then we can add value to the higher
		else
		{
			int top=higher.peek();
			if(num>=top)
			{
				lower.add(higher.poll());
				higher.add(num);
			}
			else
			{
			  lower.add(num);
			}
			
		}
		
		
	}
	
	public double findMedian()
	{
		if(lower.size()==higher.size())
		{
			return (lower.peek()+higher.peek())/2.0;
		}
		else
		{
			return higher.peek();
		}
	}
	
	public static void main(String[] args)
	{
		FindMedianFromDataStream solver= new FindMedianFromDataStream();
		solver.addNumber(2);
		solver.addNumber(98);
		solver.addNumber(1);
		solver.addNumber(3);
		solver.addNumber(99);
		solver.addNumber(100);
		solver.addNumber(7);
		double sol=solver.findMedian();
		System.out.println(sol);
	
	}	
}
