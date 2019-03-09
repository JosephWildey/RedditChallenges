import java.util.Random;
import java.util.Scanner;

public class UPCGenAndChk {

    /*Technically you want as little code as possible here for
    best performance.*/
    public static void main(String[] args) {
        GenUPC();
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

        /*Display the UPC.*/
        System.out.print("The UPC is: ");
        for(int i = 0; i < 12; ++i) {
            System.out.print(arr[i]);
        }
    }
}
