import java.util.Scanner;

public class RGBToHex {
    public static int redCount = 0, greenCount = 0, blueCount = 0;

    public static void main(String[] args) {
        Scanner redVal = new Scanner(System.in);
        Scanner greenVal = new Scanner(System.in);
        Scanner blueVal = new Scanner(System.in);
        Scanner Cont = new Scanner(System.in);

        int intRedVal = 0, intGreenVal = 0, intBlueVal = 0,
        redSize = 0, greenSize = 0, blueSize = 0;

        System.out.print("How many red values do you have? ");
        redSize = Cont.nextInt();

        int[] redVals = new int[redSize];

        /* do...while loops execute at least once. This means
        I can collect the user data while the loop is executing and
        continue executing the loop until I have collected all of the
        user's data. */
        do {
            System.out.print("Please insert the red value(0-255): ");
            intRedVal = redVal.nextInt();
            redVals[redCount] = intRedVal;
            ++redCount;
        } while(redCount < redSize);

        System.out.print("How many green values do you have? ");
        greenSize = Cont.nextInt();

                int[] greenVals = new int[greenSize];

        do {
            System.out.print("Please insert the green value(0-255): ");
            intGreenVal = greenVal.nextInt();
            greenVals[greenCount] = intGreenVal;
            ++greenCount;
        } while(greenCount < greenSize);



        System.out.print("How many blue values do you have? ");
        blueSize = Cont.nextInt();

                int[] blueVals = new int[blueSize];

        do {
            System.out.print("Please insert the blue value(0-255): ");
            intBlueVal = blueVal.nextInt();
            blueVals[blueCount] = intBlueVal;
            ++blueCount;
        } while(blueCount < blueSize);

        /* Prevents possibly unnecessary math. */
        if(redSize > 1) {
            intRedVal = averageArray(redVals,redSize);
        }
        if(greenSize > 1) {
            intGreenVal = averageArray(greenVals,greenSize);
        }
        if(blueSize > 1) {
            intBlueVal = averageArray(blueVals,blueSize);
        }

        System.out.print('#');
        System.out.print(firstHexDigit(intRedVal));
        System.out.print(secondHexDigit(intRedVal));
        System.out.print(firstHexDigit(intGreenVal));
        System.out.print(secondHexDigit(intGreenVal));
        System.out.print(firstHexDigit(intBlueVal));
        System.out.print(secondHexDigit(intBlueVal));

        }


    /* A quick function for arithmetic averaging. Return type
    is consistent with the type of number used to perform the math. */
    public static int averageArray(int[] arr, int count) {
        int avgVal = 0;
        for(int i = 0; i < count; ++i) {
                avgVal += arr[i];
        }

        return avgVal/count;
    }

    /* Simple division is required for the first digit.
    If a value is below 10 (0-9) the value will be directly
    converted. Otherwise, we will subtract 10 from the value
    and add it to the ASCII value for capital A. */
    public static char firstHexDigit(int val) {
        val = val/16;
        char hexValue;
        if(val >= 0 && val <= 9) {
            hexValue = (char) (val + '0');
        } else if(val > 9 && val < 16) {
            /* Keeping the final value between A-F. */
            val -= 10;
            /* Add 17 because digits start at 48. So the lowest
            val will be is 48, but we want to raise its min to 65. */
            hexValue = (char)(val + 17 + '0');
        } else {
            System.out.println("Invalid character.");
            hexValue = 'Q';
        }
        return hexValue;
    }

    /* For this one, nearly teh same as above. The math
    is just changes slightly. Q is for Quit Your Bullshit. */
    public static char secondHexDigit(int val) {
        val = val % 16;
        char hexValue;
        if(val >= 0 && val <= 9) {
            hexValue = (char) (val + '0');
        } else if(val > 9 && val <= 15) {
            /* Keeping the final value between A-F. */
            val -= 10;
            /* Add 17 because digits start at 48. So the lowest
            val will be is 48, but we want to raise its min to 65. */
            hexValue = (char)(val + 17 + '0');
        } else {
            System.out.println("Invalid character.");
            hexValue = 'Q';
        }
        return hexValue;
    }
}
