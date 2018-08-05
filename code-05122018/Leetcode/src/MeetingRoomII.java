/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
/*****
store the end time in a priority queue and keep looping through the intervals, if the interval start is less than top of the 
queue, not pop add the end to the queue, while the interval start is bigger than the top of the quueu, pop the element, still add
the end to the queue, the maximum room needed is during the process, the biggest size of then heap(priority queue ever)
*****/
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
         // Write your code here
        if(intervals==null||intervals.size()==0)
        {
            return 0;
        }
        // if(intervals.size()==1)
        // {
        //     return 1;
        // }
        Collections.sort(intervals, new Newcomparator());
        int count=1;
        //Stack<Integer> stack =new Stack<Integer>();
        int maxcount=1;
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
        heap.add(intervals.get(0).end);
        int prevstart=intervals.get(0).start;
        for(int i=1;i<intervals.size();i++)
        {
            Interval curr=intervals.get(i);
            if(curr.start<heap.peek())
            {
          
               // count++;
                //heap.add(curr.end);
               // maxcount=Math.max(maxcount,count);
            }
            else
            {
                while(curr.start>=heap.peek())
                {
                    heap.poll();
                    count--;
                }
            }
            heap.add(curr.end);
            count++;
            maxcount=Math.max(maxcount,count);
            
        }
        return maxcount;
    }
    
    public class Newcomparator implements Comparator<Interval> 
    {
        @Override
         public int compare (Interval a, Interval b)
        {
           return (a.start-b.start);
        }
    }

}



/*****
meeting room 2 second time practise
*****/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if(intervals==null||intervals.size()==0)
        {
            return 0;
        }
        int max=1;
        Collections.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        pq.add(intervals.get(0).end);
        int size=intervals.size();
        for(int i=1;i<size;i++)
        {
            int currstart=intervals.get(i).start;
            int currend=intervals.get(i).end;
            //in the description I used to have an if there, this should be an while!!
            //I noticed it and directly write a while and passed it.
            while(!pq.isEmpty()&&currstart>pq.peek())
            {
                pq.poll();
            }
            pq.add(currend);
            max=Math.max(max,pq.size());
        }
        return max;
    }
    
    class IntervalComparator implements Comparator<Interval>
    {
        //@override
        public int compare(Interval a, Interval b)
        {
            return a.start-b.start;
        }
    }
}


