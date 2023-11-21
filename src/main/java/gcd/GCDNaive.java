package gcd;

public class GCDNaive {

    public static void main(String[] args) {
        int a = 3918848;
        int b = 1653264;


        System.out.println(getGCD(a, b));
    }

    private static int getGCD(int a, int b) {
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
