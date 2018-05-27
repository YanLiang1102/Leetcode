import java.util.*;

public class TrappingWater {

	public static int findMaxIndex(int[] heights) {
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < heights.length; i++) {
			if (heights[i] > max) {
				max = heights[i];
				maxIndex = i;
			}

		}
		return maxIndex;
	}

	public static int maxWater(int[] heights, int start, int end) {
		if (heights.length == 0 || heights.length == 1) {
			return 0;
		}
		int runningmax = 0;
		int water = 0;
		if (start <= end) {
			for (int i = start; i <= end; i++) {
				runningmax = Math.max(runningmax, heights[i]);
				water += runningmax - heights[i];
			}

		} else {
			//this needs to be ends+1 we need to do [0,max-1],[n-1,max+1]
			//if we have end only then it will fail on test case [100,0,100]
			for (int i = start; i >= end + 1; i--) {
				runningmax = Math.max(runningmax, heights[i]);
				water += runningmax - heights[i];
			}

		}

		return water;
	}

	public static int trapRainWater(int[] heights) {
		// write your code here
		// for 0 to maxIndex-1 and from n-1 to maxIndex
		int maxindex = findMaxIndex(heights);
		return maxWater(heights, 0, maxindex - 1) + maxWater(heights, heights.length - 1, maxindex);
	}

	public static void main(String[] args) {
		// int[] heights=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		int[] heights = new int[] { 100, 0, 100 };
		int maxindex = findMaxIndex(heights);
		System.out.println(maxindex);
		int left = maxWater(heights, 0, maxindex - 1);
		System.out.println("left: " + left);
		int right = maxWater(heights, heights.length - 1, maxindex);
		System.out.println("right: " + right);
		int result = trapRainWater(heights);
		System.out.println(result);

	}

}
