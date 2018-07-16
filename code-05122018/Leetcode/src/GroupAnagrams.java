/***
fast solution is to use sort the int[26] takes too much space.
***/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<String>> result= new ArrayList<>();
        if(strs==null||strs.length==0)
          return null;
        HashMap<String, ArrayList<String>> map= new HashMap<String, ArrayList<String>>();
        for(String str:strs)
        {
            char[] tmp=str.toCharArray();
            Arrays.sort(tmp);
            String newkey=String.valueOf(tmp);
            if(!map.containsKey(newkey))
              map.put(newkey,new ArrayList<String>());
            map.get(newkey).add(str);
        }        
        return new ArrayList<>(map.values());
    }
}
