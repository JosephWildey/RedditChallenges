import java.util.Scanner;

/** 
* @Author Joe Wildey
* @Version 6/7/2019
* Computes the additive persistence of a number, which is the number of times its terms can be added before it reaches a single digit.
*/

public class AdditivePersistence {
    /** This is the number the user will enter when prompted. */
    private static int userNum;

    /** This is the number that will be used to sum the individual terms of the user's number. */
    private static int sums;

    /** This counter will keep track of how many times we added terms to get to a single term number. */
    private static int counter = 1;
    
    
    /** Main method required for execution. */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Please enter your number: ");
        userNum = scnr.nextInt();

        AddPersistence(userNum);

        System.out.println(getCounter());

    }

    /** Does the heavy lifting by adding individual terms of a given number
    and doing so until it is a single term number (0-9). 
    * @return none
    * @param int num - the number whose additive persistence we want to compute.
    */
    public static void AddPersistence(int num) {
        while(num > 0) {
            sums += num % 10;
            num = num / 10;
        }

        num = sums;
        sums = 0;

        if(num > 9) {
            AddPersistence(num);
            ++counter;
        }
    }

    /** Gets the private int Counter for output. 
    * @return counter - an int that keeps track of how many times we added individual digits of the number.
    * @param none
    */
    public static int getCounter() {
        return counter;
    }
}
