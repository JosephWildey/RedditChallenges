import java.util.Scanner;

public class AdditivePersistence {

    public static void main(String[] args) {
        /*Gotta set ourselves up for success.*/
        String number;
        int len = 0;
        Scanner strInput = new Scanner(System.in);

        /*Gotta get our number. */
        System.out.print("Please input a number: ");
        number = strInput.nextLine();
        strInput.close();

        /*Only to make things prettier. */
        len = number.length();

        /*Gotta init our array. */
        char[] arr = new char[len];

        for(int i = 0; i < len; ++i)
            arr[i] = number.charAt(i);

        while(len > 1) {
            int num = 0;
            char num2;

            for(int i = 0; i < len; ++i) {
                num2 = arr[i];
                num += Character.getNumericValue(num2);
            }

            String numStr = Integer.toString(num);

            System.out.println(numStr);

            num = Integer.parseInt(numStr);

            if(numStr.length() == 1) {
                break;
            } else {
                len = numStr.length();
                for(int i = 0; i < len; ++i) {
                    arr[i] = numStr.charAt(i);
                }
            }
        }
    }
}
