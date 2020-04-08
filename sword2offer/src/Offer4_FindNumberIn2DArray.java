public class Offer4_FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (target == matrix[row][col]) return true;
            if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
