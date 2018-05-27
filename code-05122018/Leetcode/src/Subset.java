import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Subset {
	// this is with no dup the idea to implement this here is to get subset(n-1)
	// then copy all the subset(n-1) +subset(n-1)+{n}
	// thsi is for the no duplicate case, what if it has duplicate????
	/*
	 * this is like top down, so in order to know p(n) we needs to know p(n-1)....at
	 * the end reach to the base case p(0)
	 */
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> input, int index,
			ArrayList<ArrayList<Integer>> result) {

		// base case for adding in the empty list
		if (input.size() == index) {
			result.add(new ArrayList<Integer>());
		} else {

			int item = input.get(index);
			ArrayList<ArrayList<Integer>> temp = getAllSubsets(input, index + 1, result);
			ArrayList<ArrayList<Integer>> moretemp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> t : temp) {
				ArrayList<Integer> more = new ArrayList<Integer>();
				more.addAll(t);
				more.add(item);
				moretemp.add(more);
			}
			result.addAll(moretemp);
		}

		return result;

	}

	// another way to implement this would be bottom up, we know p(0), then we know
	// p(1), then we know p(2)....all the way build up.
	public static void getAllSubsets2(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> one, int pos) {
		// the first call will add in the empty set.
		result.add(new ArrayList<Integer>(one));
		if (pos == input.size()) {
			return;
		}
		for (int i = pos; i < input.size(); i++) {
			one.add(input.get(i));
			getAllSubsets2(input, result, one, i + 1);
			one.remove(one.size() - 1);
		}
	}

	// updated method from above in order to deal with the duplicate situation
	public static void getALlSubsetsDup(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> one, int pos) {
		result.add(new ArrayList<Integer>(one));
		if (pos == input.size()) {
			return;
		}
		for (int i = pos; i < input.size(); i++) {
			//should be i!=position, otherwise [1,2,2] will not get passed.not i-1>=0, 
			//they are different conditions.
			if (i!= position && input.get(i) == input.get(i - 1)) {
				continue;
			}
			one.add(input.get(i));
			getAllSubsets2(input, result, one, i + 1);
			one.remove(one.size() - 1);
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(1);
		input.add(2);
		input.add(0);

		// using first method
		ArrayList<ArrayList<Integer>> result0 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = getAllSubsets(input, 0, result0);
		for (ArrayList<Integer> temp : result) {
			for (Integer i : temp) {
				System.out.print(i);
			}
			System.out.println("");
		}

		// using second method
		ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
		getAllSubsets2(input, result2, new ArrayList<Integer>(), 0);
		for (ArrayList<Integer> temp : result2) {
			for (Integer i : temp) {
				System.out.print(i);
			}
			System.out.println("");
		}

		ArrayList<ArrayList<Integer>> result3 = new ArrayList<ArrayList<Integer>>();
		Collections.sort(input);
		getALlSubsetsDup(input, result3, new ArrayList<Integer>(), 0);
		for (ArrayList<Integer> temp : result3) {
			for (Integer i : temp) {
				System.out.print(i);
			}
			System.out.println("");
		}

	}
}
