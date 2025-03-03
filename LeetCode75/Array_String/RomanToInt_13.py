class Solution:
    def romanToInt(self, s: str) -> int:
        nums = {
        'I': 1, 'V': 5, 'X': 10, 'L': 50, 
        'C': 100, 'D': 500, 'M': 1000
        }

        total = 0

        for i in range(len(s)):
            if i < len(s) - 1 and nums[s[i]] < nums[s[i + 1]]:  
                total -= nums[s[i]]
            else:
                total += nums[s[i]]

        return total
