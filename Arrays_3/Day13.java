class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        // reference node top right
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                // move left
                col--;
            } else {
                // move down
                row++;
            }
        }
        return false;

    }
}