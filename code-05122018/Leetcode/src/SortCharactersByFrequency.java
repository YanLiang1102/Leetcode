/****
I never saw this problem and get a one time pass, but only beat like 60% can be optimized
****/
class Solution {
    class Pair{
        char c;
        int count;
        Pair(char c, int count)
        {
            this.c=c;
            this.count=count;
        }
    }
    class Newcomparator implements Comparator<Pair>{
      //  @override
        public int compare(Pair a, Pair b)
        {
            //in this way who is bigger in the pq will come first.
            return b.count-a.count;
        }
    }
    public String frequencySort(String s) {
        if(s==null||s.length()==0||s.length()==1||s.length()==2)
        {
            return s;
        }
        
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        
        for(int i=0;i<s.length();i++)
        {
            char curr=s.charAt(i);
            if(!map.containsKey(curr))
            {
                map.put(curr,1);
            }
            else
            {
                map.put(curr, map.get(curr)+1);
            }
        } 
        
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new Newcomparator());
        for(char key:map.keySet())
        {
            Pair p=new Pair(key,map.get(key));
            pq.add(p);
        }
        
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            for(int j=0;j<curr.count;j++)
            {
                sb.append(curr.c);
            }
        }
        return sb.toString();
    }
}
