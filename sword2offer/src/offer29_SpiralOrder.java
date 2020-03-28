public class offer29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] res = new int[rows * columns];
        int index = 0;


        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 从左向右
            for (int i = left; i <= right; i++) res[index++] = matrix[top][i];
            // 从上向下
            for (int i = top + 1; i <= bottom; i++) res[index++] = matrix[i][right];
            // 从右向左
            if (top != bottom)
                for (int i = right - 1; i >= left; i--) res[index++] = matrix[bottom][i];
            // 从下向上
            if (left != right)
                for (int i = bottom - 1; i > top; i--) res[index++] = matrix[i][left];
            left++; right--; top++; bottom--;
        }
        return res;
    }
}
