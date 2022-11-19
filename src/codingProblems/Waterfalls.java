package codingProblems;

import java.util.Arrays;
import java.util.HashSet;

class Waterfalls {
    public double[] waterfallStreams(double[][] array, int source) {
        FlowData data = new FlowData(array[0].length);
        flow(array, 0, source, 100, true, data);
        return data.result;
    }

    public String createKey(int row, int col){
        return String.format("[%s, %s]", row, col);
    }

    public void flow(double[][] array, int row, int col, double amount, boolean split, FlowData data){
        if(row < 0 || row >= array.length || col < 0 || col >= array[0].length) return;
        if(array[row][col] == 1) return;

        final String key = this.createKey(row, col);
        if(data.seen.contains(key)) return;

        data.seen.add(key);
        if(row == array.length-1) {data.seen.remove(key); data.result[col] += amount; return;}

        if(array[row+1][col] == 1) {
            if(split == true) amount /= 2;
            this.flow(array, row,  col-1, amount, false, data);
            this.flow(array, row, col+1, amount, false, data);
        }
        else flow(array, row+1, col, amount, true, data);

        data.seen.remove(key);
    }

    class FlowData{
        HashSet<String> seen;
        double[] result;

        public FlowData(int arrayLength){
            this.seen = new HashSet<String>();
            this.result = new double[arrayLength];
            Arrays.fill(this.result, 0);
        }
    }
}
