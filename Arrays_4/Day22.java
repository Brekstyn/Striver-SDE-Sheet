class Solution {
    int maxLen(int arr[]) {
        // code here
        int maxL = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxL = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    maxL = Math.max(maxL, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }

        }
        return maxL;
    }
}