/*I cheated and used strings. Just a head's up.*/

import java.util.Scanner;

public class AdditivePersistence {

    public static void main(String[] args) {
        /*Gotta set ourselves up for success. The counter must be initialized up here
        otherwise each iteration it'll revert back to 0 due to scope.*/
        String number;
        int len = 0, counter = 1;
        Scanner strInput = new Scanner(System.in);

        /*Gotta get our number. */
        System.out.print("Please input a number: ");
        number = strInput.nextLine();
        strInput.close();

        /*Only to make things prettier. */
        len = number.length();

        /*Gotta init our array. */
        char[] arr = new char[len];
        
        /*Gotta flesh out the array with values. */
        for(int i = 0; i < len; ++i)
            arr[i] = number.charAt(i);

        /*Might need more than one iteration. */
        while(len > 1) {
            int num = 0;
            char num2;

            /*Loop  through the array we've created and add values
            as we go through it.*/
            for(int i = 0; i < len; ++i) {
                num2 = arr[i];
                num += Character.getNumericValue(num2);
            }

            /*This makes it easier to determine the length of the value.*/
            String numStr = Integer.toString(num);

            /*Output the value.*/
            System.out.println(numStr);


            /*If we can we'll break it now. Otherwise, we'll repopulate the array
            with the old values. To avoid going beyond the scope of the string
            we'll set the length to it's new value. Anything beyond this point
            will be ignored later on too. We'll also convert the string object
            to an int here, but only if necessary. We'll also keep track of the 
            additive persistence value here.*/
            if(numStr.length() == 1) {
                System.out.println("The additive persistence is: " + counter);
                break;
            } else {
                num = Integer.parseInt(numStr);
                len = numStr.length();
                for(int i = 0; i < len; ++i) {
                    arr[i] = numStr.charAt(i);
                }
                ++counter;
            }
        }
    }
}
