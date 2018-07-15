/******
This problem is the same idea of generateValideParentheses
*******/
class Solution {
    //this is similar to generate parentheses
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.isEmpty())
        {
            //return null;
            return new ArrayList<String>();
        }
        
       HashMap<Character, String> map= new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        
        map.put('8',"tuv");
        map.put('9',"wxyz");
        ArrayList<String> rst=new ArrayList<String>();
        helper("",rst, 0,digits,map);
        return rst;
    }
    
    public void helper(String one, List<String> rst, int index, String digits, HashMap<Character,String> map)
    {
        if(one.length()==digits.length())
           {
              rst.add(one);
           }
        for(int i=index;i<digits.length();i++)
           {
               String temp=map.get(digits.charAt(i));
               for(int j=0;j<temp.length();j++)
               {
                   helper(one+temp.charAt(j),rst,i+1,digits,map);
               }             
           }
        
    }
}
