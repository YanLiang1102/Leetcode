public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> map=generateParentMap(pid,ppid);
        List<Integer> rst=new ArrayList<Integer>();
        if(!pid.contains(kill))
         return rst;
        rst.add(kill);
        if(!map.containsKey(kill))
        return rst;
        Queue<Integer> q=new LinkedList<Integer>();
        q.addAll(map.get(kill));
        while(!q.isEmpty())
        {
            int tmp=q.poll();
            rst.add(tmp);
            if(map.containsKey(tmp))
            {
                q.addAll(map.get(tmp));
            }
        }
        return rst;
        
    }
    
    public HashMap<Integer,List<Integer>> generateParentMap(List<Integer> pid,List<Integer> ppid)
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<pid.size();i++)
        {
            if(!map.containsKey(ppid.get(i)))
            {
                map.put(ppid.get(i),new ArrayList<Integer>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        return map;
        
    }
}