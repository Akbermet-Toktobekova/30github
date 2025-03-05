#Solution1 - time is the best

w1, w2 = "abc", "pqra"
i, j = 0, 0
l1, l2 = len(w1), len(w2)
res = ""
while i<l1 and j<l2:
    res += w1[i] + w2[j]
    i +=1
    j +=1
res += w1[i:] + w2[j:]
print(res)

#Solution2 - memory is the best
from itertools import zip_longest
print( "".join(a+b for a, b in zip_longest(w1,w2,fillvalue="-"))) #if one string is shorter, it will use "-" as a placeholder.
