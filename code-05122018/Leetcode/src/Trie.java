import java.util.*;

//the trie structure will support startWith, search, and insert;
class TrieNode
{
	HashMap<Character,TrieNode> neighbor;
	//to check if this is the end of the word
	boolean leaf;
	public TrieNode()
	{
		//this.value=value;		
		leaf=false;
		neighbor=new HashMap<Character, TrieNode>();
	}
	
}
public class Trie {

	
     TrieNode root;
     public Trie()
     {
    	 root=new TrieNode();
     }
     public void insert(String word)
     {
    	 char[] chararray=word.toCharArray();
    	 TrieNode treeroot=root;
    	 for(int i=0;i<chararray.length;i++)
    	 {
    		 char curr=chararray[i];
    		 HashMap<Character, TrieNode> neigh=treeroot.neighbor;
    		 if(!neigh.containsKey(curr))
    		 {
    			 neigh.put(curr,new TrieNode());
    		 }
    		 else
    		 {
    			 //neigh.get(curr).add(new TrieNode());
    		 }
    		 treeroot=neigh.get(curr);
    		 //then it is the last one, need to mark the triendeo as left
    		 if(i==chararray.length-1)
    		 {
    			 treeroot.leaf=true;
    		 }
    		 
    	 }
     }
     
     /**
      * search if it  can find the query string in the trie
     * @param query
     * @return
     */
     public boolean find(String query)
     {
    	 char[] chararray=query.toCharArray();
    	 TrieNode treeroot=root;
    	 for(int i=0;i<chararray.length;i++)
    	 {
    		 char curr=chararray[i];
    		 HashMap<Character,TrieNode> neigh=treeroot.neighbor;
    		 if(!neigh.containsKey(curr))
    		 {
    			 return false;
    		 }
    		 else
    		 {
    			 treeroot=neigh.get(curr);
    		 }
    		 
    	 }
    	 return treeroot.leaf;
     }
     
     public boolean startwith(String query)
     {
    	 char[] chararray=query.toCharArray();
    	 TrieNode treeroot=root;
    	 for(int i=0;i<chararray.length;i++)
    	 {
    		 char curr=chararray[i];
    		 HashMap<Character,TrieNode> neigh=treeroot.neighbor;
    		 if(!neigh.containsKey(curr))
    		 {
    			 return false;
    		 }
    		 else
    		 {
    			 treeroot=neigh.get(curr);
    		 }
    		 
    	 }
    	 return true;
    	 
     }
     
     public static void main(String[] args)
     {
    	 Trie t=new Trie();
    	 t.insert("good");
    	 t.insert("google");
    	 t.insert("yan");
    	 
    	 if(t.startwith("yan2"))
    	 {
    		 System.out.println("yes I find it!");
    	 }
    	 else
    	 {
    		 System.out.println("nope!!");
    	 }
     }
}
