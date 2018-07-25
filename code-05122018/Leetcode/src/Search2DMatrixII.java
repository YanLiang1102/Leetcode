/*****
made it pass with a dfs solution but only beat like 2%  on leetcode :P
*****/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // I think kind of using a dfs seach will towards , I made pass using dfs but only beat like 2% :P
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
        {
            return false;
        }
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        int row=matrix.length;
        int col=matrix[0].length;
        
        return helper(matrix, visited, 0,0,target,row,col);
        
    }
    
    public boolean helper(int[][]matrix,boolean[][]visited, int i, int j, int target, int row, int col)
    {
        if(matrix[i][j]==target)
        {
            return true;
        }
        visited[i][j]=true;
        if(matrix[i][j]<target)
        {
            boolean right=false;
            boolean bottom=false;
            if(isValid(row,col,i+1,j)&&!visited[i+1][j])
            {
                right=helper(matrix,visited,i+1,j,target,row,col);
            }
            if(isValid(row,col,i,j+1)&&!visited[i][j+1])
            {
                bottom=helper(matrix,visited,i,j+1,target,row,col);
            }
            
            return right||bottom;
        }
        return false;
    }
    
    public boolean isValid(int row, int col, int i, int j)
    {
        return i<row&&j<col;
    }
    
    
}

//this is an O(M+N) solution much better than the dfs one, 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

       //great O(m+n) solution, each time will rule out either a row or col
        //well the clever part is , it try to start at the top right, I started at top left
    
       if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
       {
           return false;
       }
        
        int row=matrix.length;
        int i=0;
        int col=matrix[0].length-1;
        int j=col;
        while(i<row&&j>=0)
        {
            if(matrix[i][j]==target)
            {
                return true;
            }
            else if(matrix[i][j]<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return false;
    }
    
    
}
