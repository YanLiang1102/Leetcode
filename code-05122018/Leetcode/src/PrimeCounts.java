/****
the idea is if you find a prime, then mark all the multiple of that prime not prime.
****/
class Solution {
    public int countPrimes(int n) {
        if(n==0||n==1||n==2)
        {
            return 0;
                
        }
        if(n==3)
        {
            return 1;
        }
        //if it prime[i] is true menas i is a prime
        
        int count=0;
        boolean[] prime=new boolean[n];
        for(int i=0;i<n;i++)
        {
            prime[i]=true;
        }
        
        for(int i=2;i<n;i++)
        {
            if(!prime[i])
            {
                continue;
            }
            count++;
            for(int j=i;j<n;j=j+i)
            {
                prime[j]=false;
            }
        }
        
        return count;
        
        
  
    }
    
  
    
}
