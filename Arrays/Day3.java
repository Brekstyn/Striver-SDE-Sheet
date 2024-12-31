class Solution {

    public void reverse(int nums[], int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        /*
         * steps
         * 
         * step 1: indx1 = nums[i] < nums[i+1];
         * step 2: indx2 = nums[i] > nums[idx1];
         * step 3: swap (indx1,indx2)
         * step 4: reverse from idx1 + 1 ----> end
         * 
         */

        int idx1 = -1;
        int idx2 = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }

        if (idx1 == -1) {
            reverse(nums, 0, n - 1); // reverse complete nums
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx1]) {
                idx2 = i;
                break;
            }
        }

        // swap idx1 and idx2
        swap(nums, idx1, idx2);

        // reverse idx+1 to end
        reverse(nums, idx1 + 1, n - 1);

    }
}