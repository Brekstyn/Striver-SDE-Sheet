public class Day11 {
    public static int[] findMissingRepeatingNumbers(int[] a) {
        // Write your code here
        int n = a.length;

        int freq[] = new int[n + 1];

        for (int num : a) {
            freq[num]++;
        }

        int missing = -1;
        int repeat = -1;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2)
                repeat = i;
            else if (freq[i] == 0)
                missing = i;
            if (missing != -1 && repeat != -1) {
                break;
            }
        }

        return new int[] { repeat, missing };
    }
}