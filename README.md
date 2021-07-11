# RedditChallenges
These are my solutions to programming challenges I find on Reddit. They aren't always the most efficient solutions,
but they are my own. I try to write tons of comments to help others understand. 

I'm also not necessarily looking for the most efficient answer anyway. I'm a hobbyist programmer and try to have fun
with the stuff I write. 

# UPC Generator and Checker
This program is self-explanatory. It will either generate a random 12-digit UPC when asked or verify a 12-digit UPC by calculating and comparing the check (final) digit. This combined both a beginner and intermediate Reddit challenge into a single program. One challenge was computing just the final digit given 11 characters, and the other was generating an entire UPC from scratch. 

The Luhn Algorithm for UPCs is pretty straightforward, and doesn't really require much except for the check-digit to be a multiple of ten. The sequence of digits prior to that check digit can be any combination, but the check digit itself is computed in a particular manner based on those digits. For example, you sum the odd and even indexes independently, but thanks to computing we can do that independently within the same loop. There is unfortunately some redundancy due to how I handled the Luhn Algorithm and the speed at which I completed this challenge. However, it does include recursion which I feel should count for something and I did warn you that my solutions will not always be pretty.

# Addititive Persistence
The addititive persistence of a value is the amount of times you can add all the single integers in the value to reach a single digit. I tried to minimize loops as much as I could.

# Balanced/Balanced Bonus
This program just checked to make sure that characters in a given string appear in the string an equal amount of times. First it started with x and y and the bonus includes all lowercase characters in the English alphabet.

# RGBToHex
This program takes the integer values of RGB (0-255 for Red, Green, and Blue) and outputs the hexidecimal string. It will average the values given for a specific color, if you give more than one value. Otherwise, it will just process the initial value given. I wanted to make the program a bit more flexible, but it would have been ugly and unnecessarily taxing. 
An update for this at some point to combine hex strings is coming, someday. Misread the "bonus" part of the challenge it seems.

# CratePacker
Determines the amount of crates you could stuff into a larger crate given the dimensions of both the smaller crates and the large crate. Only works in two dimensions at the moment. 

# NumsProcessor
 Adds 1 to each digit in an integer. Uses Java's implementation of Stack because I was too lazy to write my own linked list. Reads 10 as 1,0 and not 10. Just for reference.

# Yahtzee Upper Scoring
Analyzes a yahtzee roll and retrieves the highest value possible based on the count of occurrences of each individual value in the roll. 

# Taxation
This is a simple marginal rate taxation calculator. Income brackets/caps and taxation rates are stored in a CSV file for easy editing. The calculator does not currently handle values beyond the highest ceiling, which at the moment is $100,000 because it loops through all the brackets and rates in the csv file. 
