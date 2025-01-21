class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int maxL = 1;
        for(int val : set){
            if(!set.contains(val - 1)){//then the val is the start of the sequence
                int currL = 1;
                int num = val;

                while(set.contains(num + 1)){
                    currL += 1;
                    num += 1;
                }
                maxL = Math.max(maxL, currL);
            }
        }
        return maxL;
    }
}