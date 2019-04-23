import java.util.Scanner;
import java.util.Stack;

class NumProcessor {

    public static void main(String[] args) {
        /*Get user input and stuff*/
        Scanner usrNum = new Scanner(System.in);
        int processedNum = 0, outputNum;
        Stack<Integer> nums = new Stack<Integer>();

        System.out.print("Please input a number: ");
        processedNum = usrNum.nextInt();

        while(processedNum > 0) {
            nums.push(processedNum % 10 + 1);
            processedNum /= 10;
        }

        while(!nums.empty()) {
            outputNum = nums.pop();
            System.out.print(outputNum);
        }

    }
}
