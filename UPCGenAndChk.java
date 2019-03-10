import java.util.Random;
import java.util.Scanner;

public class UPCGenAndChk {

    /*Technically you want as little code as possible here for
    best performance.*/
    public static void main(String[] args) {
        menu();
    }

    public static void GenUPC() {
        int num = 0, evenSum = 0, oddSum = 0, M = 0;
        Random rand = new Random(System.currentTimeMillis());

        int[] arr = new int[12];

        /* Fill the integer array with 11 random digits between 0 and 9. */
        for(int i = 0; i < 11; ++i) {
            num = rand.nextInt(10);
            arr[i] = num;
        }

        for(int i = 0; i < 11; ++i) {
            if((i+1) % 2 == 0)
                evenSum += arr[i];
            else if((i+1) % 2 == 1)
                oddSum += arr[i];
        }

        /*Once the loop is complete we multiply the sum of odd indexes by 3.*/
        oddSum *= 3;

        /*Then we add the sum of even indexes.*/
        oddSum += evenSum;

        /*We need M to equal modulo 10 of the last operation.*/
        M = oddSum % 10;

        /*The value of the check digit bit depends on the value of M.
        If M is zero, then that digit is 0. If M is not 0, it is 10 - M. */
        if(M != 0)
            arr[11] = 10 - M;
        else
            arr[11] = M;

        /* If something messes up it won't show a possibly incorrect
        UPC. Rather, it'll just tell the user. */
        if(checkUPC(arr) == true) {
            System.out.print("The UPC is: ");
            for(int i = 0; i < 12; ++i) {
                System.out.print(arr[i]);
            }
        } else {
            //Recursion in the case of failure. User won't know if the program ever failed.
            GenUPC();
        }
    }

    /* Basically the same thing as generating a UPC. Except we are not
    altering the array. Just computing and checking the digit bit with
    what we would expect. */
    public static boolean checkUPC(int[] arr) {
        int num = 0, evenSum = 0, oddSum = 0, M = 0;
        for(int i = 0; i < 11; ++i) {
            if((i+1) % 2 == 0)
                evenSum += arr[i];
            else if((i+1) % 2 == 1)
                oddSum += arr[i];
        }

        /*Once the loop is complete we multiply the sum of odd indexes by 3.*/
        oddSum *= 3;

        /*Then we add the sum of even indexes.*/
        oddSum += evenSum;

        /*We need M to equal modulo 10 of the last operation.*/
        M = oddSum % 10;

        /*The value of the check digit bit depends on the value of M.
        If M is zero, then that digit is 0. If M is not 0, it is 10 - M. */
        M = 10 - M;

        /* Since the function is not a 'void' a return value is expected.
        The function is just checking the validity of the UPC so boolean
        makes sense as a return function, and if the UPC is valid it'll
        return true. */
        if(arr[11] == M) {
            return true;
        } else {
            return false;
        }
    }

    /* Generates output based on user input while minimizing code present
    in the main function. Making the program prettier.*/
    public static void menu() {
        /* Setting ourselves up for success */
        Scanner usrInput = new Scanner(System.in);
        Scanner UPCInput = new Scanner(System.in);
        int usrChoice = 0;
        int[] arr = new int[12];
        String usrUPC;

        /* Get the user's choice */
        System.out.print("Enter 1 to generate a UPC or 2 to check your 12-digit UPC: ");
        usrChoice = usrInput.nextInt();

        /* Exact equivalence works here. */
        switch(usrChoice) {
        case 1:
            GenUPC();
            break;
        case 2:
            System.out.print("Please input your UPC: ");
            usrUPC = UPCInput.nextLine();
            ChkUsrUPC(usrUPC);
            break;
        default:
            System.out.print("Sorry, please run the program again.");
            break;
        }
    }

    /* This will check a UPC that a user inputs. Basically just asks for the UPC,
    stores it as a string, then converts it to an array of ints. Super ugly tho. */
    public static void ChkUsrUPC(String UPC) {
        int[] upcNums = new int[12];

        for(int i = 0; i < 12; ++i) {
            //Ugly beast.
            upcNums[i] = Character.getNumericValue(UPC.charAt(i));
        }

        if(checkUPC(upcNums) == true) {
            System.out.print("The UPC is valid.");
        } else {
            System.out.print("Invalid UPC.");
        }
    }
}
