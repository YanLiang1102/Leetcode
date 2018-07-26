//the hard part of this is to make it in place
//I did it in a very clever way and get a one time pass
//since (i,j) will be mapped to (j,size-1-i) so we can see that if you do a reflection against diagnal then swap the columns using two pointers you will get what u want
//since when you swap against diagnal (i,j)->(j,i) and then refect columns will make (j,i)->(j,size-1-i) then we get what we want
//my code
class Solution {
    public void rotate(int[][] matrix) {
    //   (0,0)->(0,2)
    //(0,1)->(1,2)
          // (0,2)->(2,2)
        //i,j->(j,size-1-i)
        
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
        {
            return ;
        }
        //swap against the diagnal then using two pointers to switch rows based on if the number of rows is odd or even
        int size=matrix.length;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<i;j++)
            {
                swap(matrix,i,j,j,i);
            }
        }
        //then change the colums
        
        int col1=0;
        int col2=size-1;
        while(col1<col2)
        {
            switchColumn(matrix,col1,col2);
            col1++;
            col2--;
        }
        
        
    }
    public void switchColumn(int[][]matrix,int col1, int col2)
    {
        int size=matrix.length;
        for(int i=0;i<size;i++)
        {
            swap(matrix,i,col1,i,col2);
        }
    }
    public void swap(int[][] matrix, int i1,int j1, int i,int j)
    {
        int temp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i][j];
        matrix[i][j]=temp;
    }
}
