package codingProblems;

class Data {
    public Integer currDiff;
    public int closest;
    Data(){
        this.currDiff = Integer.MAX_VALUE;
        this.closest = 0;
    }
}

public class FindClosestValBST {

    public static int findClosestValueInBst(BST tree, int target) {
        Data data = new Data();
        recursiveFind(tree, target, data);
        return data.closest;
    }

    public static void recursiveFind(BST node, int target, Data data){
        if(node == null) return;
        update(node, target, data);
        recursiveFind(node.left, target, data);
        recursiveFind(node.right, target, data);
    }

    public static void update(BST node, int target, Data data){
        int difference = Math.abs(node.value - target);
        if(difference <= data.currDiff){
            data.currDiff = difference;
            data.closest = node.value;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
