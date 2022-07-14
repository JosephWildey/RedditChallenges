from letter_sum_methods import compute_score
from letter_sum_methods import find_highest_score
from letter_sum_methods import find_odd_sums
from letter_sum_methods import find_words_mode

file = open("C:\\Users\\JoeWi\\OneDrive\\Documents\\enable1.txt", "r")

file_words = file.read().splitlines()

file.close()

if __name__ == '__main__':

    find_words_mode(file_words)

    find_highest_score(file_words)

    find_odd_sums(file_words)
