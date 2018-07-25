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


//using bucket sort instead of priority Queue makes it a little bit faster.
/****
the idea is using bucket sort, use the frequency as the index as the array so it will be a little bit faster than the priority queue solution.
****/
class Solution {
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
        
        //in my mind I have this idea, but I don't know this is called bucket sort.
        //since the frequency can be the size and if it zero based then the size should be go up to map.size()+1
        List<Character> [] bucket=new List[s.length()+1];

        for(Character key: map.keySet())
        {
            int freq=map.get(key);
            if(bucket[freq]==null)
            {
                bucket[freq]=new ArrayList<Character>();
            }
            bucket[freq].add(key);
        }
        
        StringBuilder sb=new StringBuilder();
        //we use the frequency as index so in this way we have a natural sort
        for(int i=bucket.length-1;i>=0;i--)
        {
            if(bucket[i]==null)
            {
                continue;
            }
            else
            {
                List<Character> curr=bucket[i];
                for(int k=0;k<curr.size();k++)
                {
                    char c=curr.get(k);
                    for(int j=0;j<i;j++)
                    {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
