from __future__ import annotations
from statistics import mode

def compute_score(word: str) -> str:
    word_score = sum([ord(letter.lower()) - 96 for letter in word])

    return word_score

def find_highest_score(words: list) -> list:
    midpoint = len(words) // 2
    
    left_side = [compute_score(word) for word in words[:midpoint]]

    right_side = [compute_score(word) for word in words[midpoint:]]

    if max(left_side) > max(right_side):
         return max(left_side)
    else:
         return max(right_side)

def find_odd_sums(words: list) -> list:
    midpoint = len(words) // 2

    left_side = words[:midpoint]

    right_side = words[midpoint:]

    odd_word_scores = [word for word in left_side if compute_score(word) % 2 == 1]

    odd_word_scores = [word for word in right_side if compute_score(word) % 2 == 1]

    return len(odd_word_scores)

def find_words_mode(words: list) -> list:
    midpoint = len(words) // 2
    
    left_side = words[:midpoint]
    
    right_side = words[midpoint:]
    
    word_scores = [compute_score(word) for word in left_side]
    
    word_scores += [compute_score(word) for word in right_side]
    
    return mode(word_scores)
