public class ArrayFun {
    public int [] nums;
    public int [] mixedNums;

    public ArrayFun(int[] someNums){
        nums = someNums;
        mixedNums = new int[nums.length];
        //arrayMixup();
        arrayMixup2();
    }

    public int[] getNums(){
        return nums;
    }

    public int[] getMixedNums(){
        return mixedNums;
    }

    //builds and initializes mixedNums
    /* don't touch first and last elements
    if current num is EVENLY divisble by previous num, divide by previous num and multiple by next num
    if it is NOT evenly divisble, then divide by next element and store the result in current num
    otherwise, keep it the same
    */
    public void arrayMixup(){
        mixedNums[0] = nums[0];
        mixedNums[mixedNums.length - 1] = nums[nums.length-1];

        for(int i = 1; i < nums.length-1; i++){
            if (nums[i] % nums[i-1] == 0){
                int even = nums[i]/nums[i-1];
                int newEven = even*nums[i+1];
                mixedNums[i] = newEven;
            }
            else if(nums[i] % nums[i-1] != 0){
                int odd = nums[i]/nums[i+1];
                mixedNums[i] = odd;
            }
            else if (nums[i]/nums[i+1] < 1){
                mixedNums[i] = nums[i];
            }
            else {
                mixedNums[i] = 0;
            }
        }
    }

    public void arrayMixup2(){
        mixedNums[0] = nums[0];
        mixedNums[mixedNums.length - 1] = nums[nums.length-1];

        for(int i = 1; i < nums.length-1; i++){
            if (nums[i] % nums[i-1] == 0){
                int even = nums[i]/nums[i-1];
                int newEven = even*nums[i+1];
                mixedNums[i] = newEven;
            }
            else if(nums[i] > nums[i+1]){
                int curr = nums[i]/nums[i+1];
                mixedNums[i] = curr;
            }
            else {
                mixedNums[i] = nums[i];
            }
        }
    }

    //find min and max and subtract to find greatest difference.
    public int greatestDiff(){
        int big = 0;
        int small = 10000;
        int bigDif = 0;
        for (int i = nums.length - 1; i > 0; i--){
            if (nums[i] > mixedNums[i]){
                big = nums[i];
            }
            else if (nums[i] < mixedNums[i]){
                big = mixedNums[i];
            }
            else {
                big = nums[i];
            }
        }
        for (int i = nums.length - 1; i > 0; i--){
            if (nums[i] < mixedNums[i]){
                small = nums[i];
            }
            else if (nums[i] > mixedNums[i]){
                small = mixedNums[i];
            }
            else {
                big = nums[i];
            }
        }
        int newBig = Math.abs(big);
        int newSmall = Math.abs(small);
        bigDif = newBig - newSmall;
        return bigDif;
    }

    public int greatestDiff2() {
        int numsMax = findMax(nums);
        int numsMin = findMin(nums);
        int mixedMax = findMax(mixedNums);
        int mixedMin = findMin(mixedNums);

        int numsSubMix = numsMax - mixedMin;
        int mixSubNum = mixedMax - mixedMin;

        return Math.max(numsSubMix, mixSubNum);
    }
    private int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
