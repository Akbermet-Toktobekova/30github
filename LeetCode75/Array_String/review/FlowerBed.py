# Input: flowerbed = [1,0,0,0,1], n = 1
# Output: true
f = [1,0,0,0,1]
n = 1

# Solution1: Easy logic but O(n) space
f = [0] + f + [0]
for i in range(1,len(f)-1):
    if f[i-1] == 0 and f[i] == 0 and f[i+1] == 0:
        f[i] = 1
        n -= 1
print(n<=0)

# good time complexity and tough logic
# f = [1,0,0,0,1]
# n = 1
# e = 0 if f[0]==1 else 1
# for i in f:
#     if i==1:
#         n -= int((e-1)/2)
#         e = 0
#     else:
#         e += 1
# n -= e//2
# print(n<=0)