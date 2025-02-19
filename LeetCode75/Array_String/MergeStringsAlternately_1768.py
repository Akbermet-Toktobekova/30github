class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i, j = 0 , 0
        c = []
        while i < len(word1) or j < len(word2):
            if i < len(word1):
                c.append(word1[i])
                i +=1
            if j < len(word2):
                c.append(word2[j])
                j +=1
        return ''.join(c)
    
def main():
    word1 = "abc"
    word2 = "def"
    solution = Solution()
    result = solution.mergeAlternately(word1, word2)
    print(result)  # Expected output: "adbcefgdh"

if __name__ == "__main__":
    main()