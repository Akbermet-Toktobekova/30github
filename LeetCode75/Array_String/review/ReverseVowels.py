# Input: s = "IceCreAm"
# Output: "AceCreIm"
s = "IceCreAm"
v = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
vowels = []
s = list(s)
for i in s:
    if i in 'aeiouAEIOU':  
        vowels.append(i)


l = len(vowels)
for i in range(len(s)):
    if s[i] in 'aeiouAEIOU':  
        s[i] = vowels[l-1]
        l -= 1

print( ''.join(s)  )