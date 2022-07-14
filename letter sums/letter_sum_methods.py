from __future__ import annotations
from statistics import mode

def compute_score(word: str) -> str:

    word_score = 0

    word_score = sum([ord(letter.lower()) - 96 for letter in word])

    return word_score

def find_highest_score(words: list) -> list:

    word_scores = []
    
    word_scores = [compute_score(word) for word in words]
    
    return max(word_scores)

def find_odd_sums(words: list) -> list:

    odd_score_words = []
    
    odd_score_words = [word for word in words if compute_score(word) % 2 == 1]
    
    return len(odd_score_words)

def find_words_mode(words: list) -> list:
    word_scores = []
    
    midpoint = len(words) // 2
    
    left_side = words[:midpoint]
    
    right_side = words[midpoint:]
    
    word_scores = [compute_score(word) for word in left_side]
    
    word_scores += [compute_score(word) for word in right_side]
    
    return mode(word_scores)
