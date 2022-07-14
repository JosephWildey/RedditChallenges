from collections import defaultdict

def find_highest_score(word_list):

    word_scores = []
    
    word_scores = [compute_score(word) for word in words]
    
    return max(word_scores)

def find_odd_sums(word_list):

    letterSum = 0

    odd_counts = {}

    for word in word_list:
        letterSum = compute_score(word)

        if letterSum % 2 == 1:
            odd_counts[word] = letterSum

        letterSum = 0

    print("Words with odd scores: " + str(len(odd_counts)))

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

    word_score = 0

    word_score = sum([ord(letter.lower()) - 96 for letter in word])

    return word_score
