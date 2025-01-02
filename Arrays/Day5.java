class Solution {
    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {

        int i = 0; // red
        int j = 0; // white
        int k = nums.length - 1; // blue

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                // swap with k
                swap(nums, j, k);
                k--;
            } else {
                // nums[j] == 0
                // swap with nums[i];
                swap(nums, j, i);
                i++;
                j++;
            }
        }
    }
}