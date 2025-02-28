class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        l = list (s.split(" "))
        i = 0
        while i < (len(l)):
            if l[i] == "":
                l.remove(l[i])
                i -= 1
            i +=1  
        return len(l[len(l)-1])
