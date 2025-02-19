class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        a = len(str1)
        b = len(str2)
        if (str1 + str2) != (str2 + str1): 
            return ""
        elif str1 == str2:
            return str1
        else:
            len_by_gcd = math.gcd(len(str1), len(str2))
            return str1[:len_by_gcd]
           
if __name__ == "__main__":
    solution = Solution()
    
    # Test cases
    str1 = "ABAB"
    str2 = "AB"
    print(solution.gcdOfStrings(str1, str2))  # Output: "AB"

    str1 = "ABCABC"
    str2 = "ABC"
    print(solution.gcdOfStrings(str1, str2))  # Output: "ABC"

    str1 = "LEET"
    str2 = "CODE"
    print(solution.gcdOfStrings(str1, str2))  # Output: ""