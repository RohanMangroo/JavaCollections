import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* Primitive types */
        char character = 'R'; // 16-bit, single quotes
        boolean bool = true; // 1-bit default: false
        byte myByte = 127; // 8-bit signed, minimum: -128 maximum: 127 (inclusive) default: 0
        short myShort = 32767; // 16-bit signed, minimum: -32,768 maximum: 32,767 (inclusive) default: 0
        int num = 10; // 32-bit signed, minimum: -2^31 maximum: 2^31 (inclusive) default: 0
        long myLong = 100000; // 64-bit signed, minimum: -2^63 maximum: 2^63 default: 0L
        float myFloat = 3.14f; // 32-bit floating point number default: 0.0f
        double myDouble = 3.14d; //64-bit floating point number default 0.0d


        /* Non-Primitive types */
        String myString = "Rohan"; // Class, Compiler will turn string literal into String class */
        int[] numArray = new int[10]; // <T>[] name = new <T>[size], size cannot be changed during runtime, access and changed elements via square brackets

        /* Collection types*/
        //Lists
        ArrayList<String> arrayList = new ArrayList<>(); //Dynamic sized array
        LinkedList<Integer> linkedList = new LinkedList<>(); // Doubly linked list, Insertion:O(1) Search:O(n) Deletion:O(1)

        //Sets - Holds UNIQUE elements
        HashSet<String> hashSet = new HashSet<>(); // A HashTable with unique elements, hence the hashSET, O(1) CRUD, elements MUST BE OBJECTS
        TreeSet<Integer> treeSet = new TreeSet<>(); // A self-balancing Binary Search Tree. In-Order traversal when returning elements. O(log n) CRUD

        //Map
        HashMap<String, Integer> hashMap = new HashMap<>(); // HashMap, allows duplicates O(1) CRUD
        TreeMap<String, Integer> treeMap = new TreeMap<>(); // Seems to be a Binary Search Tree that has mappings in the node
    }
}