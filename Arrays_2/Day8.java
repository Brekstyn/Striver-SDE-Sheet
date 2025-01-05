class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // skip merged intervals
            if (!merged.isEmpty() && end <= merged.get(merged.size() - 1).get(1)) {
                continue;
            }

            // checking for further intervals

            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            merged.add(Arrays.asList(start, end));
        }

        int res[][] = new int[merged.size()][2];

        for (int i = 0; i < res.length; i++) {

            for (int j = 0; j < 2; j++) {
                res[i][j] = merged.get(i).get(j);
            }
        }
        return res;
    }
}