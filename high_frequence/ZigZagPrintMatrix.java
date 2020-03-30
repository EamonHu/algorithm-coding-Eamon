public class ZigZagPrintMatrix {

    private static void printMatrixZigZag(int[][] matrix) {
        int mR = 0;
        int mC = 0;
        int nR = 0;
        int nC = 0;
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        boolean flag = false;
        while(mR <= rows){
            printLevel(matrix, mR, mC, nR, nC, flag);
            mR = mC == cols ? mR + 1: mR;
            mC = mC == cols ? mC: mC + 1;
            nC = nR == rows ? nC + 1: nC;
            nR = nR == rows ? nR : nR + 1;
            flag = !flag;
        }
        System.out.println();
    }

    private static void printLevel(int[][] matrix, int mR, int mC, int nR, int nC, boolean flag) {
        if(flag){
            while(mR != nR + 1){
                System.out.print(matrix[mR++][mC--] + " ");
            }
        }else{
            while(nR != mR - 1){
                System.out.print(matrix[nR--][nC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrixZigZag(matrix);
    }
}
