# Input: s = "the sky is blue"
# Output: "blue is sky the"

#Sol1: 
s = " the sky is  blue     "
s = (s.split())
s.reverse()
print (s)

#Sol2: takes less memory
words = s.split()
words.reverse()
print (' '.join(words))

#Sol3: takes less memory and good in time
print( " ".join(s.split()[::-1]) )