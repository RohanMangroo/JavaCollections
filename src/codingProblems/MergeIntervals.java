package codingProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MergeIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>(Collections.singletonList(intervals[0]));

        for(int i = 1; i < intervals.length; i++){
            final int[] potentialMerge = intervals[i];
            final int[] currInterval = mergedIntervals.get(mergedIntervals.size()-1);

            if(potentialMerge[0] <= currInterval[1]) this.merge(potentialMerge, currInterval);
            else mergedIntervals.add(potentialMerge);
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public void merge(int[] potentialMerge, int[] currInterval){
        currInterval[0] = Math.min(potentialMerge[0], currInterval[0]);
        currInterval[1] = Math.max(potentialMerge[1], currInterval[1]);
    }
}
