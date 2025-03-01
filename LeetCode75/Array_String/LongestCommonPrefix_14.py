class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        l = len(strs)
        res = ""
        if l == 0: return ""
        if l == 1: return strs[0]
        strs.sort()
        first, last  = strs[0], strs[l-1]
        for i in range(min(len(first), len(last))):
            if first[i] == last[i]:
                res += first[i]
            else: 
                return res
        return res
        


            
