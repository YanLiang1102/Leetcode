import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class WeaveList {

	// this is one of the function for the problem on cracking the interview page
	// 263 BST sequence problem,
	// this is to weave two list together but remain the order of each original
	// list.
	// I generate this all by myslef and also the idea and I implement the one with
	// prefix with the idea the book give and compare the result
	public static ArrayList<ArrayList<Integer>> weaveList(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> one,
			LinkedList<Integer> list1, LinkedList<Integer> list2, int size, int pos1, int pos2) {
		if (one.size() == size) {
			result.add(new ArrayList<Integer>(one));
		}
		for (int i = pos1; i < list1.size(); i++) {
			one.add(list1.get(i));
			weaveList(result, one, list1, list2, size, i + 1, pos2);
			one.remove(one.size() - 1);
		}
		for (int i = pos2; i < list2.size(); i++) {
			one.add(list2.get(i));
			weaveList(result, one, list1, list2, size, pos1, i + 1);
			one.remove(one.size() - 1);
		}

		return result;

	}

	// using the idea of first, second and prefix to get all the weave list,
	// the prefix idea is easily to be used when you are recursively working on a
	// tree,
	public static void weaveList2(ArrayList<LinkedList<Integer>> result, LinkedList<Integer> left,
			LinkedList<Integer> right, LinkedList<Integer> prefix) {
		// any of the size is 0 means the recursive should stop
		if (left.size() == 0 || right.size() == 0) {
			LinkedList<Integer> one = new LinkedList<Integer>(prefix);
			one.addAll(left);
			one.addAll(right);
			result.add(one);
			return;
		}

		int first = left.removeFirst();
		prefix.addLast(first);
		weaveList2(result, left, right, prefix);
		prefix.removeLast();
		left.addFirst(first);

		first = right.removeFirst();
		prefix.addLast(first);
		weaveList2(result, left, right, prefix);
		prefix.removeLast();
		right.addFirst(first);

	}
	public static ArrayList<LinkedList<Integer>> bstSequence(TR root)
	{
		ArrayList<LinkedList<Integer>> result=new ArrayList<LinkedList<Integer>>();
		
		if(root==null)
		{
			//this is very necessary otherwise it return nothing ,sicen when u go the base case, the result will be empty and the loop will not get
			//run, so the prefix will not be added in
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		ArrayList<LinkedList<Integer>> left=bstSequence(root.left);
		ArrayList<LinkedList<Integer>> right=bstSequence(root.right);
		LinkedList<Integer> prefix=new LinkedList<Integer>();
		prefix.add(root.val);
		//here if you don't add the newLinkedList<Integer>() to the result, then this loop will not get run, so the prefix will not get added, 
		//the consequence is it will return nothing.
		for(LinkedList<Integer>i:left)
		{
			for(LinkedList<Integer>j:right)
			{
				ArrayList<LinkedList<Integer>> temp=new ArrayList<LinkedList<Integer>>();				
				weaveList2(temp,i,j,prefix);
				result.addAll(temp);
				
			}
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		LinkedList<Integer> prefix = new LinkedList<Integer>();

		l1.add(1);
		l1.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(5);

		
		TR n2=new TR(2);
		TR n1=new TR(1);
		TR n3=new TR(3);
		n2.left=n1;
		n2.right=n3;
		
		ArrayList<LinkedList<Integer>> finalresult=bstSequence(n2);
		for(LinkedList<Integer> link:finalresult)
		{
			for(int i:link)
			{
				System.out.print(i+",");
			}
			System.out.println("endbst");
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = weaveList(result, new ArrayList<Integer>(), l1, l2, l1.size() + l2.size(), 0, 0);
		for (ArrayList<Integer> l : result) {
			for (int i : l) {
				System.out.print(i + ",");
			}
			System.out.println("end");
		}
		System.out.println("weavelist2 solution:");
		ArrayList<LinkedList<Integer>> result2 = new ArrayList<LinkedList<Integer>>();
		weaveList2(result2, l1, l2, prefix);
		for (LinkedList<Integer> l : result2) {
			for (int i : l) {
				System.out.print(i + ",");
			}
			System.out.println("end");
		}

		/*
		 * test feature of LinkedList, the addFirst adn removeFirst, and addLast and
		 * removeLast feature is what we need for this problem.
		 * 
		 */
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(1);
		test.add(2);
		test.addFirst(0);
		test.addLast(3);

		for (Integer i : test) {
			System.out.println(i);
		}
	}
	
	
}
