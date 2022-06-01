def find_highest_score(word_list):

    letterSum = 0

    for word in word_list:
        letterSum = compute_score(word)

        if letterSum > bestScore:
            bestScore = letterSum
            bestWord = word

        letterSum = 0

    print(bestWord + " " + str(bestScore))

def find_odd_sums(word_list):

    letterSum = 0

    odd_counts = {}

    for word in word_list:
        letterSum = compute_score(word)

        if letterSum % 2 == 0:
            continue
        else:
            odd_counts[word] = letterSum

        letterSum = 0

    print("Words with odd scores: " + str(len(odd_counts)))

# Simple method that provides a value between 1 and 26 for each letter in the alphabet and sums the value.
def letter_Count(word):

# intiate the sum variable

    letterSum = 0

# Loop through the provided word in the argument, if a non-alpha character is caught raise an exception.
# Otherwise return the sum of the letters.
    for letter in word:

        # simple check to make sure the ascii value of each character is within the range of lowercase letters
        if ord(letter.lower()) < 97 or ord(letter.lower()) > 122:
            raise Exception("Invalid character detected.")
        # if every character is a letter add up the values to be returned to the user
        else:
            letterSum += ord(letter.lower()) - 96

# output sum of letter values if an exception has not been raised
    print(word + " has a score of: " + str(letterSum))

def find_words_mode(word_list):

    # This will be used for storing a word's score later on
    letterSum = 0

    # a better way of avoiding key errors than a try-except block
    word_math_mode = defaultdict(int)

    # breaking up the list into two parts here
    midpoint = len(word_list) // 2

    # populate one list with the left half of the words
    left_side = word_list[:midpoint]
    
    # populate one list with the right half of the words
    right_side = word_list[midpoint:]

    # go through the left half of the original list, computing scores and adding them to the dictionary
    for word in left_side:
        
        # get and return a word's score
        letterSum = compute_score(word)
        
        # thanks to defaultdict this will never return an error, and keeps track of how many words have a given letter score
        word_math_mode[letterSum] += 1

        # reset the score variable and go at again until the entire list is done
        letterSum = 0

    # go through the right half of the original list, computing scores and adding them to the dictionary
    for word in right_side:
        letterSum = compute_score(word)

        word_math_mode[letterSum] += 1

        letterSum = 0

    # iterate through the entire dicitonary and look for the most common letter sum in the dictionary
    for word in word_math_mode:
        if word_math_mode.get(word) > 1921:
            print("The most common leter sum in the list is: " + str(word) +
                  " and " + str(word_math_mode[word]) + " words have that sum")

def compute_score(word):

    Sum = 0

    for letter in word:
        Sum += ord(letter.lower()) - 96

    return Sum
