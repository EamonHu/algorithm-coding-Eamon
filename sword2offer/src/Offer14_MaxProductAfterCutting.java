public class Offer14_MaxProductAfterCutting {
    public int cuttingRope(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        // products
        int[] products = new int[n + 1];

        // 存储每种结果，遇到以下情况最好的解决方案是不剪段
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[i - j] * products[j];
                if (max < product) max = product;
            }
            products[i] = max;
        }
        max = products[n];
        return max;
    }

    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        long res = 0;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

}
