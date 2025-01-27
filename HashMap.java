// Time Complexity :O(1) -Average O(N)- WORST CASE
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;
    int buckets;
    
    private int getBucket(int key){
        return Integer.hashCode(key) % buckets;
    }
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
        
    }
    
    private Node find(Node node, int key){
        Node prev = node;
        Node curr = node.next;
        while(curr !=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        //Linked list does not exist
        if(nodes[bucket]==null){
            //create dummy linked list node
            nodes[bucket]= new Node(-1,-1);
        }
        //Find the node
        Node prev = find(nodes[bucket],key);
        //the key doesn't exist
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value =value;
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(nodes[bucket] ==null){
            return -1;
        }
        Node prev = find(nodes[bucket],key);
        //the key doesn't exist
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        //key does not exist
        if(nodes[bucket]==null){
            return;
        }
        //key may or may not exist
        Node prev = find(nodes[bucket],key);
        //node does not exist
        if(prev.next == null){
            return;
        }
        //node exists
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */