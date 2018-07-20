/****
This is kind of like a dp problem, find the relation between f(n) and f(n-1) then you don't need to repeatly calculate everything each time.
****/
class Solution {
    public int maxRotateFunction(int[] A) {
        if(A==null||A.length==0||A.length==1)
        {
            return 0;
        }
        
        int sum=0;
        int curr=0;
        for(int i=0;i<A.length;i++)
        {
            sum+=A[i];
            curr+=A[i]*i;
        }
        
        int max=curr;
        int n=A.length;
        for(int i=1;i<n;i++)
        {
            curr=curr+(sum-A[n-i])-(n-1)*A[n-i];
            max=Math.max(max,curr);
        }
        return max;
        
    }
}
