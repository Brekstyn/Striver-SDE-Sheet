class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ans.add(first);
            return ans;
        }
        for (int i = 0; i < numRows; i++) {
            Integer col[] = new Integer[i + 1];
            Arrays.fill(col, 1);
            ans.add(Arrays.asList(col));
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j < ans.get(i).size() - 1; j++) {
                ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
        }
        return ans;

    }
}

// Approach 2

class Solution {

    public List<Integer> generateRow(int row) {
        long ans = 1;

        List<Integer> temp = new ArrayList<>();
        temp.add(1);

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            temp.add((int) ans);
        }
        return temp;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            res.add(generateRow(i));
        }
        return res;
    }
}