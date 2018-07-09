import java.util.*;
/***idea is use linkedlist with a hashtable
 * 
 * @author yan
 *
 */
class LRU {
    //most recent node will be at the tail
    private class Node
    {
        int key;
        int value;
        Node prev=null;
        Node next=null;
        Node(int key,int value)
        {
            this.value=value;
            this.key=key;
        }
    }
    
    Node head;
    Node dummy;
    HashMap<Integer, Node> hash;
    int capacity;
    public LRU(int capacity1) {
        //this will be the dummy head
        //this.head=new Node(0,0);
        this.dummy=new Node(0,0);
        head=dummy;
        this.hash=new HashMap<Integer, Node>();
        this.capacity=capacity1;
    }
    
    public int get(int key) {
        if(hash.containsKey(key))
        {
            moveToTail(hash.get(key));
            return hash.get(key).value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {        
        if(hash.size()==capacity&& !hash.containsKey(key))
        {
            removeHead();
            addToLinkedList(key,value);
        }
        
        else
        {
            if(!hash.containsKey(key)){
                addToLinkedList(key,value);
            }
            else
            {
                hash.get(key).value=value;
                moveToTail(hash.get(key));
            }
        }
        
    }
    
    public void addToLinkedList(int key, int value)
    {
        Node newnode=new Node(key,value);
        head.next=newnode;
        newnode.prev=head;
        hash.put(key,newnode);
        head=newnode;
        
    }
    
    public void removeHead()
    {
        Node head1=dummy.next;
        if(head1!=null)
        {
        //forget to remove the key from the hash	
        hash.remove(head1.key);
        Node next=head1.next;
        dummy.next=next;
        head1.next=null;   
        
        }
        
    }
    
    public void moveToTail(Node current)
    {
        head.next=current;
        current.prev.next=current.next;
        if(current.next!=null)
        {
        current.next.prev=current.prev;    
        }
        
        current.next=null;
        current.prev=head;
        head=current;
    }
    
    public static void main(String[] args)
    {
       LRU cache=new LRU(2);
       cache.put(1, 1);
       cache.put(2, 2);
       cache.get(1);
       cache.put(3, 3);
       //cache.get(2);
       
    }
    
    
}
