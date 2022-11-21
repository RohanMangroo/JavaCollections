package codingProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class SameBST {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        CheckBST solution = new CheckBST();
        solution.checkBST(arrayOne, arrayTwo);
        return solution.sameBST;
    }
}

class CheckBST {
    boolean sameBST;

    public CheckBST(){
        this.sameBST = true;
    }

    public void checkBST(List<Integer> arrayOne, List<Integer> arrayTwo){
        if(!this.sameBST) return;
        if(arrayOne.size() != arrayTwo.size()) {this.sameBST = false; return;}
        if(arrayOne.size() == 0 || arrayTwo.size() == 0) return;
        if(!Objects.equals(arrayOne.get(0), arrayTwo.get(0))) {this.sameBST = false; return;}

        List<Integer> arrayOneLeft = new ArrayList<Integer>();
        List<Integer> arrayTwoLeft = new ArrayList<Integer>();

        List<Integer> arrayOneRight = new ArrayList<Integer>();
        List<Integer> arrayTwoRight = new ArrayList<Integer>();

        for(int i = 1; i < arrayOne.size(); i++){
            if(arrayOne.get(i) < arrayOne.get(0)) arrayOneLeft.add(arrayOne.get(i));
            else if (arrayOne.get(i) >= arrayOne.get(0)) arrayOneRight.add(arrayOne.get(i));

            if(arrayTwo.get(i) < arrayTwo.get(0)) arrayTwoLeft.add(arrayTwo.get(i));
            else if (arrayTwo.get(i) >= arrayTwo.get(0)) arrayTwoRight.add(arrayTwo.get(i));
        }

        this.checkBST(arrayOneLeft, arrayTwoLeft);
        this.checkBST(arrayOneRight, arrayTwoRight);

    }

}
