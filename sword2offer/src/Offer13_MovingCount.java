public class Offer13_MovingCount {
    public static int movingCount(int m, int n, int k) {
        //
        if (m < 0 || n < 0 || k < 0) return -1;
        boolean[][] used = new boolean[m][n];
        return backTrack(0, 0, m, n, k, used);
    }

    private static int backTrack(int row, int col, int m, int n, int k, boolean[][] used) {
        if (row < 0 || col < 0 || row >= m || col >= n || cal(row) + cal(col) > k || used[row][col]) return 0;

        used[row][col] = true;
        return 1 + backTrack(row - 1, col, m, n, k, used)
                + backTrack(row + 1, col, m, n, k, used)
                + backTrack(row, col + 1, m, n, k, used)
                + backTrack(row, col - 1, m, n, k, used);
    }

    private static int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(1,2,1));
        System.out.println(movingCount(2,3,1));
        System.out.println(movingCount(3, 1, 0));
    }
}
