class LFUCache {

 //the porblem of using a priorityQueue that I am thinking about is when you remove something you can not get a time complexity of O(1)
    //messed up I got the idea at least but I don't know why it turns wrong
    //It has a bug inside of it , but I don't have time to debug and figure out what is going onhere.need more research later.
    class Node
    {
        int value;
        int count;
        int key;
        int index; // this will be the index in the arraylist
        public Node( int key,int value, int count)
        {
            this.value=value;
            this.count=count;
            this.key=key;
            
        }
    }
    int capacity;
    HashMap<Integer,Node> nodemap;
    int min; //in oroder to get the hashset for the min that you want to delete
    //key is the count, kind of the bucket sort idea for top k frequency items, LinkedHashSet will reserve the input order
    HashMap<Integer,LinkedHashSet<Integer>> countmap;
    public LFUCache(int capacity) {
     this.capacity=capacity;
     this.nodemap=new HashMap<Integer, Node>();
        //a linked list of the key will beenought
     this.countmap=new HashMap<Integer,LinkedHashSet<Integer>>();
    }
    
    public int get(int key) {
        if(nodemap.containsKey(key))
        {
            //need to update teh count in the count map
            
            //get the node from the count map
            Node curr=nodemap.get(key);
            
            //LinkedHashSet<Node> set=map.get(curr.count);
            //udpate the count on this node
            update(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity==0)
        {
            return;
        }
        //udpate the node if the key already exit
        if(nodemap.containsKey(key))
        {
            Node node=nodemap.get(key);
            node.value=value;
            update(node);
            return;
        }
        //remove one record
        if(nodemap.size()==capacity)
        {
            // System.out.println(value);
            // System.out.println(nodemap.size());
            // System.out.println(capacity);
            LinkedHashSet<Integer> s=countmap.get(min);
            System.out.println(min);
            System.out.println(nodemap.size());
            //this is the ollder element in the linkedHashSet
            int last=s.iterator().next();
            //System.out.println(last.value);
            s.remove(last);
            //also remove the node from the, the remove for a hashMap is O(1) 
            nodemap.remove(last);
        }
        add(key,value);
    }
    //add a valueto the structure
    public void add(int key, int value)
    {
        Node newnode=new Node(key,value,1);
        nodemap.put(key, newnode);
        //add this to the count map
        if(!countmap.containsKey(1))
        {
            LinkedHashSet<Integer> n=new LinkedHashSet<Integer>();
            countmap.put(1,n);
            min=1;
        }
        countmap.get(1).add(key);
        update(newnode);
        
    }
    
    public void update(Node node)
    {
        LinkedHashSet<Integer> set=countmap.get(node.count);
        //this set remove is not going to be O(1) for sure I think, the only good thing is it will remain the order 
        //int index==node.index;
        // if(index==1&&node.count==min)
        // {
        //     min++;
        // }
        set.remove(node.key);
        if(set.size()==0&&node.count==min) min++;
        node.count+=1;
        if(!countmap.containsKey(node.count))
        {
            LinkedHashSet<Integer> l=new LinkedHashSet<Integer>();
            //.add(node);
            countmap.put(node.count,l);
        }
        countmap.get(node.count).add(node.key);
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
