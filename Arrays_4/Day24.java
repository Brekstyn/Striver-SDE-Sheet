class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            } else {
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

}