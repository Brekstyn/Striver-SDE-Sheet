class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                long startsum = nums[i] + nums[j];
                long remainingsum = target - startsum;
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    long sum = nums[start] + nums[end];
                    if (sum == remainingsum) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        start++;
                        end--;
                    } else if (sum < remainingsum) {

                        start++;
                    } else {
                        end--;
                    }

                }
            }

        }

        return result;

    }
}