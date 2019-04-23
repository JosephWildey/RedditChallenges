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

        /*Using mod we get the number in reverse order, but
        we're able to do this on a per-digit basis. Then we just
        add one to each digit when inputting it into the stack.
        We need to use a stack to retrieve the numbers in reverse order
        due to using mod. */
        while(processedNum > 0) {
            nums.push(processedNum % 10 + 1);
            processedNum /= 10;
        }

        /* Items popped from the top of stack are removed from the
        stack. Storing them as an int allows us to recreate the number
        that was initially input with 1s added to each digit. */
        while(!nums.empty()) {
            outputNum = nums.pop();
            System.out.print(outputNum);
        }

    }
}
