import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200_Islands {

    //dfs
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }

    // bfs
    public static int numIslands(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return 0;

        int N = matrix.length;
        int M = matrix[0].length;
        int nums = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    nums++;
                    matrix[i][j] = 0;
                    Queue<Integer> neighbor = new LinkedList<>();
                    neighbor.add(i * M + j);
                    while (!neighbor.isEmpty()) {
                        int id = neighbor.remove();
                        int row = id / M;
                        int col = id % M;
                        if (row - 1 >= 0 && matrix[row - 1][col] == 1) {
                            neighbor.add((row - 1) * M + col);
                            matrix[row - 1][col] = 0;
                        }
                        if (row + 1 < N && matrix[row + 1][col] == 1) {
                            neighbor.add((row + 1) * M + col);
                            matrix[row + 1][col] = 0;
                        }
                        if (col - 1 >= 0 && matrix[row][col - 1] == 1) {
                            neighbor.add(row * M + col - 1);
                            matrix[row][col - 1] = 0;
                        }
                        if (col + 1 < M && matrix[row][col + 1] == 1) {
                            neighbor.add(row * M + col + 1);
                            matrix[row][col + 1] = 0;
                        }
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(numIslands(m1));

        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
        System.out.println(numIslands(m2));

    }

}
