# Input: candies = [2,3,5,1,3], extraCandies = 3
# Output: [true,true,true,false,true] 

# Solution1: Loop
candies = [2,3,5,1,3]
d = 3
max1 = candies[0]
res = []
for i in candies:
    if i>max1:
        max1 = i
        
for i in candies:
    if i+d >= max1:
        res.append(True)
    else: 
        res.append(False)
print(res) 
        
        
# Solution2: List comprehention

max_candies = max(candies)  
boolList = [(candy + d) >= max_candies for candy in candies]
print (boolList)