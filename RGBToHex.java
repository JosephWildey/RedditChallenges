import java.util.Scanner;

public class RGBToHex {

    public static void main(String[] args) {
        Scanner redVal = new Scanner(System.in);
        Scanner greenVal = new Scanner(System.in);
        Scanner blueVal = new Scanner(System.in);

        int intRedVal = 0, intGreenVal = 0, intBlueVal = 0;
        char firstRedVal, secondRedVal, firstGreenVal, secondGreenVal,
        firstBlueVal, secondBlueVal;

        System.out.print("Please insert the red value (0-255): ");
        intRedVal = redVal.nextInt();
        System.out.print("Please insert the green value (0-255): ");
        intGreenVal = greenVal.nextInt();
        System.out.print("Please insert the red value (0-255): ");
        intBlueVal = blueVal.nextInt();

        System.out.print('#');
        System.out.print(firstHexDigit(intRedVal));
        System.out.print(secondHexDigit(intRedVal));
        System.out.print(firstHexDigit(intGreenVal));
        System.out.print(secondHexDigit(intGreenVal));
        System.out.print(firstHexDigit(intBlueVal));
        System.out.print(secondHexDigit(intBlueVal));

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
