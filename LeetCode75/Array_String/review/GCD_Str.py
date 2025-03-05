import math

str1, str2 = "ABCABC", "ABC"
gcd = 0
if (str1 + str2) != (str2 + str1): 
    print ("")
elif str1 == str2:
    print (str1)
else:
    gcd = math.gcd(len(str1),len(str2))
    print (str2[:gcd])
