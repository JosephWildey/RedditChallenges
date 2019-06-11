import java.util.Random;
import java.util.Scanner;

public class UPCGenAndChk {

    /** Variable to store the user's choice when prompted. */
    private static int choice = 0;

    /** Long array to store all the values of the generated or provided 12-integer UPC. */
    final static long[] UPC_ARRAY = new long[12];

    /** Long to retrieve the UPC when provided by the user, because it's 12 digits large. */
    private static long userUPC = 0;

    public static void main(String[] args) {
        Menu();
    }

    /**
     * Prompts the user to make a choice.
     * @param - none
     * @return - none
    */
    public static void Menu() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter 1 to generate a UPC or 2 to check a UPC: ");
        choice = userInput.nextInt();

        switch(choice) {
        case 1:
            GenerateUPC();
            DisplayUPCArray();
            break;
        case 2:
            System.out.print("Please enter your UPC: ");
            userUPC = userInput.nextLong();
            CheckUPC(userUPC);
            break;
        default:
            System.out.print("Sorry, please try again.");
            Menu();
        }
    }


    /** This method generates a UPC, including the final digit based on previous digits.
     * @param - none
     * @return - true
    */
    public static void GenerateUPC() {
        long evenSum = 0, oddSum = 0, checkBit = 0;
        int num = 0;
        Random randGen = new Random(System.currentTimeMillis());

        for(int i = 0; i < 11; ++i) {
            num = randGen.nextInt(10);
            if (i % 2 == 0) {
                UPC_ARRAY[i] = num;
                evenSum += num;
            } else {
                UPC_ARRAY[i] = num;
                oddSum += num;
            }
        }

        checkBit = (oddSum * 3 + evenSum) % 10;

        if(checkBit != 0)
            checkBit = 10 - checkBit;

        UPC_ARRAY[11] = checkBit;
    }

    /**
     * This will check the UPC provided by the user.
     * @param - UPC, UPC to be broken up to be stored into the array and checked for validity.
     * @return - false
     *
    */
    public static void CheckUPC(long UPC) {
        long evenSum = 0, oddSum = 0, checkBit = 0;
        for(int i = 11; i >= 0; --i) {
            if((UPC % 10) % 2 == 0) {
                UPC_ARRAY[i] = UPC % 10;
                UPC = UPC / 10;
            } else {
                UPC_ARRAY[i] = UPC % 10;
                UPC = UPC / 10;
            }
        }

        for(int i = 0; i < 11; ++i) {
            if(i % 2 == 0)
                evenSum += UPC_ARRAY[i];
            else
                oddSum += UPC_ARRAY[i];
        }

            checkBit = (oddSum * 3 + evenSum) % 10;

            if(checkBit != 0)
                checkBit = 10 - checkBit;

            if(checkBit == UPC_ARRAY[11])
                System.out.print("The UPC is valid.");
            else
                System.out.print("The UPC is invalid.");
    }

    /** Gets the user UPC.
     * @param - none
     * @return - userUPC, the UPC that was fed into the array.
    */
    public static long getUPC() {
            return userUPC;
    }

    /**
    * Returns the UPC Array when a UPC is generated instead of supplied.
    * @param - none
    * @return - none
    */
    public static void DisplayUPCArray() {
        for(int i = 0; i <= 11; ++i)
            System.out.print(UPC_ARRAY[i]);
    }
}
