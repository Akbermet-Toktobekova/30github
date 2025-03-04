class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        first = float('inf')
        second = float('inf')
        
        for num in nums:
            if num <= first: 
                first = num
            elif num <= second: 
                second = num
            else:  
                return True
        
        return False

            

        # while k<l and j<(l-1) and i<(l-2):
        #     if i < j < k and nums[i] < nums[j] < nums[k]:
        #         return True
        #     else:
        #         i +=1
        #         j +=1
        #         k +=1
        # return False
