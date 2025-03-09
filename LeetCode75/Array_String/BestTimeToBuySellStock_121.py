class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, min, result = len(prices), prices[0], 0

        for i in range(1,l):
            if (min > prices[i]) :
                min = prices[i]
            result = max(res, prices[i] - min)
        return result


        
