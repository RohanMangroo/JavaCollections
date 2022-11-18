package codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LongestIncreasingSubsequence {
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        MyData data = new MyData(array.length);
        data.fillData(array);
        List<Integer> longestIncreasingSubsequence = data.createSubSequence(array);
        return longestIncreasingSubsequence;
    }
}

class MyData {
    int[] lengths;
    int[] seq;
    int maxLength;
    int lastPos;

    MyData(int length){
        this.lengths = new int[length];
        this.seq = new int[length];
        this.maxLength = Integer.MIN_VALUE;
        this.lastPos = 0;

        Arrays.fill(this.lengths, 1);
        Arrays.fill(this.seq, Integer.MIN_VALUE);
    }

    public void fillData(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[i] > array[j] && this.lengths[j] + 1 > this.lengths[i]){
                    this.lengths[i] = this.lengths[j]+1;
                    this.seq[i] = j;

                    if(lengths[i] > this.maxLength){
                        this.maxLength = lengths[i];
                        this.lastPos = i;
                    }
                }
            }
        }
    }

    public List<Integer> createSubSequence(int[] array){
        final List<Integer> result = new ArrayList<>();

        int currPos = this.lastPos;

        while(currPos != Integer.MIN_VALUE){
            result.add(array[currPos]);
            currPos = this.seq[currPos];
        }
        Collections.reverse(result);
        return result;
    }
}