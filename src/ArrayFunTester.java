import java.util.Arrays;

public class ArrayFunTester{

    public static void main(String[] args){
        int[] arr = {5, 10, 3, 9, 15, 4};

        ArrayFun af = new ArrayFun(arr);

        System.out.println("Expected Nums: [5, 10, 3, 9, 15, 4]");
        System.out.println("Actual Nums:" + Arrays.toString(af.getNums()));

        System.out.println("Expected mixedNums: [5, 6, 3, 45, 3, 4]");
        System.out.println("Actual mixedNums:" + Arrays.toString(af.getMixedNums()));

        System.out.println("Expected greatestDiff: 42");
        //System.out.println("Actual greatestDiff: " + af.greatestDiff());
        System.out.println("Actual greatestDiff: " + af.greatestDiff2());
    }
}
