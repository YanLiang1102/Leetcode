class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> l0=new ArrayList<Integer>();
        l0.add(1);
        if(rowIndex==0)
        {
            return l0;
        }
        l0.add(1);
        if(rowIndex==1)
        {
            return l0;
        }
        List<Integer> temp=new ArrayList<Integer>();
        for(int i=1;i<rowIndex+1;i++)
        {
            List<Integer> rst=new ArrayList<Integer>();
           rst.add(1);
           for(int j=0;j<temp.size()-1;j++)
           {
               rst.add(temp.get(j)+temp.get(j+1));
           }
           rst.add(1); 
           temp=rst;
        }
        return temp;
        
    }
}
