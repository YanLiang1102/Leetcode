//using a heap and also boolean[][] to keep track of something is visited or not, 
//since u might get to one node from different path.
class Solution {
    class Pair{
        int i;
        int j;
        int value;
        public Pair(int i, int j, int value)
        {
            this.i=i;
            this.j=j;
            this.value=value;
        }
    }
    class Newcomparator implements Comparator<Pair>
    {
       public int compare(Pair a,Pair b)
       {
           return a.value-b.value;
       }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
           {
               return 0;
           }
        
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new Newcomparator());
        int row=matrix.length;
        int col=matrix[0].length;
        boolean[][] visited=new boolean[row][col];
        pq.add(new Pair(0,0,matrix[0][0]));
        int count=0;
        visited[0][0]=true;
        while(count<=k)
           {
              
              Pair curr=pq.poll();
              count++;
         //   System.out.println(String.valueOf(count)+" "+String.valueOf(curr.value));
            if(count==k)
            {
                return curr.value;
            }
              int i=curr.i;
              int j=curr.j;
              
              if(i+1<row&&!visited[i+1][j])
              {
                 pq.add(new Pair(i+1,j,matrix[i+1][j]));
                  visited[i+1][j]=true;
              }
               if(j+1<col&&!visited[i][j+1])
              {
                 // System.out.println(i);
                 // System.out.println(j);
                   visited[i][j+1]=true;
                 pq.add(new Pair(i,j+1,matrix[i][j+1]));
              }
           }
        return 0;
    }
           
}
