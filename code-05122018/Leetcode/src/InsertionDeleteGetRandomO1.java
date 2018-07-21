/****
since getRandom is o(1) and there is no way to index a hashmap but we can index an array and use hashmap to store the index of
that array.
*****/
public class RandomizedSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> set;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        set= new ArrayList<Integer>();
        map=new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val))
           {
               
               set.add(val);
               map.put(val,set.size()-1);
               return true;
           }
         return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
          return false;
        else
        {
            /*set.remove(map.get(val));
            map.remove(val);*/
            int loc=map.get(val);
            int lastnode=set.get(set.size()-1);
            set.set(loc,lastnode);
            set.remove(set.size()-1);
            map.put(lastnode,loc);
            map.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size=set.size()-1;
        int random=(int)(0+Math.random()*(size-0+1));
        return set.get(random);
    }
}
