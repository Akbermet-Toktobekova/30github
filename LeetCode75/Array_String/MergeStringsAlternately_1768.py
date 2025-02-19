class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        res = ""
        l1 = len(word1)
        l2 = len(word2)
        for i in range( max(l1,l2)):
            if i < l1:
                res += word1[i]
            if i < l2:
                res += word2[i]
        return res
    
def main():
    word1 = "abc"
    word2 = "def"
    solution = Solution()
    result = solution.mergeAlternately(word1, word2)
    print(result)  # Expected output: "adbcefgdh"

if __name__ == "__main__":
    main()