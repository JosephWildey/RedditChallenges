from letter_sum_methods import letter_Count
from letter_sum_methods import find_highest_score
from letter_sum_methods import find_odd_sums

file = open("..\\enable1.txt", "r")

file_words = file.read().splitlines()

file.close()

if __name__ == '__main__':

    find_highest_score(file_words)

    find_odd_sums(file_words)

# grab user input
    user_word = input("Enter a word: ")
# process user input
    letter_Count(user_word)
