public class Offer10_FibAndFrog {

    // 斐波那契数列
    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 1, b = 1, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    // 青蛙跳台阶
    public int numWays(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 1, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
