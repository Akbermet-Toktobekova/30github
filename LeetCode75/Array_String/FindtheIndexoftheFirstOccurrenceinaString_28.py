class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack == needle : return 0
        if needle in haystack : 
            return haystack.find(needle)
        return -1
        
