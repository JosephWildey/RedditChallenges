import java.util.Scanner;

class CratePacker {

    public static void main(String[] args) {
    /*Setting ourselves up for success and to get user input */
        Scanner BigCrateX = new Scanner(System.in);
        Scanner BigCrateY = new Scanner(System.in);
        Scanner littleCratesX = new Scanner(System.in);
        Scanner littleCratesY = new Scanner(System.in);
        int length, width, lengths, widths, finalLength, finalWidth, AmtOfBoxes;

        System.out.print("What is the length of the large crate? ");
        length = BigCrateX.nextInt();

        System.out.print("What is the width of the large crate? ");
        width = BigCrateY.nextInt();

        System.out.print("What are the lengths of the little crates? ");
        lengths = littleCratesX.nextInt();

        System.out.print("What are the widths of the little crates? ");
        widths = littleCratesY.nextInt();

        /*The math involved is just simple division. If you let the length of the big box
        with all the stuff getting stuffed in be X, and the length of the boxes being put in
        be x, then figuring out how many is a matter of X/x * Y/y, if you let Y and y represent
        the widths in similar fashion.*/
        finalLength = length/lengths;
        finalWidth = width/widths;
        AmtOfBoxes = finalLength * finalWidth;

        System.out.print(AmtOfBoxes);

    }
}
