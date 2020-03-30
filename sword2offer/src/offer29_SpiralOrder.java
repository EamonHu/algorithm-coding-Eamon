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
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void spiralOrderPrint(int[][] matrix) {
        // 左上角的行和列
        int top = 0;
        int left = 0;
        // 右下角的行和列
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            printEdge(matrix, left++, top++, right--, bottom--);
        }
    }

    private static void printEdge(int[][] matrix, int left, int top, int right, int bottom) {
        if (left == right) {
            for (int i = top; i <= bottom; i++) {
                System.out.println(matrix[i][left] + " ");
            }
        } else if (bottom == top) {
            for (int i = left; i <= right; i++) {
                System.out.println(matrix[top][i]);
            }
        } else {
            for (int i = left; i <= right; i++) System.out.print(matrix[top][i] + " ");
            // 从上向下
            for (int i = top + 1; i <= bottom; i++) System.out.print(matrix[i][right] + " ");
            // 从右向左
            for (int i = right - 1; i >= left; i--) System.out.print(matrix[bottom][i]+" ");
            // 从下向上
            for (int i = bottom - 1; i > top; i--) System.out.print(matrix[i][left]+ " ");
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }
}
