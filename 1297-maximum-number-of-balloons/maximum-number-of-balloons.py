# class Solution:
#     def maxNumberOfBalloons(self, text: str) -> int:
#         dist = {'b': 0, 'a': 0, 'l': 0, 'o': 0, 'n': 0}
#         for char in text:
#             if char in dist:
#                 dist[char] += 1
#         dist['l'] //= 2
#         dist['o'] //= 2
#         return min(dist.values())

from collections import Counter

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        counts = Counter(text)
        return min(
            counts['b'], 
            counts['a'], 
            counts['l'] // 2, 
            counts['o'] // 2, 
            counts['n']
        )