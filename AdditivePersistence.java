import java.util.Scanner;

public class AdditivePersistence {
    /* Keeps track of a number's additive persistence.
    Needed out here because otherwise it's always 1+n, where
    n is the initial value.*/
    private static int counter = 1;

    public static void main(String[] args) {
        /*Gotta set ourselves up for success.*/
        String number;
        int len = 0, counter = 1;
        Scanner strInput = new Scanner(System.in);

        /*Gotta get our number. */
        System.out.print("Please input a number: ");
        number = strInput.nextLine();
        strInput.close();

        /*Only to make things prettier. */
        len = number.length();

        /*Gonna set up our array here for convenience and stuff. */
        char[] nums = new char[len];

        buildArray(number,nums);
        System.out.println(sumsCount(nums));
    }

    /*We'll run this more than once, so it makes sense
    to make it a function. */
    public static void buildArray(String sen, char[] arr) {
        int len = sen.length();
        /*Gotta init our array. */

        /*Gotta flesh out the array with values. */
        for(int i = 0; i < len; ++i)
            arr[i] = sen.charAt(i);
    }

    /*This does all the dirty work for us. It does
    the adding of digits, determines if it must be
    run again, and if so does so recursively, building
    a different array than the one initially passed
    as an argument along the way. Lastly, it then returns
    the additive persistence of a number.*/
    public static int sumsCount(char[] arr) {
        char num2;
        int len = arr.length, num = 0;
        for(int i = 0; i < len; ++i) {
            num2 = arr[i];
            num += Character.getNumericValue(num2);
        }

        String numStr = Integer.toString(num);

        len = numStr.length();

        char[] newNums = new char[len];

        if(len > 1) {
            buildArray(numStr,newNums);
            sumsCount(newNums);
            ++counter;
        }

        return counter;
    }
}
