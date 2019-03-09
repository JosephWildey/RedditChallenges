import java.util.Random;
import java.util.Scanner;

public class UPCGenAndChk {

    /*Technically you want as little code as possible here for
    best performance.*/
    public static void main(String[] args) {
        int num = 0, evenSum = 0, oddSum = 0, M = 0;
        Random rand = new Random(System.currentTimeMillis());

        int[] arr = new int[12];

        /* Fill the integer array with 11 random digits between 0 and 9. */
        for(int i = 0; i < 11; ++i) {
            num = rand.nextInt(10);
            arr[i] = num;
        }

        /*Display the arr*/
        for(int i = 0; i < 11; ++i)
            System.out.print(arr[i]);

        System.out.println();

        /* Adding 1 to i each iteration allows me to perform a check determining
        the odd-even nature of the index without creating an empty index.*/
        for(int i = 0; i < 11; ++i) {
            if((i+1) % 2 == 0)
                evenSum += arr[i];
            else if((i+1) % 2 == 1)
                oddSum += arr[i];
        }

        System.out.println("Oddsum is: " + oddSum);

        /*Once the loop is complete we multiply the sum of odd indexes by 3.*/
        oddSum *= 3;

        System.out.println("oddSum now is: " + oddSum);

        /*Then we add the sum of even indexes.*/
        oddSum += evenSum;

        System.out.println("oddSum + evenSum is: " + oddSum);

        /*We need M to equal modulo 10 of the last operation.*/

        M = oddSum % 10;

        if(M != 0)
            arr[11] = 10 - M;
        else
            arr[11] = M;

        /*Display the UPC.*/
        for(int i = 0; i < 12; ++i) {
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println("Oddsum is: " + oddSum);
        System.out.println("Oddsum mod ten is: " + oddSum % 10);
        System.out.print("The check digit is: " + arr[11]);
    }
}
