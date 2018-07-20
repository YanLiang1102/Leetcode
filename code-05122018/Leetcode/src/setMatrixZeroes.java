/***
idea is to use first row and first column to store the state in this way you only use O(1) space, but since you will pollute the state of the first row and first column so you need to store that information in a boolean value see if col1 and row1 has 0 at the begining.
***/
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
        {
            return ;
        }
        boolean row1=false;
        boolean col1=false;
        int row=matrix.length;
        int col=matrix[0].length;
        
        for(int i=0;i<row;i++)
        {
            if(matrix[i][0]==0)
            {
                col1=true;
            }
        }
        for(int j=0;j<col;j++)
        {
            if(matrix[0][j]==0)
            {
                row1=true;
            }
        }
        
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
   
        for(int i=1;i<row;i++)
        { 
                    continue;
            for(int j=1;j<col;j++)
            {
                if(matrix[i][0]==0)
                {
                    matrix[i][j]=0;
                    continue;
                }
                if(matrix[0][j]==0)
                {
                    matrix[i][j]=0;      
                }
            }
        }
        if(col1)
        {
            for(int i=0;i<row;i++)
            {
                matrix[i][0]=0;
            }
        }
        if(row1)
        { 
            for(int j=0;j<col;j++)
            {
                matrix[0][j]=0;
            }
            
        }
        return;
    }
}
