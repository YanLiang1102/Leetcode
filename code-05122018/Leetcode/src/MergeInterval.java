import java.util.*;

class Interval
{
	int left;
	int right;
	Interval(int left, int right)
	{
		this.left=left;
		this.right=right;
	}
	
}
class IntervalComparator implements Comparator<Interval>
{

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.left-o2.left;
	}
	
}
public class MergeInterval {
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals)
	{
		ArrayList<Interval> result=new ArrayList<Interval>();
		Collections.sort(intervals, new IntervalComparator());
		if(intervals==null||intervals.size()==1||intervals.size()==0)
		{
			return intervals;
		}
		result.add(intervals.get(0));
		for(int i=1;i<intervals.size();i++)
		{
			Interval curr=intervals.get(i);
		    Interval last=result.get(result.size()-1);
			if(curr.left<=last.right)
			{
				Interval newInterval=new Interval(last.left,curr.right);
				result.remove(result.size()-1);
				result.add(newInterval);
			}
			else
			{
				result.add(curr);
			}			
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Interval> intervals=new ArrayList<Interval>();
		Interval i1=new Interval(1,3);
		Interval i2=new Interval(8,15);
		Interval i3=new Interval(2,6);
		Interval i4=new Interval(15,18);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		Collections.sort(intervals, new IntervalComparator());
		ArrayList<Interval> result=merge(intervals);
		for(Interval item:result)
		{
			System.out.print("["+item.left+","+item.right+"]");
		}
		
	}
	
}
