class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> map2 : map.entrySet()) {
            if (map2.getValue() > nums.length / 3) {
                ans.add(map2.getKey());
            }
        }
        return ans;
    }
}