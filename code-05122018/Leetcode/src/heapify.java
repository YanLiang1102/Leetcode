
import java.util.*;

//implement both siftUp and siftDown to build up a heap

public class heapify {
	
   public static void siftUp(int[]A, int index) {
	   int parent=(index-1)/2;
	   while(A[index]<A[parent])
	   {
		   int temp=A[index];
		   A[index]=A[parent];
		   A[parent]=temp;
		   index=parent;
		   parent=(index-1)/2;
	   }
   }
   
   public static void heapAllUp(int[] A)
   {
//	   for(int i=A.length-1;i>=0;i--)
//	   {
//		   siftUp(A,i);
//	   }
	   for(int i=0;i<A.length;i++)
	   {
		   siftUp(A,i);
	   }
   }
	
	
   public static void main(String[] args)
   {
	  int[] A=new int[] {6,3,1,2,5,4};
	  //after siftup of 2 it will become 6,3,12,5,4
	  //siftUp(A,3);
	  heapAllUp(A);
	  //print out the new array
	  for(int i=0;i<A.length;i++)
	  {
		  System.out.print(A[i]+",");
	  }
   }
}
