import java.util.*;

class  UnionFindForNumberOfClusters {
	//well I know thsi unionFind is working but exceed time on leetcode check with an row of number all 0's
    class UnionFind
    {
        int length;
        int[] parent;
        //for isladn 1
        //int[] nums;
        UnionFind(int length)
        {
            this.length=length;
            parent=new int[length];
            for(int i=0;i<length;i++)
            {
                parent[i]=i;
            }
        }
        //set the parent of j as the parent of i , also all the element that in the cluster of i should get updated too
        public void union(int i, int j)
        {
             int temp=parent[i];
            for(int k=0;k<length;k++)
            {
                if(parent[k]==temp)
                {
                    parent[k]=parent[j];
                }
            }
        } 
        
        public int getNumberOfClusters()
        {
            HashSet<Integer> set=new HashSet();
            for(int i=0;i<parent.length;i++)
            {
                if(!set.contains(parent[i]))
                {
                    set.add(parent[i]);
                }
            }
            return set.size();
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
        {
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        
        UnionFind ins=new UnionFind(row*col);
        for(int i=0;i<row;i++)
        {
        	for(int j=0;j<col;j++)
        	{
        	   union(grid, i, j, row, col, ins);
        	}
        	
        }
        //this is the general case, you can return how many different islands there are
        //return ins.getNumberOfClusters();
        
        int[] parent=ins.parent;
        //int count=0;
        HashSet<Integer> hash=new HashSet<Integer>();
        for(int i=0;i<parent.length;i++)
        {
        	if((!hash.contains(parent[i]))&&grid[i/col][i%col]=='1')
        	{
        		hash.add(parent[i]);
        	}
        }
        return hash.size();
        
    }
    
    public void union(char[][] grid,int i, int j, int row, int col, UnionFind uf)
    {
    	 if(i>=row||i<0||j>=col||j<0)
         {
             return;
         }
    	 if(i-1>=0&&grid[i][j]==grid[i-1][j])
    	 {
    		 uf.union(i*col+j,(i-1)*col+j);
    	 }
    	 if(j-1>=0&&grid[i][j]==grid[i][j-1])
    	 {
    		 uf.union(i*col+j,(i)*col+j-1);
    	 }
    	 if(i+1<row&&grid[i+1][j]==grid[i][j])
    	 {
    		 uf.union((i+1)*col+j,(i)*col+j);
    	 }
    	 if(j+1<col&&grid[i][j]==grid[i][j+1])
    	 {
    		 uf.union(i*col+j,(i)*col+j+1);
    	 }
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
    
    public static void main(String[] args)
    {
    	char[][] grid=new char[4][5];
    	grid[0]=new char[5];
    	grid[1]=new char[5];
    	grid[2]=new char[5];
    	grid[3]=new char[5];
    	
    	grid[0][0]='1';
    	grid[0][1]='1';
    	grid[0][2]='1';
    	grid[0][3]='1';
    	grid[0][4]='0';
    	
    	grid[1][0]='1';
    	grid[1][1]='1';
    	grid[1][2]='0';
    	grid[1][3]='1';
    	grid[1][4]='0';
    	
    	grid[2][0]='1';
    	grid[2][1]='1';
    	grid[2][2]='0';
    	grid[2][3]='0';
    	grid[2][4]='0';
    	
    	grid[3][0]='0';
    	grid[3][1]='0';
    	grid[3][2]='0';
    	grid[3][3]='0';
    	grid[3][4]='0';
    	
    	UnionFindForNumberOfClusters ins=new UnionFindForNumberOfClusters();
    	int rst=ins.numIslands(grid);
    	System.out.println(rst);
    }
}
