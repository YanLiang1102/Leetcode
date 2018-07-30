/****
use dfs to search only need to go right and bottom. beat 32% not very fast though
****/
class Solution {
    public int islandPerimeter(int[][] grid) {
        //if it is 0 on boudary of a 1 then we will add 1 to the perimeter length
        if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0)
        {
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        
        int[] count=new int[1];
        boolean[][] visited=new boolean[row][col]; 
        updatevalue(count, grid, 0,0,row, col,visited);
        return count[0];
    }
    
    
    public void updatevalue(int[] count, int [][] grid, int i, int j, int row, int col,boolean[][] visited)
    {
        if(i<0||j<0||i>=row||j>=col||visited[i][j])
        {
            return;
        }
        
        visited[i][j]=true;
        
        if(grid[i][j]==1)
        {
            if(i-1<0||grid[i-1][j]==0)
            {
                count[0]++;
            }

            if(i+1>row-1||grid[i+1][j]==0)
            {
                count[0]++;
            }
            if(j-1<0||grid[i][j-1]==0)
            {
                count[0]++;
            } 

            if(j+1>col-1||grid[i][j+1]==0)
            {
                count[0]++;
            }               
        }
        updatevalue(count, grid, i+1,j,row,col,visited);
        updatevalue(count, grid, i,j+1,row,col,visited);               
    }
}
