class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int start = 0;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
               start++;
                nums[start] = nums[i]; 
                cnt++;
            }
        }
        return cnt;
    }
}
