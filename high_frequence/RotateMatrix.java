public class RotateMatrix {
    public static void rotate(int[][] matrix) {

        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (left < right) {
            rotateEdge(matrix, left++, top++, bottom--, right--);
        }
    }

    private static void rotateEdge(int[][] matrix, int left, int top, int bottom, int right) {
        int times = right - left;
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = matrix[top][left + i];
            matrix[top][left + i] = matrix[bottom - i][left];
            matrix[bottom - i][left] = matrix[bottom][right - i];
            matrix[bottom][right - i] = matrix[top + i][right];
            matrix[top + i][right] = tmp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("============");
        printMatrix(matrix);
    }
}
