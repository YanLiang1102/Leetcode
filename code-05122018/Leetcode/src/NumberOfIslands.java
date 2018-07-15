class Solution {
    //bfs
    public int numIslands(char[][] grid) {
         if(grid==null)
         {
             return 0;
         }
         if(grid.length==0)
         {
             return 0;
         }
         if(grid[0].length==0)
         {
             return 0;
         }
        int row=grid.length;
         int col=grid[0].length;
        
          
        
        int count=0;
         for(int i=0;i<row;i++)
         {
             for(int j=0;j<col;j++)
             {
                 if(grid[i][j]=='1')
                 {
                     count++;
                     //bfs mark everything
                     bfs(grid,i,j,row,col);
                     
                 }
             }
         }
        return count;
        
    }
    
    public void bfs(char[][] grid, int i, int j, int row, int col)
    {
           if(i>=row||i<0||j>=col||j<0)
           {
               return;
           }
           if(grid[i][j]=='1')
           {
               grid[i][j]='0';
               bfs(grid,i-1,j,row,col);
               bfs(grid,i+1,j,row,col);
               bfs(grid,i,j-1,row,col);
               bfs(grid,i,j+1,row,col);
           }
    }
}
