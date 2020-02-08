/* Back from a long hiatus. Did you miss me? Just gets the upper scoring of Yahtzee rolls. */

import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        
        //All set for user input
        Scanner input = new Scanner(System.in);
        String uInput = "";
        
        //Ask for and get user input
        System.out.print("Enter your roll: ");
        uInput = input.next();
        
        //The information is easier to make sense of with arrays
        int[] nums = new int[uInput.length()];
        int[] scores = new int[6];
        
        //Will be necessary for breaking up the string
        int index = 0;
        
        //Keep count of the individual values for score keeping purposes
        int countOnes = 0;
        int countTwos = 0;
        int countThrees = 0;
        int countFours = 0;
        int countFives = 0;
        int countSixes = 0;
        
        //Iterates through the string, retrieving numerical values and stuffing them into a separate array.
        //Comma serves as a delimiter to make all this easier
        for(int i = 0; i < uInput.length(); ++i) {
            if (i == 0) {
                
                nums[index] = Character.getNumericValue(uInput.charAt(i));
                index++;
                
            } else if (uInput.charAt(i) == ',') {
               nums[index] = Character.getNumericValue(uInput.charAt(i+1));
               index++;
            }
        }
            
        //Get count of the amount of times each value appears in the string
        for(int i = 0; i < uInput.length(); ++i) {
            if (nums[i] == 1) {
                countOnes++;
            } else if(nums[i] == 2) {
                countTwos++;
            } else if(nums[i] == 3) {
                countThrees++;
            } else if(nums[i] == 4) {
                countFours++;
            } else if(nums[i] == 5) {
                countFives++;
            } else if(nums[i] == 6) {
                countSixes++;
            }
        }
        
        //Multiply each value by its count and stuff that product into an index in the score array for sorting later
        scores[0] = countOnes * 1;
        scores[1] = countTwos * 2;
        scores[2] = countThrees * 3;
        scores[3] = countFours * 4;
        scores[4] = countFives * 5;
        scores[5] = countSixes * 6;
        
        //Close the scanner
        input.close();
        
        //Sort the scores array in ascending order via Insertion Sort
        sort(scores);
        
        //Retrieve the last value of the sort array since it is sorted in ascending order.
        //This gives us the highest score/value possible.
        System.out.println("\nThe highest score is: " + scores[5]);
        
    }
  
    // Insertion sort algorithm, good enough for this problem      
    static void sort(int arr[]) { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }
}
