package codingProblems;

class IndexEquals {
    int minIndex;

    public IndexEquals(){
        this.minIndex = -1;
    }
    public int indexEqualsValue(int[] array) {
        int start = 0;
        int end = array.length-1;

        while(start <= end){
            int midPoint = (start + end) / 2;
            if(array[midPoint] == midPoint) { this.minIndex = midPoint;end = midPoint -1;}
            else if(array[midPoint] < midPoint) start = midPoint+1;
            else if(array[midPoint] > midPoint) end = midPoint-1;
        }
        return this.minIndex;
    }
}
