class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        dist={'b':0, 'a':0, 'l':0, 'o':0, 'n':0}
        for char in text:
            if char == 'b':
                dist[char]=dist.get(char)+1
            if char == 'a':
                dist[char]=dist.get(char)+1
            if char == 'l':
                dist[char]=dist.get(char)+1
            if char == 'o':
                dist[char]=dist.get(char)+1
            if char == 'n':
                dist[char]=dist.get(char)+1
        dist['l']=dist.get('l')//2
        dist['o']=dist.get('o')//2
        return min(dist.get('b'),dist.get('a'),dist.get('l'),dist.get('o'),dist.get('n'))
