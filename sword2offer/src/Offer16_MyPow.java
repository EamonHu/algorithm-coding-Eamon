public class Offer16_MyPow {
    public double myPow(double base, int exponent) {
        int exp = exponent;
        if (exp == 1) return base;
        // 分exp是奇数和偶数两种情况
        if ((exp & 1) == 0) { //偶数
            double temp = powerHelper(base, exp >> 1);
            return temp * temp;
        } else { // 奇数
            double temp = powerHelper(base, (exp - 1) >> 1);
            return temp * temp * base;
        }
    }

    private double powerHelper(double base, int exp) {
        if (base == 0) {
            if (exp > 0) return 0;
            else if (exp == 0) return -1;
            else throw new RuntimeException("分母不能为0");
        } else {
            if (exp > 0) return myPow(base, exp);
            else if (exp == 0) return 1;
            else return 1 / myPow(base, -exp);
        }
    }
}
