from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        l = len(nums)
        answer = [1] * l
        
        prefix = 1 
        for i in range(l):
            answer[i] = prefix
            prefix *= nums[i]
            
        suffix = 1
        for i in range(l-1,-1,-1):
            answer[i] *= suffix
            suffix *=  nums[i]
            
        return answer
    
solution = Solution()
nums = [1, 2, 3, 4]
print(solution.productExceptSelf(nums))  # Output: [24, 12, 8, 6]