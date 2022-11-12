import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {

    public static int[] nestedLoop(int[] array, int targetSum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                final int numOne = array[i];
                final int numTwo = array[j];
                if (numOne + numTwo == targetSum) return new int[]{numOne, numTwo};
            }
        }
        return new int[0];
    }

    public static int[] sortedArray(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length-1;

        while(left < right){
            final int numOne = array[left];
            final int numTwo = array[right];
            final int currTotal = numOne + numTwo;

            if(currTotal == targetSum) return new int[] {numOne, numTwo};
            else if(currTotal < targetSum) left++;
            else right--;
        }

        return new int[0];
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashSet<Integer> compTable = new HashSet<>();
        //I think HashSet uses Hashtable but all the values are labeled as "PRESENT"
        //And you only get the key when

        for(int i = 0; i < array.length; i++){
            final int currVal = array[i];
            final int comp = targetSum - currVal;
            if(compTable.contains(comp)) return new int[] {currVal, comp};
            else compTable.add(currVal);
        }
        return new int[0];
    }
}
