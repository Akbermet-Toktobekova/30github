class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, min, res = len(prices), prices[0], 0

        for i in range(1,l):
            if (min > prices[i]) :
                min = prices[i]
            res = max(res, prices[i] - min)
        return res


        
