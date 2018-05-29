import java.util.*;

public class IntegerPermutation {
	
    public static void permutateNoDup(ArrayList<Integer> input, ArrayList<ArrayList<Integer>>result, ArrayList<Integer>one)
    {
    	if(one.size()==input.size())
    	{
    		result.add(new ArrayList<Integer>(one));
    	}
    	
    	for(int i=0;i<input.size();i++)
    	{
    		int value=input.get(i);
    		if(!one.contains(value))
    		{
    			one.add(value);
    			permutateNoDup(input,result,one);
    			one.remove(one.size()-1);
    		}
    		else {
    			continue;
    		}
    	}
    }
    
    public static void permutateDup(HashMap<Integer, Integer> hash,ArrayList<Integer> one, ArrayList<ArrayList<Integer>>result,int size)
    {
    	if(one.size()==size)
    	{
    		result.add(new ArrayList<Integer>(one));
    		return;
    	}
    	for(int k:hash.keySet())    		
    	{
    		int count=hash.get(k);
    		if(count>0)
    		{
    		  one.add(k);
    		  hash.put(k, count-1);
    		  permutateDup(hash,one,result,size);
    		  hash.put(k, count);
    		  one.remove(one.size()-1);
    		}
    	}
    	
    }
    
    /*
     * build the hash in this way
     */
    public static HashMap<Integer, Integer> buildHash(ArrayList<Integer> input)
    {
    	//using a hash to make sure that 1, 2(1),2(2), 1,2(2),2(1),will be one, since when we loop we only loop the keyset, and 2(1) and 2(2) share the same key
    	//this kind of idea need to be remember hard.
         HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
         for(int i:input)
         {
        	 if(hash.containsKey(i))
        	 {
        		 hash.put(i, hash.get(i)+1);
        	 }
        	 else
        	 {
        		 hash.put(i, 1);
        	 }
         }
         return hash;
    }
    
    public static void main(String[] args)
    {
    	ArrayList<Integer> input=new ArrayList<Integer>();
    	input.add(1);
    	input.add(2);
    	input.add(2);
    	//input.add(4);
    	
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	//permutateNoDup(input,result,new ArrayList<Integer>());
    	HashMap<Integer,Integer> hash=buildHash(input);
        permutateDup(hash,new ArrayList<Integer>(),result,3);
    	for(ArrayList<Integer> item: result)
    	{
    	    for(int i:item)
    	    {
    	    	System.out.print(i+",");
    	    }
    	    System.out.println(" ");
    	}
    	
    }
}
