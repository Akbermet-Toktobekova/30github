
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 0: return True
        if len(nums) == 1: return True
        # if len(nums) == 2: return True
        cur = nums[1]
        for i in range(len(nums)):
            
            if cur<len(nums):
                cur += nums[cur]
            if cur == (len(nums)-1):
                return True
            if len(nums) == 2 and nums[cur] == 2:
                return True
        return False
