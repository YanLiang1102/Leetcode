class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null)
        {
            return false;
        }
        int length1=s.length();
        int length2=t.length();
        if(length1!=length2)
        {
            return false;
        }
        
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        
        for(int i=0;i<length1;i++)
        {
            char a=s.charAt(i);
            char b=t.charAt(i);
            arr1[a-'a']=arr1[a-'a']+1;
            arr2[b-'a']=arr2[b-'a']+1;
        }
        
       return  Arrays.equals(arr1,arr2);
        
    }
}
