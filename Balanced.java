import java.util.Scanner;

public class Balanced {

    public static void main(String[] args) {
        Scanner strInput = new Scanner(System.in);
        String usrString = "";
        int xCounter = 0, yCounter = 0;

        System.out.print("Please input your string of characters: ");
        usrString = strInput.nextLine();
        strInput.close();

        for(int i = 0; i < usrString.length(); ++i) {
            if(usrString.charAt(i) == 'x') {
                ++xCounter;
            } else {
                ++yCounter;
            }
        }
        if(xCounter == yCounter) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
