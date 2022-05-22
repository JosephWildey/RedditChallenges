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

    letterSum = 0

    word_math_mode = {}

    for word in word_list:
        letterSum = compute_score(word)

        try:
            word_math_mode[letterSum] += 1
        except KeyError:
            word_math_mode[letterSum] = 1

        letterSum = 0

    for word in word_math_mode:
        if word_math_mode.get(word) > 1921:
            print("The most common leter sum in the list is: " + str(word) +
                  " and " + str(word_math_mode[word]) + " words have that sum")

def compute_score(word):

    Sum = 0

    for letter in word:
        Sum += ord(letter.lower()) - 96

    return Sum
