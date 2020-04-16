import java.util.ArrayList;

public class Digits {
    /** The list of digits from the number used to construct this object.
     * The digits appear in the list in the same order in which they appear
     * in the original number.
     */
    private ArrayList<Integer> digitList;

    /** Constructs a Digits object that represents num.
     * Precondition: num >= 0
     */

    public Digits(int num) {
        digitList = new ArrayList<Integer>();
        int number = num;
        if (number == 0) {
            digitList.add(0, Integer.valueOf(0));
        } else {
            while (number > 0) {
                digitList.add(0, Integer.valueOf(number % 10));
                number /= 10;
            }
        }
    }

    /** Returns true if the digits in this Digits object are in
     * strictly increasing order;
     * false otherwise.
     */

    public boolean isStrictlyIncreasing() {
        /* to be implemented in part (b) */
        boolean increasing = true;
        for (int i = 1; i < digitList.size(); i++) {
            if (digitList.get(i) <= digitList.get(i - 1)) {
                increasing = false;
            }
        }
        return increasing;
    }
}