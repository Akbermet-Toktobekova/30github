class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start]) {
                start++;
                nums[start] = nums[i];  
            }
        }
        
        return start + 1;  
    }
}
