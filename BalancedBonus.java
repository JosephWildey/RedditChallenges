/*I'm gonna work on a bonus version here in a few. Easy challenge.*/

import java.util.Scanner;

public class BalancedBonus {

    public static void main(String[] args) {
        /*Gotta take in user input, and count the x's and y's.*/
        Scanner strInput = new Scanner(System.in);
        String usrString = "";
        int len = 0;
        boolean balanced = true;

        /*Need user input.*/
        System.out.print("Please input your string of characters: ");
        usrString = strInput.nextLine();
        strInput.close();

        int[] numArr = new int[26];
        char[] letArr = new char[26];

        /*Fun part: loop through the string and count the x's or y's.
        Since this is the basic challenge where a letter is x or y,
        we can just assume any non-x character is y.*/
        for(int i = 0; i < usrString.length(); ++i) {
            switch(usrString.charAt(i)) {
            case 'a':
                numArr[0] += 1;
                break;
            case 'b':
                numArr[1] += 1;
                break;
            case 'c':
                numArr[2] += 1;
                break;
            case 'd':
                numArr[3] += 1;
                break;
            case 'e':
                numArr[4] += 1;
                break;
            case 'f':
                numArr[5] += 1;
                break;
            case 'g':
                numArr[6] += 1;
                break;
            case 'h':
                numArr[7] += 1;
                break;
            case 'i':
                numArr[8] += 1;
                break;
            case 'j':
                numArr[9] += 1;
                break;
            case 'k':
                numArr[10] += 1;
                break;
            case 'l':
                numArr[11] += 1;
                break;
            case 'm':
                numArr[12] += 1;
                break;
            case 'n':
                numArr[13] += 1;
                break;
            case 'o':
                numArr[14] += 1;
                break;
            case 'p':
                numArr[15] += 1;
                break;
            case 'q':
                numArr[16] += 1;
                break;
            case 'r':
                numArr[17] += 1;
                break;
            case 's':
                numArr[18] += 1;
                break;
            case 't':
                numArr[19] += 1;
                break;
            case 'u':
                numArr[20] += 1;
                break;
            case 'v':
                numArr[21] += 1;
                break;
            case 'w':
                numArr[22] += 1;
                break;
            case 'x':
                numArr[23] += 1;
                break;
            case 'y':
                numArr[24] += 1;
                break;
            case 'z':
                numArr[25] += 1;
                break;
            }
        }

        for(int i = 0 ; i < 25; ++i)
            if(numArr[i] != numArr[i+1] && numArr[i] > 0 && numArr[i+1] > 0) {
                balanced = false;
                break;
            }

        if(balanced == false) {
            System.out.println("false.");
        } else {
            System.out.println("true.");
        }

    }
}
