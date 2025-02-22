class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        max_candies = max(candies)  
        boolList = [(candy + extraCandies) >= max_candies for candy in candies]
        return boolList
