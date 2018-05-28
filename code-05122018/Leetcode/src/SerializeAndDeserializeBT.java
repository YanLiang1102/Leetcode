import java.util.*;
import java.util.LinkedList;

class TR1 {
	String val;
	TR1 left;
	TR1 right;

	TR1(String val) {
		this.val = val;
	}
}

public class SerializeAndDeserializeBT {
    //serialzie the BST in a bfs version.
	public static LinkedList<String> serializeBT(TR1 root) {
		LinkedList<String> result = new LinkedList<String>();
		Queue<TR1> q = new LinkedList<TR1>();
		q.add(root);
		while (!q.isEmpty()) {
			TR1 curr = q.poll();
			result.add((curr.val));
			if (curr.val != "null") {
				if (curr.left != null) {
					q.add(curr.left);
				} else {
					q.add(new TR1("null"));
				}
				if (curr.right != null) {
					q.add(curr.right);
				} else {
					q.add(new TR1("null"));
				}

			}
		}
		return result;
	}

	// given arraylist serialize this into a tree
	public static TR1 deserializeBT(LinkedList<String> arr) {
		Queue<TR1> q = new LinkedList<TR1>();
		TR1 root;
		root = new TR1(arr.poll());
		q.add(root);
		while (!arr.isEmpty() && !q.isEmpty()) {
			TR1 currNode = q.poll();
			// TR1 currNode=new TR1(currStr);
			String left = arr.poll();
			String right = arr.poll();
			if (left != "null") {
				TR1 leftNode = new TR1(left);
				currNode.left = leftNode;
				q.add(leftNode);
			}
			if (right != "null") {
				TR1 rightNode = new TR1(right);
				currNode.right = rightNode;
				q.add(rightNode);
			}
		}
		return root;

	}

	public static void InOrder(TR1 root) {
		System.out.print(root.val + ",");
		if (root.left != null) {
			InOrder(root.left);
		}
		if (root.right != null) {
			InOrder(root.right);
		}
	}

	public static void main(String[] args) {
		TR1 n1 = new TR1("1");
		TR1 n2 = new TR1("2");
		TR1 n3 = new TR1("3");
		TR1 n4 = new TR1("4");
		TR1 n5 = new TR1("5");
		TR1 n6 = new TR1("6");
		TR1 n7 = new TR1("7");
		n1.left = n2;
		n1.right = n3;
		n2.left=n4;
		n3.right=n5;
		n5.left=n6;
		n5.right=n7;
		InOrder(n1);
		System.out.println(" ");
		LinkedList<String> rst = serializeBT(n1);
		for (String s : rst) {
			System.out.println(s + ",");
		}
		
		TR1 root=deserializeBT(rst);
		InOrder(root);
		
	}
}
