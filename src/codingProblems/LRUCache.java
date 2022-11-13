package codingProblems;

import java.util.HashMap;

class LRUCache {
    static class LRU {
        int maxSize;
        LinkedList linkedList;
        HashMap<String, Node> map;

        public LRU(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            this.linkedList = new LinkedList();
            this.map = new HashMap<>();
        }

        public void insertKeyValuePair(String key, int value) {
            checkCacheSize();
            if(map.containsKey(key)) map.get(key).value = value;
            else addNodeToCache(key, value);
            return;
        }

        public LRUResult getValueFromKey(String key) {
            if(!map.containsKey(key)) return new LRUResult(false, -1);

            Node node = map.get(key);

            if(node == linkedList.tail) linkedList.tail = node.prev;
            if(node == linkedList.head) linkedList.head = node.next;

            node.breakBonds();
            linkedList.insert(node);
            return new LRUResult(true, node.value);

        }

        public String getMostRecentKey() {
            return linkedList.head.key;
        }

        public void addNodeToCache(String key, int value){
            Node node = new Node(key, value);
            map.put(key, node);
            linkedList.insert(node);
        }

        public void checkCacheSize(){
            if(map.size() >= maxSize) {
                if(linkedList.tail != null) map.remove(linkedList.tail.key);
                linkedList.evict();
            }
        }

        public void logCache(String funcName){
            System.out.println(funcName);
            //HashMap
            System.out.println("HASH-MAP");
            System.out.println("Max Size: " + maxSize);
            System.out.println("Current Size: " + map.size());
            System.out.print("Contents: ");
            map.forEach((k, v) -> {
                System.out.print("[(" + k + "," + v.value + ")] ");
                // System.out.print( "(" + v.prev + "," + v.next + ")]  ");
            });
            System.out.println(" ");

            System.out.println("============");

            //Linked-List
            System.out.println("LINKED-LIST");

            String headKey = linkedList.head != null ? linkedList.head.key : "null";
            int headVal = linkedList.head != null ? linkedList.head.value : -1;
            String headNextKey = linkedList.head.next != null ? linkedList.head.next.key : "null";
            String headPrevKey = linkedList.head.prev != null ? linkedList.head.prev.key : "null";


            String tailKey = linkedList.tail != null ? linkedList.tail.key : "null";
            int tailVal = linkedList.tail != null ? linkedList.tail.value : -1;
            String tailNextKey = linkedList.tail.next != null ? linkedList.tail.next.key : "null";
            String tailPrevKey = linkedList.tail.prev != null ? linkedList.tail.prev.key : "null";


            String headInfo = "Head: " + "[(" + headKey + "," + headVal + ")" + " (" + headPrevKey + "," + headNextKey + ")] ";
            String tailInfo = "Tail: " + "[(" + tailKey + "," + tailVal + ")" + " (" + tailPrevKey + "," + tailNextKey + ")] ";

            System.out.println(headInfo);
            System.out.println(tailInfo);

            String result = "";
            Node currNode = linkedList.head;
            while(currNode != null){
                result += "[" + "key:" + currNode.key + " " + "value:" + currNode.value +  "]" + "->";
                currNode = currNode.next;
            }

            System.out.print("List: ");
            System.out.print(result);
            System.out.print("END");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insert(Node node){
        if(this.head == null && this.tail == null){
            this.head = node;
            this.tail = node;
        }

        else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }

    public void evict(){
        if(this.tail == null) return;

        if(this.tail.next == null && this.tail.prev == null) {
            this.head = null;
            this.tail = null;
        }

        else {
            Node newTail = this.tail.prev;
            this.tail.prev = null;
            if(newTail != null) newTail.next = null;
            this.tail = newTail;
        }

    }
}

class Node {
    String key;
    int value;
    Node next;
    Node prev;

    public Node(String key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public void breakBonds(){
        if(this.prev != null) this.prev.next = this.next;
        if(this.next != null) this.next.prev = this.prev;

        this.next = null;
        this.prev = null;
    }

}
