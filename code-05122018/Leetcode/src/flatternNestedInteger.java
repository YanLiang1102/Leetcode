/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    //I wrote it in like 20 mins by myself but it is very slow how to enhance?
    Stack<NestedInteger> stack;
    Queue<Integer> q;
    public NestedIterator(List<NestedInteger> nestedList) {
         stack=new Stack<NestedInteger>();
         q=new LinkedList<Integer>();
         for(int i=nestedList.size()-1;i>=0;i--)
         {
             stack.push(nestedList.get(i));
         }
         while(!stack.isEmpty())
         {
             NestedInteger curr=stack.pop();
             if(curr.isInteger())
             {
                 q.add(curr.getInteger());
             }
             else
             {
                 List<NestedInteger> l=curr.getList();
                 for(int j=l.size()-1;j>=0;j--)
                 {
                     stack.push(l.get(j));
                 }
                 //stack.push(curr.getList());
             }
         }
    }
    

    @Override
    public Integer next() {
        if(hasNext())
        {
            return q.poll();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        //if(!stack.isEmpty())
        return !q.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
