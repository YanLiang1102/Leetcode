import java.io.*;
import java.util.*;

public class IsValidBST {
	// Definition for a binary tree node.

	public boolean isValid(TR root) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		copyBST(root,arr);
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i) < arr.get(i + 1))
				continue;
			else
				return false;
		}
		return true;
	}

	private void copyBST(TR root, ArrayList<Integer> arr) {
		if (root == null)
			return;
		copyBST(root.left, arr);
		arr.add(root.val);
		System.out.println(root.val);
		copyBST(root.right, arr);
	}

	public static void main(String[] args) {
		IsValidBST solution=new IsValidBST();
		TR n5 = new TR(5);
		TR n1 = new TR(1);
		TR n4 = new TR(4);
		TR n3 = new TR(3);
		TR n6 = new TR(6);
		
		n5.left=n1;
		n5.right=n4;
		n4.left=n3;
		n4.right=n6;
		
		//n5 is the starting node.
		if(solution.isValid(n5)) {
			System.out.println("valid");
		}
		else
		{
			System.out.println("invalid");
		}

	}
}
