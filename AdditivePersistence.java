import java.util.Scanner;

public class AdditivePersistence {

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

        /*Gotta init our array. */
        char[] arr = new char[len];

        /*Gotta flesh out the array with values. */
        for(int i = 0; i < len; ++i)
            arr[i] = number.charAt(i);

        System.out.println(addDigits(arr));
    }

    public static int addDigits(char[] arr) {
        int num = 0, counter = 0, len = arr.length;
        char num2;
        for(int i = 0; i < len; ++i) {
                num2 = arr[i];
                num += Character.getNumericValue(num2);
            }
            ++counter;
            System.out.println(num);
        if(len > 1) {
            addDigits(arr, counter);
            ++counter;
        }
        return counter;
    }

    public static void addDigits(char[] arr, int counter) {
        int num = 0, len = arr.length;
        char num2;
        for(int i = 0; i < len; ++i) {
                num2 = arr[i];
                num += Character.getNumericValue(num2);
            }
        ++counter;
    }
}
