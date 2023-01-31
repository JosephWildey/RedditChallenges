import java.util.Scanner;

class CratePacker {

    public static void main(String[] args) {
    /*Setting ourselves up for success and to get user input */
        Scanner BigCrateX = new Scanner(System.in);
        Scanner BigCrateY = new Scanner(System.in);
	    Scanner BigCrateZ = new Scanner(System.in);
        Scanner littleCratesX = new Scanner(System.in);
        Scanner littleCratesY = new Scanner(System.in);
	    Scanner littleCratesZ = new Scanner(System.in);
        int length, width, depth, lengths, widths, depths, finalLength, finalWidth, finalDepth, AmtOfBoxes;

        System.out.print("What is the length of the large crate? ");
        length = BigCrateX.nextInt();

        System.out.print("What is the width of the large crate? ");
        width = BigCrateY.nextInt();

	  System.out.print("What is the depth of the large crate? ");
        depth = BigCrateZ.nextInt();

        System.out.print("What are the lengths of the little crates? ");
        lengths = littleCratesX.nextInt();

        System.out.print("What are the widths of the little crates? ");
        widths = littleCratesY.nextInt();

	  System.out.print("What are the depths of the little crates? ");
	  depths = littleCratesZ.nextInt();

        /*The math involved is just simple division. If you let the length of the big box
        with all the stuff getting stuffed in be X, and the length of the boxes being put in
        be x, then figuring out how many is a matter of X/x * Y/y, if you let Y and y represent
        the widths in similar fashion.*/
        finalLength = length/lengths;
        finalWidth = width/widths;
	    finalDepth = depth/depths;
        AmtOfBoxes = finalLength * finalWidth * finalDepth;

        System.out.print(AmtOfBoxes + " Small crates can fit into the large crate.");

    }
}
